package io.devinbox.sample;

import io.devinbox.client.*;
import io.devinbox.client.api.MailboxesApi;
import io.devinbox.client.api.MessagesApi;
import io.devinbox.client.model.*;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.internet.MimeBodyPart;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * DevInbox Java Client - Complete Usage Example
 * Demonstrates creating mailbox, sending email via SMTP, and receiving via API
 *
 * To run this sample you need to have a DevInbox account and API key.
 * You can get it from your DevInbox dashboard at https://devinbox.io
 * Once you have the API key, you can set it in the DEVINBOX_API_KEY environment variable.
 *
 * This script will create a temporary mailbox, send an email via SMTP, and receive it via API.
 * It will also test template parsing with the 'onboarding' template.
 *
 * You need to create a template in your DevInbox dashboard with the name 'onboarding' and the following content:
 *
 * Body (pay attention to whitespaces):
 * ```
 * <html>
 * <body>
 *     <h2>Hello {{ user_name }},</h2>
 *     <p>This is a simple test message to verify email delivery.</p>
 *     <p>If you receive this, the system is working correctly.</p>
 * </body>
 * </html>
 * ```
 *
 * Subject:
 * ```
 * Welcome {{ user_name }}!
 * ```
 *
 * Then you can run the sample using the following command:
 * mvn compile exec:java
 */
public class ExampleUsage {

    private static final String SMTP_SERVER = "smtp.devinbox.io";
    private static final int SMTP_PORT = 587;
    private static final String API_BASE_URL = "https://api.devinbox.io";

    public static void main(String[] args) {
        try {
            runCompleteWorkflow();
        } catch (Exception ex) {
            System.err.println("\n❌ Test failed with error: " + ex.getMessage());
            System.err.println("Error type: " + ex.getClass().getName());
            
            if (ex instanceof ApiException) {
                ApiException apiEx = (ApiException) ex;
                System.err.println("HTTP Status: " + apiEx.getCode());
                System.err.println("Response body: " + apiEx.getResponseBody());
            }
            
            System.exit(1);
        }
    }

    private static void runCompleteWorkflow() throws Exception {
        // Get API key from user
        String apiKey = getApiKey();
        
        System.out.println("\n🔧 Configuring API client with key: " + apiKey.substring(0, Math.min(8, apiKey.length())) + "...");
        
        // 1. Configure the API client
        ApiClient apiClient = new ApiClient();
        apiClient.updateBaseUri(API_BASE_URL);
        
        // Set API key using request interceptor
        apiClient.setRequestInterceptor(requestBuilder -> {
            requestBuilder.header("X-API-Key", apiKey);
        });
        
        // Create API instances
        MailboxesApi mailboxesApi = new MailboxesApi(apiClient);
        MessagesApi messagesApi = new MessagesApi(apiClient);
        
        System.out.println("✅ API client configured successfully!");
        
        // 2. Create a temporary mailbox
        System.out.println("\n📧 Creating a temporary mailbox...");
        MailboxCreateModel tempMailbox = new MailboxCreateModel();
        MailboxViewModel mailboxData = mailboxesApi.createMailbox(tempMailbox, null);
        
        if (mailboxData == null || mailboxData.getKey() == null || mailboxData.getPassword() == null) {
            throw new IllegalStateException("Failed to create mailbox - response is invalid");
        }
        
        System.out.println("   ✅ Temporary mailbox created!");
        System.out.println("   📋 Key: " + mailboxData.getKey());
        System.out.println("   🔑 Password: " + mailboxData.getPassword());
        System.out.println("   📧 Email Address: " + mailboxData.getKey() + "@devinbox.io");
        
        String mailboxKey = mailboxData.getKey();
        String mailboxPassword = mailboxData.getPassword();
        String mailboxEmail = mailboxKey + "@devinbox.io";
        
        // 3. Check that the mailbox is empty
        System.out.println("\n📊 Checking that mailbox is empty...");
        MessageCountResult countResponse = messagesApi.getMessageCount(mailboxKey, null);
        
        if (countResponse == null || countResponse.getCount() == null) {
            throw new IllegalStateException("Failed to get message count");
        }
        
        int messageCount = countResponse.getCount().getInteger();
        System.out.println("   ✅ Message count: " + messageCount);
        
        if (messageCount != 0) {
            throw new IllegalStateException(
                "Mailbox is not empty! Expected 0 messages, got " + messageCount + 
                ". This is a critical error as we just created the mailbox.");
        }
        System.out.println("   ✅ Mailbox is empty as expected!");
        
        // 4. Send email to the mailbox via SMTP
        System.out.println("\n📤 Sending test email to " + mailboxEmail + "...");
        boolean emailSent = sendEmailViaSmtp(mailboxKey, mailboxPassword, mailboxEmail, true);
        
        if (!emailSent) {
            throw new IllegalStateException("Failed to send email via SMTP. This is a critical test failure.");
        }
        
        // 5. Wait a moment for email to be processed
        System.out.println("\n⏳ Waiting for email to be processed...");
        TimeUnit.SECONDS.sleep(2);
        
        // 6. Check that the email was received
        System.out.println("\n📬 Checking if email was received...");
        
        MessageCountResult countResponseAfter = messagesApi.getMessageCount(mailboxKey, null);
        
        if (countResponseAfter == null || countResponseAfter.getCount() == null) {
            throw new IllegalStateException("Failed to get message count after sending");
        }
        
        int messageCountAfter = countResponseAfter.getCount().getInteger();
        System.out.println("   📊 Message count after sending: " + messageCountAfter);
        
        if (messageCountAfter <= messageCount) {
            throw new IllegalStateException(
                "Email was not received! Expected count > " + messageCount + 
                ", got " + messageCountAfter + ". This indicates SMTP or email processing issues.");
        }
        System.out.println("   ✅ Email was received successfully!");
        
        // Get the latest message
        System.out.println("\n📋 Retrieving the received email...");
        GetMessagesSkipParameter skipParam = new GetMessagesSkipParameter(0);
        GetMessagesSkipParameter takeParam = new GetMessagesSkipParameter(1);
        MessagesViewModel messagesResponse = messagesApi.getMessages(mailboxKey, skipParam, takeParam, null);
        
        if (messagesResponse == null || messagesResponse.getMessages() == null || 
            messagesResponse.getMessages().isEmpty()) {
            throw new IllegalStateException(
                "No messages found despite count increase. This indicates an API retrieval issue.");
        }
        
        MessageViewModel latestMessage = messagesResponse.getMessages().get(0);
        System.out.println("   ✅ Email retrieved successfully!");
        System.out.println("   📧 From: " + (latestMessage.getFrom() != null ? String.join(", ", latestMessage.getFrom()) : "N/A"));
        System.out.println("   📧 To: " + (latestMessage.getTo() != null ? String.join(", ", latestMessage.getTo()) : "N/A"));
        System.out.println("   📧 Subject: " + (latestMessage.getSubject() != null ? latestMessage.getSubject() : "N/A"));
        System.out.println("   📧 Received: " + latestMessage.getReceived());
        System.out.println("   📧 Size: " + (latestMessage.getBody() != null ? latestMessage.getBody().length() : 0) + " characters");
        
        if (latestMessage.getSubject() == null || latestMessage.getFrom() == null || 
            latestMessage.getFrom().isEmpty() || latestMessage.getTo() == null || 
            latestMessage.getTo().isEmpty()) {
            throw new IllegalStateException("Email is missing required fields (subject, from, or to)");
        }
        
        System.out.println("   📋 Message type: " + (latestMessage.getIsHtml() != null && latestMessage.getIsHtml() ? "HTML" : "Text"));
        if (latestMessage.getBody() != null) {
            String preview = latestMessage.getBody().length() > 100 
                ? latestMessage.getBody().substring(0, 100) + "..." 
                : latestMessage.getBody();
            System.out.println("   📋 Body content: " + preview);
        }
        
        if (latestMessage.getBody() == null || latestMessage.getBody().isEmpty()) {
            throw new IllegalStateException("Message body is empty");
        }
        
        // Show preview of email content
        if (latestMessage.getBody() != null) {
            String preview = latestMessage.getBody().length() > 200 
                ? latestMessage.getBody().substring(0, 200) + "..." 
                : latestMessage.getBody();
            System.out.println("   📄 Content preview: " + preview);
        }
        
        // 7. Test getting single message with template parsing
        System.out.println("\n🔍 Testing single message retrieval with 'onboarding' template...");
        try {
            MessageParsedViewModel parsedMessage = messagesApi.getSingleMessageWithTemplate(
                mailboxKey, "onboarding", null);
            
            if (parsedMessage == null) {
                throw new IllegalStateException("Template parsing failed - parsed message is null");
            }
            
            System.out.println("   ✅ Template parsing successful!");
            System.out.println("   📧 From: " + (parsedMessage.getFrom() != null ? String.join(", ", parsedMessage.getFrom()) : "N/A"));
            System.out.println("   📧 To: " + (parsedMessage.getTo() != null ? String.join(", ", parsedMessage.getTo()) : "N/A"));
            System.out.println("   📧 Subject: " + parsedMessage.getSubject());
            System.out.println("   📧 Body: " + parsedMessage.getBody());
            System.out.println("   📧 Is HTML: " + (parsedMessage.getIsHtml() != null && parsedMessage.getIsHtml() ? "true" : "false"));
            System.out.println("   📧 Received: " + parsedMessage.getReceived());
            
            // Note: The MessageParsedViewModel has subject and body as dictionaries
            if (parsedMessage.getBody() != null) {
                System.out.println("   📋 Parsed body content: " + parsedMessage.getBody());
                // The body should be a Map with user_name parameter
                if (parsedMessage.getBody() instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, String> bodyDict = (Map<String, String>) parsedMessage.getBody();
                    if (bodyDict.containsKey("user_name")) {
                        String userName = bodyDict.get("user_name");
                        if ("John Doe".equals(userName)) {
                            System.out.println("   ✅ Body contains user_name='John Doe' as expected!");
                        } else {
                            System.out.println("   ⚠️  Body contains user_name='" + userName + "' instead of 'John Doe'");
                        }
                    }
                }
            }
            
            if (parsedMessage.getSubject() != null) {
                System.out.println("   📋 Parsed subject content: " + parsedMessage.getSubject());
                // The subject should be a Map with user_name parameter
                if (parsedMessage.getSubject() instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, String> subjectDict = (Map<String, String>) parsedMessage.getSubject();
                    if (subjectDict.containsKey("user_name")) {
                        String userName = subjectDict.get("user_name");
                        if ("John Doe".equals(userName)) {
                            System.out.println("   ✅ Subject contains user_name='John Doe' as expected!");
                        } else {
                            System.out.println("   ⚠️  Subject contains user_name='" + userName + "' instead of 'John Doe'");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("   ❌ Template parsing failed: " + ex.getMessage());
            System.err.println("   ℹ️  This might be expected if the 'onboarding' template is not configured on the server");
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("✅ Complete DevInbox workflow test completed!");
        System.out.println("\n🎯 What we accomplished:");
        System.out.println("  📧 Created a temporary mailbox");
        System.out.println("  📊 Verified mailbox was empty");
        System.out.println("  📤 Sent email via SMTP with test content");
        System.out.println("  📬 Verified email was received via API");
        System.out.println("  🔍 Tested template parsing with 'onboarding' template");
        System.out.println("\n🚀 DevInbox is working perfectly!");
    }

    private static String getApiKey() {
        System.out.println("DevInbox Java Client - Complete Usage Example");
        System.out.println("=".repeat(50));
        System.out.println("Please provide your DevInbox API key.");
        System.out.println("You can find it in your DevInbox dashboard at https://devinbox.io");
        System.out.println("Press Enter to use DEVINBOX_API_KEY environment variable");
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        String apiKey = scanner.nextLine().trim();
        scanner.close();
        
        if (apiKey.isEmpty()) {
            // Try to get from environment variable
            apiKey = System.getenv("DEVINBOX_API_KEY");
            if (apiKey == null || apiKey.isEmpty()) {
                System.err.println("❌ No API key provided and DEVINBOX_API_KEY environment variable is not set.");
                System.err.println("Please either:");
                System.err.println("  1. Enter your API key when prompted");
                System.err.println("  2. Set the DEVINBOX_API_KEY environment variable");
                System.exit(1);
            }
            System.out.println("✅ Using API key from DEVINBOX_API_KEY environment variable");
        } else {
            System.out.println("✅ Using provided API key");
        }
        
        return apiKey;
    }

    private static String getTestBodyContent() {
        return "Hello John Doe,\n\n" +
               "This is a simple test message to verify email delivery.\n" +
               "If you receive this, the system is working correctly.";
    }

    private static String createTestHtml() {
        return "<html>\n" +
               "<body>\n" +
               "    <h2>Hello John Doe,</h2>\n" +
               "    <p>This is a simple test message to verify email delivery.</p>\n" +
               "    <p>If you receive this, the system is working correctly.</p>\n" +
               "</body>\n" +
               "</html>\n    ";
    }

    private static boolean sendEmailViaSmtp(String mailboxUsername, String mailboxPassword, 
                                          String toEmail, boolean sendHtmlOnly) {
        System.out.println("\n📤 Sending email via SMTP to " + toEmail + "...");
        
        try {
            // Create properties
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_SERVER);
            props.put("mail.smtp.port", String.valueOf(SMTP_PORT));
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            
            // Create session
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailboxUsername, mailboxPassword);
                }
            });
            
            // Create message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("DevInbox Test <" + mailboxUsername + ">"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Welcome John Doe!");
            
            MimeMultipart multipart = new MimeMultipart("alternative");
            
            if (sendHtmlOnly) {
                // Send only HTML
                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(createTestHtml(), "text/html; charset=utf-8");
                multipart.addBodyPart(htmlPart);
                System.out.println("   📧 Sending HTML-only email with " + createTestHtml().length() + " characters");
            } else {
                // Send both text and HTML (multipart)
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setContent(getTestBodyContent(), "text/plain; charset=utf-8");
                multipart.addBodyPart(textPart);
                
                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(createTestHtml(), "text/html; charset=utf-8");
                multipart.addBodyPart(htmlPart);
                
                System.out.println("   📧 Sending multipart email with:");
                System.out.println("      - Text part: " + getTestBodyContent().length() + " characters");
                System.out.println("      - HTML part: " + createTestHtml().length() + " characters");
            }
            
            message.setContent(multipart);
            
            System.out.println("   🔌 Connecting to " + SMTP_SERVER + ":" + SMTP_PORT + "...");
            System.out.println("   🔑 Authenticating as " + mailboxUsername + "...");
            System.out.println("   📧 Sending email...");
            
            // Send message
            Transport.send(message);
            
            System.out.println("   ✅ Email sent successfully!");
            return true;
            
        } catch (Exception ex) {
            System.err.println("   ❌ Failed to send email: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}


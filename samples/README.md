# DevInbox Java Client - Sample Usage

This sample demonstrates how to use the DevInbox Java client to:
1. Create a temporary mailbox
2. Send an email via SMTP
3. Receive and verify the email via API
4. Test template parsing with the 'onboarding' template

## Prerequisites

**Option 1: Run with Docker (No Java/Maven installation required)**
- Docker and Docker Compose
- A DevInbox account with an API key (get it from https://devinbox.io)

**Option 2: Run locally**
- Java 11 or higher
- Maven 3.6 or higher
- A DevInbox account with an API key (get it from https://devinbox.io)

## Setup

### Option 1: Running with Docker (Recommended - No Java Required)

1. **Set your API key** (optional - you can also enter it when prompted):
   ```bash
   # Windows PowerShell
   $env:DEVINBOX_API_KEY='your-api-key-here'
   
   # Windows CMD
   set DEVINBOX_API_KEY=your-api-key-here
   
   # Linux/Mac
   export DEVINBOX_API_KEY=your-api-key-here
   ```

2. **Run using Docker**:
   ```bash
   # Windows PowerShell
   .\run-docker.ps1
   
   # Linux/Mac/Windows Git Bash
   chmod +x run-docker.sh
   ./run-docker.sh
   
   # Or directly with docker-compose
   docker-compose build
   docker-compose run --rm devinbox-java-sample
   ```

### Option 2: Running Locally

1. **Install the DevInbox client library** (required):
   ```bash
   cd ..
   mvn clean install
   ```
   
   This will install the `devinbox-client` library to your local Maven repository, which the sample project depends on.

2. **Set your API key** (optional - you can also enter it when prompted):
   ```bash
   # Windows
   set DEVINBOX_API_KEY=your-api-key-here
   
   # Linux/Mac
   export DEVINBOX_API_KEY=your-api-key-here
   ```

3. **Create the 'onboarding' template** in your DevInbox dashboard:
   
   **Body** (pay attention to whitespaces):
   ```
   <html>
   <body>
       <h2>Hello {{ user_name }},</h2>
       <p>This is a simple test message to verify email delivery.</p>
       <p>If you receive this, the system is working correctly.</p>
   </body>
   </html>
   ```
   
   **Subject**:
   ```
   Welcome {{ user_name }}!
   ```

## Running the Sample

### With Docker (No Java Required)

From the `samples` directory:

```bash
# Windows PowerShell
.\run-docker.ps1

# Linux/Mac/Windows Git Bash
./run-docker.sh

# Or directly
docker-compose build
docker-compose run --rm devinbox-java-sample
```

### Locally (Requires Java and Maven)

From the `samples` directory, run:

```bash
mvn compile exec:java
```

Or if you prefer to build and run separately:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="io.devinbox.sample.ExampleUsage"
```

## What the Sample Does

1. **Configures the API client** with your API key
2. **Creates a temporary mailbox** - generates a unique mailbox for testing
3. **Verifies the mailbox is empty** - ensures we start with a clean state
4. **Sends a test email** via SMTP to the created mailbox
5. **Waits for email processing** - gives the system time to process the email
6. **Verifies email receipt** - checks that the email was received via API
7. **Retrieves the email** - fetches the message details
8. **Tests template parsing** - attempts to parse the email using the 'onboarding' template

## Expected Output

The sample will output detailed information about each step, including:
- Mailbox creation details (key, password, email address)
- Message count before and after sending
- Email details (from, to, subject, body)
- Template parsing results (if the template is configured)

## Troubleshooting

- **API Key Error**: Make sure your API key is set correctly in the environment variable or enter it when prompted
- **Template Parsing Fails**: This is expected if the 'onboarding' template is not configured in your DevInbox dashboard
- **SMTP Connection Issues**: Ensure you can reach `smtp.devinbox.io:587` from your network
- **Email Not Received**: Wait a few seconds and try again - email processing may take a moment

## Code Structure

The sample code (`ExampleUsage.java`) demonstrates:
- API client configuration with API key authentication
- Creating mailboxes using `MailboxesApi`
- Retrieving messages using `MessagesApi`
- Sending emails via SMTP using Jakarta Mail
- Error handling and validation

## Next Steps

After running this sample successfully, you can:
- Integrate the DevInbox client into your own Java applications
- Use persistent mailboxes for long-term testing
- Create custom templates for your specific use cases
- Build automated email testing workflows

For more information, see the main [README.md](../README.md) file.


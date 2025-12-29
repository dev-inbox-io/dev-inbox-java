# MailboxesApi

All URIs are relative to *http://localhost:5062*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMailbox**](MailboxesApi.md#createMailbox) | **POST** /mailboxes | Create a new mailbox |
| [**createMailboxWithHttpInfo**](MailboxesApi.md#createMailboxWithHttpInfo) | **POST** /mailboxes | Create a new mailbox |



## createMailbox

> MailboxViewModel createMailbox(mailboxCreateModel)

Create a new mailbox

Creates a new mailbox for receiving test emails. Can be temporary or persistent.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MailboxesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MailboxesApi apiInstance = new MailboxesApi(defaultClient);
        MailboxCreateModel mailboxCreateModel = new MailboxCreateModel(); // MailboxCreateModel | 
        try {
            MailboxViewModel result = apiInstance.createMailbox(mailboxCreateModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MailboxesApi#createMailbox");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **mailboxCreateModel** | [**MailboxCreateModel**](MailboxCreateModel.md)|  | |

### Return type

[**MailboxViewModel**](MailboxViewModel.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |

## createMailboxWithHttpInfo

> ApiResponse<MailboxViewModel> createMailbox createMailboxWithHttpInfo(mailboxCreateModel)

Create a new mailbox

Creates a new mailbox for receiving test emails. Can be temporary or persistent.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MailboxesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MailboxesApi apiInstance = new MailboxesApi(defaultClient);
        MailboxCreateModel mailboxCreateModel = new MailboxCreateModel(); // MailboxCreateModel | 
        try {
            ApiResponse<MailboxViewModel> response = apiInstance.createMailboxWithHttpInfo(mailboxCreateModel);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MailboxesApi#createMailbox");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **mailboxCreateModel** | [**MailboxCreateModel**](MailboxCreateModel.md)|  | |

### Return type

ApiResponse<[**MailboxViewModel**](MailboxViewModel.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |


# StatusApi

All URIs are relative to *http://localhost:5062*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStatus**](StatusApi.md#getStatus) | **GET** /status | Get API service status |
| [**getStatusWithHttpInfo**](StatusApi.md#getStatusWithHttpInfo) | **GET** /status | Get API service status |



## getStatus

> void getStatus()

Get API service status

Returns OK if the API service is running and available.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.StatusApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        StatusApi apiInstance = new StatusApi(defaultClient);
        try {
            apiInstance.getStatus();
        } catch (ApiException e) {
            System.err.println("Exception when calling StatusApi#getStatus");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getStatusWithHttpInfo

> ApiResponse<Void> getStatus getStatusWithHttpInfo()

Get API service status

Returns OK if the API service is running and available.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.StatusApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        StatusApi apiInstance = new StatusApi(defaultClient);
        try {
            ApiResponse<Void> response = apiInstance.getStatusWithHttpInfo();
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (ApiException e) {
            System.err.println("Exception when calling StatusApi#getStatus");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


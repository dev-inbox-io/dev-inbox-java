# MessagesApi

All URIs are relative to *http://localhost:5062*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getLastMessage**](MessagesApi.md#getLastMessage) | **GET** /messages/{key}/last | Get the last message from a mailbox |
| [**getLastMessageWithHttpInfo**](MessagesApi.md#getLastMessageWithHttpInfo) | **GET** /messages/{key}/last | Get the last message from a mailbox |
| [**getLastMessageWithTemplate**](MessagesApi.md#getLastMessageWithTemplate) | **GET** /messages/{key}/{template}/last | Get the last message with template parsing |
| [**getLastMessageWithTemplateWithHttpInfo**](MessagesApi.md#getLastMessageWithTemplateWithHttpInfo) | **GET** /messages/{key}/{template}/last | Get the last message with template parsing |
| [**getMessageById**](MessagesApi.md#getMessageById) | **GET** /messages/{key}/get | Get a specific message by ID |
| [**getMessageByIdWithHttpInfo**](MessagesApi.md#getMessageByIdWithHttpInfo) | **GET** /messages/{key}/get | Get a specific message by ID |
| [**getMessageCount**](MessagesApi.md#getMessageCount) | **GET** /messages/{key}/count | Get message count for a mailbox |
| [**getMessageCountWithHttpInfo**](MessagesApi.md#getMessageCountWithHttpInfo) | **GET** /messages/{key}/count | Get message count for a mailbox |
| [**getMessages**](MessagesApi.md#getMessages) | **GET** /messages/{key} | Get messages from a mailbox |
| [**getMessagesWithHttpInfo**](MessagesApi.md#getMessagesWithHttpInfo) | **GET** /messages/{key} | Get messages from a mailbox |
| [**getSingleMessage**](MessagesApi.md#getSingleMessage) | **GET** /messages/{key}/single | Get single message from a mailbox |
| [**getSingleMessageWithHttpInfo**](MessagesApi.md#getSingleMessageWithHttpInfo) | **GET** /messages/{key}/single | Get single message from a mailbox |
| [**getSingleMessageWithTemplate**](MessagesApi.md#getSingleMessageWithTemplate) | **GET** /messages/{key}/{template}/single | Get single message with template parsing |
| [**getSingleMessageWithTemplateWithHttpInfo**](MessagesApi.md#getSingleMessageWithTemplateWithHttpInfo) | **GET** /messages/{key}/{template}/single | Get single message with template parsing |



## getLastMessage

> MessageViewModel getLastMessage(key)

Get the last message from a mailbox

Retrieves the most recent message from the specified mailbox. Returns an error if the mailbox is empty.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        try {
            MessageViewModel result = apiInstance.getLastMessage(key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getLastMessage");
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
| **key** | **String**|  | |

### Return type

[**MessageViewModel**](MessageViewModel.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

## getLastMessageWithHttpInfo

> ApiResponse<MessageViewModel> getLastMessage getLastMessageWithHttpInfo(key)

Get the last message from a mailbox

Retrieves the most recent message from the specified mailbox. Returns an error if the mailbox is empty.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        try {
            ApiResponse<MessageViewModel> response = apiInstance.getLastMessageWithHttpInfo(key);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getLastMessage");
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
| **key** | **String**|  | |

### Return type

ApiResponse<[**MessageViewModel**](MessageViewModel.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getLastMessageWithTemplate

> MessageParsedViewModel getLastMessageWithTemplate(key, template)

Get the last message with template parsing

Retrieves the most recent message from the specified mailbox and parses it using the provided template. Returns an error if the mailbox is empty.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        String template = "template_example"; // String | 
        try {
            MessageParsedViewModel result = apiInstance.getLastMessageWithTemplate(key, template);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getLastMessageWithTemplate");
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
| **key** | **String**|  | |
| **template** | **String**|  | |

### Return type

[**MessageParsedViewModel**](MessageParsedViewModel.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

## getLastMessageWithTemplateWithHttpInfo

> ApiResponse<MessageParsedViewModel> getLastMessageWithTemplate getLastMessageWithTemplateWithHttpInfo(key, template)

Get the last message with template parsing

Retrieves the most recent message from the specified mailbox and parses it using the provided template. Returns an error if the mailbox is empty.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        String template = "template_example"; // String | 
        try {
            ApiResponse<MessageParsedViewModel> response = apiInstance.getLastMessageWithTemplateWithHttpInfo(key, template);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getLastMessageWithTemplate");
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
| **key** | **String**|  | |
| **template** | **String**|  | |

### Return type

ApiResponse<[**MessageParsedViewModel**](MessageParsedViewModel.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getMessageById

> MessageViewModel getMessageById(key, id)

Get a specific message by ID

Retrieves a specific message from the specified mailbox using its unique ID.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        UUID id = UUID.randomUUID(); // UUID | 
        try {
            MessageViewModel result = apiInstance.getMessageById(key, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getMessageById");
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
| **key** | **String**|  | |
| **id** | **UUID**|  | |

### Return type

[**MessageViewModel**](MessageViewModel.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

## getMessageByIdWithHttpInfo

> ApiResponse<MessageViewModel> getMessageById getMessageByIdWithHttpInfo(key, id)

Get a specific message by ID

Retrieves a specific message from the specified mailbox using its unique ID.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        UUID id = UUID.randomUUID(); // UUID | 
        try {
            ApiResponse<MessageViewModel> response = apiInstance.getMessageByIdWithHttpInfo(key, id);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getMessageById");
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
| **key** | **String**|  | |
| **id** | **UUID**|  | |

### Return type

ApiResponse<[**MessageViewModel**](MessageViewModel.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getMessageCount

> MessageCountResult getMessageCount(key)

Get message count for a mailbox

Returns the total number of messages in the specified mailbox.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        try {
            MessageCountResult result = apiInstance.getMessageCount(key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getMessageCount");
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
| **key** | **String**|  | |

### Return type

[**MessageCountResult**](MessageCountResult.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

## getMessageCountWithHttpInfo

> ApiResponse<MessageCountResult> getMessageCount getMessageCountWithHttpInfo(key)

Get message count for a mailbox

Returns the total number of messages in the specified mailbox.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        try {
            ApiResponse<MessageCountResult> response = apiInstance.getMessageCountWithHttpInfo(key);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getMessageCount");
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
| **key** | **String**|  | |

### Return type

ApiResponse<[**MessageCountResult**](MessageCountResult.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getMessages

> MessagesViewModel getMessages(key, skip, take)

Get messages from a mailbox

Retrieves messages from the specified mailbox with optional pagination. Default: skip&#x3D;0, take&#x3D;10, max take&#x3D;25.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        GetMessagesSkipParameter skip = new GetMessagesSkipParameter(); // GetMessagesSkipParameter | 
        GetMessagesSkipParameter take = new GetMessagesSkipParameter(); // GetMessagesSkipParameter | 
        try {
            MessagesViewModel result = apiInstance.getMessages(key, skip, take);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getMessages");
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
| **key** | **String**|  | |
| **skip** | **GetMessagesSkipParameter**|  | [optional] |
| **take** | **GetMessagesSkipParameter**|  | [optional] |

### Return type

[**MessagesViewModel**](MessagesViewModel.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

## getMessagesWithHttpInfo

> ApiResponse<MessagesViewModel> getMessages getMessagesWithHttpInfo(key, skip, take)

Get messages from a mailbox

Retrieves messages from the specified mailbox with optional pagination. Default: skip&#x3D;0, take&#x3D;10, max take&#x3D;25.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        GetMessagesSkipParameter skip = new GetMessagesSkipParameter(); // GetMessagesSkipParameter | 
        GetMessagesSkipParameter take = new GetMessagesSkipParameter(); // GetMessagesSkipParameter | 
        try {
            ApiResponse<MessagesViewModel> response = apiInstance.getMessagesWithHttpInfo(key, skip, take);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getMessages");
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
| **key** | **String**|  | |
| **skip** | **GetMessagesSkipParameter**|  | [optional] |
| **take** | **GetMessagesSkipParameter**|  | [optional] |

### Return type

ApiResponse<[**MessagesViewModel**](MessagesViewModel.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getSingleMessage

> MessageViewModel getSingleMessage(key)

Get single message from a mailbox

Retrieves a single message from the specified mailbox. Returns an error if the mailbox contains 0 or more than 1 message.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        try {
            MessageViewModel result = apiInstance.getSingleMessage(key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getSingleMessage");
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
| **key** | **String**|  | |

### Return type

[**MessageViewModel**](MessageViewModel.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

## getSingleMessageWithHttpInfo

> ApiResponse<MessageViewModel> getSingleMessage getSingleMessageWithHttpInfo(key)

Get single message from a mailbox

Retrieves a single message from the specified mailbox. Returns an error if the mailbox contains 0 or more than 1 message.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        try {
            ApiResponse<MessageViewModel> response = apiInstance.getSingleMessageWithHttpInfo(key);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getSingleMessage");
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
| **key** | **String**|  | |

### Return type

ApiResponse<[**MessageViewModel**](MessageViewModel.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getSingleMessageWithTemplate

> MessageParsedViewModel getSingleMessageWithTemplate(key, template)

Get single message with template parsing

Retrieves a single message from the specified mailbox and parses it using the provided template. Returns an error if the mailbox contains 0 or more than 1 message.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        String template = "template_example"; // String | 
        try {
            MessageParsedViewModel result = apiInstance.getSingleMessageWithTemplate(key, template);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getSingleMessageWithTemplate");
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
| **key** | **String**|  | |
| **template** | **String**|  | |

### Return type

[**MessageParsedViewModel**](MessageParsedViewModel.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

## getSingleMessageWithTemplateWithHttpInfo

> ApiResponse<MessageParsedViewModel> getSingleMessageWithTemplate getSingleMessageWithTemplateWithHttpInfo(key, template)

Get single message with template parsing

Retrieves a single message from the specified mailbox and parses it using the provided template. Returns an error if the mailbox contains 0 or more than 1 message.

### Example

```java
// Import classes:
import io.devinbox.client.ApiClient;
import io.devinbox.client.ApiException;
import io.devinbox.client.ApiResponse;
import io.devinbox.client.Configuration;
import io.devinbox.client.models.*;
import io.devinbox.client.api.MessagesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:5062");

        MessagesApi apiInstance = new MessagesApi(defaultClient);
        String key = "key_example"; // String | 
        String template = "template_example"; // String | 
        try {
            ApiResponse<MessageParsedViewModel> response = apiInstance.getSingleMessageWithTemplateWithHttpInfo(key, template);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MessagesApi#getSingleMessageWithTemplate");
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
| **key** | **String**|  | |
| **template** | **String**|  | |

### Return type

ApiResponse<[**MessageParsedViewModel**](MessageParsedViewModel.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


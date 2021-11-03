# DefaultApi

All URIs are relative to *https://dvijok_api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authPost**](DefaultApi.md#authPost) | **POST** /auth | POST auth
[**menuGet**](DefaultApi.md#menuGet) | **GET** /menu | GET menu
[**regisrterPost**](DefaultApi.md#regisrterPost) | **POST** /regisrter | POST regisrter


<a name="authPost"></a>
# **authPost**
> authPost()

POST auth

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://dvijok_api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.authPost();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#authPost");
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
**200** | OK |  -  |

<a name="menuGet"></a>
# **menuGet**
> menuGet()

GET menu

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://dvijok_api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.menuGet();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#menuGet");
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
**200** | OK |  -  |

<a name="regisrterPost"></a>
# **regisrterPost**
> regisrterPost()

POST regisrter

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://dvijok_api");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.regisrterPost();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#regisrterPost");
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
**200** | OK |  -  |


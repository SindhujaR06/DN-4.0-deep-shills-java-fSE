import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
interface RestClient {
    String fetch();
}
class ApiService {
    private RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String callExternalService() {
        String response = restClient.fetch();
        return "Handled " + response;
    }
}

public class ApiServiceTest {

    @Test
    public void testApiServiceWithMockRestClient() {
        RestClient mockClient = Mockito.mock(RestClient.class);
        Mockito.when(mockClient.fetch()).thenReturn("Mock Response");
        ApiService apiService = new ApiService(mockClient);
        String result = apiService.callExternalService();
        assertEquals("Handled Mock Response", result);
    }
}

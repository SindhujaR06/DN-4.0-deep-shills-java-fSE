import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
interface Repository {
    String fetchData();
}

class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
    public String processData() {
        String data = repository.fetchData();
        return "Processed " + data;
    }
}

public class ServiceTest {
    @Test
    public void testServiceWithMockRepository() {
        Repository mockRepository = Mockito.mock(Repository.class);
        Mockito.when(mockRepository.fetchData()).thenReturn("Mock Data");

        Service service = new Service(mockRepository);
        String result = service.processData();
        assertEquals("Processed Mock Data", result);
    }
}

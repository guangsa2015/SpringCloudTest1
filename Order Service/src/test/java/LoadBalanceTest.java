import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class LoadBalanceTest {

    @Test
    public void testBalance(){
        RestTemplate restTemplate = new RestTemplate();

    }
}

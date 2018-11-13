import com.framework.v1.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class RedisTester {

    /*
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){

        ValueOperations valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("key","hh");
    }
    */
}

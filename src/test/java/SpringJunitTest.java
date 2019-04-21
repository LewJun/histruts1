import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/spring.xml"
//        , "classpath:/spring/spring.xml"
}
)
public class SpringJunitTest {
    static final Logger LOGGER = LoggerFactory.getLogger(SpringJunitTest.class);

    @Test
    public void testSpring() {
        LOGGER.info("只为测试spring是否配置成功");
    }
}

import com.tw.HelloWorld;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yxwang on 29/06/2017.
 */
public class HelloWorldTest {
    private final HelloWorld helloWorld = new HelloWorld();

    @Test
    public void hello_world_test() throws Exception {
        assertEquals("Hello, world", helloWorld.hi());
    }

}

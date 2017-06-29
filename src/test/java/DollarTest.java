import com.tw.Dollar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DollarTest {
    @Test
    public void test_one_dollar_equals_one_dollar() throws Exception {
        assertEquals(new Dollar(1), new Dollar(1));
    }

    @Test
    public void test_one_dollar_not_equals_two_dollar() throws Exception {
        assertNotEquals(new Dollar(1), new Dollar(2));
    }

    @Test
    public void test_one_dollar_multiply_two() throws Exception {
        assertEquals(new Dollar(2), new Dollar(1).multiply(2));
    }
}

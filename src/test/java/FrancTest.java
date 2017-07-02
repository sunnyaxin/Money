import com.tw.Franc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FrancTest {
    @Test
    public void test_one_franc_equals_one_franc() throws Exception {
        assertEquals(new Franc(1), new Franc(1));
    }

    @Test
    public void test_one_franc_not_equals_one_franc() throws Exception {
        assertNotEquals(new Franc(1), new Franc(2));
    }

    @Test
    public void test_one_franc_times_two() throws Exception {
        Franc oneFranc = new Franc(1);
        assertEquals(new Franc(2), oneFranc.times(2));
    }

    @Test
    public void test_one_franc_plus_one_franc() throws Exception {
        Franc oneFranc = new Franc(1);
        Franc anotherFranc = new Franc(1);
        assertEquals(new Franc(2), oneFranc.plus(anotherFranc));
    }

    @Test
    public void test_multiple_addition_times() throws Exception {
        Franc oneFranc = new Franc(1);
        Franc twoFranc = new Franc(2);
        assertEquals(new Franc(6), oneFranc.plus(twoFranc).times(2));
    }

    @Test
    public void test_multiple_addition() throws Exception {
        Franc oneFranc = new Franc(1);
        Franc twoFranc = new Franc(2);
        Franc threeFranc = new Franc(3);
        assertEquals(new Franc(6), oneFranc.plus(twoFranc).plus(threeFranc));
    }

    @Test
    public void test_multiple_times() throws Exception {
        Franc oneFranc = new Franc(1);
        assertEquals(new Franc(6), oneFranc.times(2).times(3));
    }
}

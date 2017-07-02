import com.tw.Dollar;
import com.tw.Franc;
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
    public void test_one_dollar_times_two() throws Exception {
        assertEquals(new Dollar(2), new Dollar(1).times(2));
    }

    @Test
    public void test_one_dollar_plus_one_dollar() throws Exception {
        Dollar oneDollar = new Dollar(1);
        Dollar anotherOneDollar = new Dollar(1);
        assertEquals(new Dollar(2), oneDollar.plus(anotherOneDollar));
    }

    @Test
    public void test_multiple_addition_times() throws Exception {
        Dollar oneDollar = new Dollar(1);
        Dollar twoDollar = new Dollar(2);
        assertEquals(new Dollar(6), oneDollar.plus(twoDollar).times(2));
    }

    @Test
    public void test_multiple_addition() throws Exception {
        Dollar oneDollar = new Dollar(1);
        Dollar twoDollar = new Dollar(2);
        Dollar threeDollar = new Dollar(3);
        assertEquals(new Dollar(6), oneDollar.plus(twoDollar).plus(threeDollar));
    }

    @Test
    public void test_multiple_times() throws Exception {
        Dollar oneDollar = new Dollar(1);
        assertEquals(new Dollar(6), oneDollar.times(2).times(3));
    }

    @Test
    public void test_dollar_currency_type() throws Exception {
        assertEquals("USD", new Dollar(1).getCurrency());
    }

    @Test
    public void test_franc_currency_type() throws Exception {
        assertEquals("CHF", new Franc(1).getCurrency());
    }

}

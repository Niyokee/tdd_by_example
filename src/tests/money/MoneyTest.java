package money;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    public void testEquality(){
        assertEquals(Money.dollar(5), Money.dollar((5)));
        assertNotEquals(Money.dollar(5), Money.dollar(6));
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency);
        assertEquals("CHF", Money.franc(1).currency);
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}
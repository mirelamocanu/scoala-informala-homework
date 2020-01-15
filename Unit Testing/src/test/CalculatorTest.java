import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getMax() {
        Calculator c = new Calculator(1, 2, 3);
        Integer max = c.getMax();
        assertEquals(max, 3);

    }

    @Test
    void getMaxWithNegative() {
        Calculator c = new Calculator(1, 2, -3);
        Integer max = c.getMax();
        assertEquals(max, 2);


    }

    @Test
    void getMaxWithNull() {
        Calculator c = new Calculator(1, 2, null);
        Integer max = c.getMax();
        assertNotNull(c);


    }


    @Test
    void getMin() {
        Calculator c = new Calculator(1, 2, 3);
        Integer min = c.getMin();
        assertEquals(min, 1);

    }

    @Test
    void getMinWithNegative() {
        Calculator c = new Calculator(1, 2, -3);
        Integer min = c.getMin();
        assertEquals(min, -3);
    }

    @Test
    void getMinWithNull() {
        Calculator c = new Calculator(1, 2, null);
        Integer min = c.getMin();
        assertNotNull(c);
    }


    @Test
    void isAEvenWithOdd() {
        Calculator c = new Calculator(1, 2, 3);
        boolean isEven = c.isAEven();
        assertFalse(isEven);
    }

    @Test
    void isAEvenWithEven() {
        Calculator c = new Calculator(2, 4, 6);
        boolean isEven = c.isAEven();
        assertTrue(isEven);
    }

    @Test
    void isAEvenWithNull() {
        Calculator c = new Calculator(null, 2, 5);
        boolean isEven = c.isAEven();
        assertTrue(isEven);
    }


    @Test
    void getSum() {
        Calculator c = new Calculator(2, 2, 7);
        Integer sum = c.getSum();
        assertEquals(sum, 11);
    }

    @Test
    void getSumWithNegative() {
        Calculator c = new Calculator(2, 2, -7);
        Integer sum = c.getSum();
        assertEquals(sum, -3);
    }

    @Test
    void getSumWithNull() {
        Calculator c = new Calculator(2, 4, null);
        Integer sum = c.getSum();
        assertEquals(sum, 6);
    }

    @Test
    void getAvg() {
        Calculator c = new Calculator(2, 2, 6);
        Double avg = c.getAvg();
        assertEquals(avg, 3.3333333333333335);
    }

    @Test
    void getAvgWithNegative() {
        Calculator c = new Calculator(2, 2, -9);
        Double avg = c.getAvg();
        assertEquals(avg, -1.6666666666666667);
    }

    @Test
    void getAvgWithNull() {
        Calculator c = new Calculator(4, null, 4);
        Double avg = c.getAvg();
        assertEquals(avg, 4);
    }

    @Test
    void getAvgWithNulls() {
        Calculator c = new Calculator(null, null, null);
        Double avg = c.getAvg();
        assertEquals(avg, 0);
    }


    @Test
    void areAllPositive() {
        Calculator c=new Calculator(2,4,6);
        Boolean areAllPositive=c.areAllPositive();
        assertTrue(areAllPositive);
    }

    @Test
    void areAllPositiveWithNegative() {
        Calculator c=new Calculator(2,-4,6);
        Boolean areAllPositive=c.areAllPositive();
        assertFalse(areAllPositive);
    }
    @Test
    void areAllPositiveWithNull() {
        Calculator c=new Calculator(null,null,6);
        Boolean areAllPositive=c.areAllPositive();
        assertFalse(areAllPositive);
    }
}
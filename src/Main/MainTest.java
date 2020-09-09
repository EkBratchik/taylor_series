package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testCalculateTailorSeries() {
        double x = 0;
        double eps = Math.pow(10, -10);
        double expected = Main.calculateActualValue(x);
        double actual = Main.calculateTailorSeries(eps, x);
        assertEquals(expected, actual);
    }
}
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.NumbersMetods;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestNumbers {
    private NumbersMetods method;

    @BeforeAll
    void setUp() {
        this.method = new NumbersMetods();
    }
    //Напишите тесты, покрывающие на 100% метод evenOddNumber,
    // который проверяет, является ли переданное число четным или нечетным. (код приложен в презентации)

    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 10})
    void numberIsEven(int num) {
        assertTrue(method.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 11})
    void numberIsOdd(int num) {
        assertFalse(method.evenOddNumber(num));
    }

    //Разработайте и протестируйте метод numberInInterval,
    // который проверяет, попадает ли переданное число в интервал (25;100). (код приложен в презентации)

    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99})
    void numberInInterval(int num) {
        assertTrue(method.numberInInterval(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 25, 100, 101})
    void numberOutInterval(int num) {
        assertFalse(method.numberInInterval(num));
    }




}

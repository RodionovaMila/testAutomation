import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculationTest {
    private static Calculation calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculation();
        System.out.println("Before all");
    }

    @BeforeEach
    public void setUp() {
    System.out.println("Before each");
    }

    @Test
    public void testAdd() {
    int result = calculator.add(2, 3);
    assertEquals(5, result);

    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(6, 3);
        assertEquals(2, result);
    }

    @Test
    public void testDivideByZero() {
        try {
            calculator.divide(6, 0);
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void testNegate() {
        int result = calculator.negate(5);
        assertEquals(-5, result);
    }

    @Test
    public void testMax() {
        int result = calculator.max(5, 3);
        assertEquals(5, result);
    }

    @Test
    public void testMin() {
        int result = calculator.min(5, 3);
        assertEquals(3, result);
    }


    @ParameterizedTest
    @MethodSource({"integerProvider"})
    public void testAdd ( int a, int b, int expected){
            System.out.println("Test 1");
            int result = calculator.divide(a, b);
            Assertions.assertEquals(result, expected, "Result is wrong: " + result);
        }
    public static Stream<Arguments> integerProvider() {
        return Stream.of(Arguments.arguments(new Object[]{24, 8, 3}), Arguments.arguments(new Object[]{24, 4, 6}));
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

}

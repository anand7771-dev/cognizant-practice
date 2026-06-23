package junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LifecycleTest {

    Calculator c;

    @BeforeAll
    static void start() {
        System.out.println("Test Started");
    }

    @BeforeEach
    void setup() {
        c = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(15, c.add(10, 5));
    }

    @Test
    void testSub() {
        assertEquals(5, c.subtract(10, 5));
    }

    @AfterEach
    void endTest() {
        System.out.println("Test Finished");
    }

    @AfterAll
    static void end() {
        System.out.println("All Tests Completed");
    }
}
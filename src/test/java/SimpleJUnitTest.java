import org.junit.jupiter.api.*;

public class SimpleJUnitTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("\n### beforeAll()\n");
    }
    int result;

    @BeforeEach
    void beforeEach() {
        System.out.println("### beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("### afterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\n### afterAll()\n");
    }

    @Test
    void firstTest() {
        int result = getResult();
        System.out.println("### firstTest");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondtTest() {
        System.out.println("### secondtTest");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("### thirdTest");
        Assertions.assertTrue(result > 2);
    }
    private int getResult() {
        return 3;
    }
}

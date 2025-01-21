package eu.lucanto;

import org.junit.jupiter.api.Test;

public class RegistrationTest extends AbstractTest{
    @Override
    public String getTestName() {
        return "Registration test";
    }

    @Test
    public void testRegistrationSuccess() {
        test.pass("Registration test passed");
    }
    @Test
    public void testRegistrationFail() {
        test.fail("Registration test passed");
    }
}

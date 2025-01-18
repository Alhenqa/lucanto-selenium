package eu.lucanto;

import org.junit.jupiter.api.Test;

public class RegistrationTest extends AbstractTest{
    @Override
    String getTestName() {
        return "Registration test";
    }

    @Test
    public void testRegistration() {
        test.pass("Registration test passed");
    }
}

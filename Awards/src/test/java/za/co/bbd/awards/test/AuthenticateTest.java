package za.co.bbd.awards.test;

import org.junit.Test;
import za.co.bbd.awards.Authenticate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Author: margocdy
 * Created: 2015-05-03
 */
public class AuthenticateTest {

    private String usernameCorrect = "Mike";
    private String passwordCorrect = "Testing1";

    private String usernameIncorrect = "Dylan";
    private String passwordIncorrect = "Testing2";

    private String usernameNull = null;
    private String passwordNull = null;

    @Test
    public void testSuccessfulAuthentication() {
        assertTrue(Authenticate.login(usernameCorrect, passwordCorrect));
    }

    @Test
    public void testFailedUsernameAuthentication() {
        assertFalse(Authenticate.login(usernameIncorrect, passwordCorrect));
    }

    @Test
    public void testFailedPasswordAuthentication() {
        assertFalse(Authenticate.login(usernameCorrect, passwordIncorrect));
    }

    @Test
    public void testNullUsernameAuthentication() {
        assertFalse(Authenticate.login(usernameNull, passwordCorrect));
    }

    @Test
    public void testNullPasswordAuthentication() {
        assertFalse(Authenticate.login(usernameCorrect, passwordNull));
    }

}

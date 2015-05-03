package za.co.bbd.awards.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.mockito.Mockito;
import za.co.bbd.awards.Constants;
import za.co.bbd.awards.LoginServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Author: margocdy
 * Created: 2015-05-03
 */
public class LoginServletTest extends Mockito {

    @Test
    public void testSuccessAuthSession() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
// test comment
        when(request.getParameter("username")).thenReturn("Mike");
        when(request.getParameter("password")).thenReturn("Testing1");
        when(request.getSession(true)).thenReturn(session);

        PrintWriter writer = new PrintWriter("success-login-serv.txt");
        when(response.getWriter()).thenReturn(writer);

        new LoginServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("username");
        verify(request, atLeast(1)).getParameter("password");
        assertEquals(Boolean.TRUE, session.getAttribute(Constants.AUTHENTICATION));
        writer.flush(); // it may not have been flushed yet...
        assertTrue(FileUtils.readFileToString(new File("success-login-serv.txt"), "UTF-8")
                .contains("true"));
    }

    @Test
    public void testFailedAuthSession() {

    }

}

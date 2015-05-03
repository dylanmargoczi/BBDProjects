package za.co.bbd.awards;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: margocdy
 * Created: 2015-05-03
 */
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (Authenticate.login(username, password)) {
            request.getSession(true).setAttribute(Constants.AUTHENTICATION, Boolean.TRUE);
        } else {
            request.getSession(true).setAttribute(Constants.AUTHENTICATION, Boolean.FALSE);
        }


    }

}

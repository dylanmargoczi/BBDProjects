package za.co.bbd.awards;

/**
 * Author: margocdy
 * Created: 2015-05-03
 */
public class Authenticate {

    /**
     * Login
     *
     * @param username
     * @param password
     * @return boolen : true if successful
     */
    public static boolean login(String username, String password) {
        //FIXME:
        // check username
        if (username != null && username.equals("Mike")) {
            //check password
            if (password != null && password.equals("Testing1")) {
                return true;
            }
        }
        return false;
    }

}

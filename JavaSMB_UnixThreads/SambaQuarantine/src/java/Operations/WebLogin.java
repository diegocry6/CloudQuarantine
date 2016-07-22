/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

import com.unboundid.ldap.sdk.LDAPException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asir
 */
public class WebLogin extends Operations {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            boolean login = false;
            try {
                login = LdapLogin.autenticar(request.getParameter("username"), request.getParameter("password"));
            } catch (LDAPException ex) {
                Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (login){
                request.getSession().setAttribute("session", "ok");
                printWriter.write("loged");
            } else {
                response.sendRedirect("/SambaQuarantine");
            }
        } catch (IOException ex) {
            Logger.getLogger(WebLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            printWriter.close();
        }
    }
    
}

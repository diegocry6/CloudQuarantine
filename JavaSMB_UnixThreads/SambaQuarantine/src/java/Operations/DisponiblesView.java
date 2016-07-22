/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

import FileManager.FileExplore;
import FileManager.FileData;
import com.unboundid.ldap.sdk.LDAPException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jcifs.smb.SmbException;

/**
 *
 * @author Asir
 */
public class DisponiblesView extends Operations{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            FileData ficherosDisponibles = FileExplore.explorar("smb://127.0.0.1/disponibles/");
            request.setAttribute("ficherosDisponibles", ficherosDisponibles);
            RequestDispatcher dispatcher = request.getRequestDispatcher("vistaDisponibles.jsp");
            if (dispatcher != null){
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("/SambaQuarantine");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DisponiblesView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SmbException ex) {
            Logger.getLogger(DisponiblesView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(DisponiblesView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisponiblesView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

import FileManager.FileExplore;
import FileManager.FileData;
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
public class CuarentenaView extends Operations {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            FileData ficherosCuarentena = FileExplore.explorar("smb://127.0.0.1/cuarentena/");
            request.setAttribute("ficherosCuarentena", ficherosCuarentena);
            RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCuarentena.jsp");
            if (dispatcher != null){
                
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(CuarentenaView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CuarentenaView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                try {
                    response.sendRedirect("/SambaQuarantine");
                } catch (IOException ex) {
                    Logger.getLogger(CuarentenaView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CuarentenaView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SmbException ex) {
            Logger.getLogger(CuarentenaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

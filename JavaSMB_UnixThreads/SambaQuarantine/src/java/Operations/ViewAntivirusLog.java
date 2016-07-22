/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class ViewAntivirusLog extends Operations {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        File directorio = new File("/home/debian/.clamAVLogs");
        File[] logs = directorio.listFiles();
        ArrayList logsArray = new ArrayList();
        
        for (File log : logs) {
            
            logsArray.add(log.getName());
            
        }
        
        request.setAttribute("clamAvLogs", logsArray);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vistaClamAV.jsp");
        if (dispatcher != null){
            try {
                dispatcher.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ViewAntivirusLog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewAntivirusLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                response.sendRedirect("/SambaQuarantine");
            } catch (IOException ex) {
                Logger.getLogger(ViewAntivirusLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}

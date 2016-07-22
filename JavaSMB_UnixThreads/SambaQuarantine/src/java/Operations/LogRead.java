/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class LogRead extends Operations {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            String filename = request.getParameter("file");
            String fichero = "/home/debian/.clamAVLogs/" + filename;
            Path ruta = Paths.get(fichero);
            List<String> log = Files.readAllLines(ruta);
            final PrintWriter writer = response.getWriter();
            writer.print(log);
        } catch (IOException ex) {
            Logger.getLogger(LogRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

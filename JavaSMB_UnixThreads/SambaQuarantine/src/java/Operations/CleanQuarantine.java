/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileUtils;

/**
 *
 * @author root
 */
public class CleanQuarantine extends Operations {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        try {
            FileUtils.cleanDirectory(new File("/home/debian/cuarentena"));
        } catch (IOException ex) {
            Logger.getLogger(CleanQuarantine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

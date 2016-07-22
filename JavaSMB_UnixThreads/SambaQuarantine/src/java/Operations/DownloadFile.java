/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asir
 */
public class DownloadFile extends Operations {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        String smbPath = request.getParameter("smbPath");
        String ruta = smbPath.substring(smbPath.indexOf("1/") + 1);
        String filepath = "/home/debian"+ruta;
        File downloadFile = new File(filepath);
        String mimeType = URLConnection.guessContentTypeFromName(downloadFile.getName());
        OutputStream outStream = null;
        
        try {
            
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);
            FileInputStream inStream = new FileInputStream(downloadFile);
            outStream = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            
            while ((bytesRead = inStream.read(buffer)) != -1) {
                
                outStream.write(buffer, 0, bytesRead);
                
            }   inStream.close();
            
            outStream.close();
            
        } catch (IOException ex) {
            
            Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            
            try {
                outStream.close();
            } catch (IOException ex) {
                
                Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }
    
}


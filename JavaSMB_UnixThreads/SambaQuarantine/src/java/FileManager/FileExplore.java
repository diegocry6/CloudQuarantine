package FileManager;

import java.net.MalformedURLException;
import java.util.ArrayList;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

/**
 *
 * @author Asir
 */
public class FileExplore {

    public static FileData explorar(String ruta) throws MalformedURLException, SmbException {
               
String userPassword = "root" + ":" + "departamento";
NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(userPassword);
SmbFile smbFile;

    smbFile = new SmbFile(ruta, auth);
    SmbFile[] files = smbFile.listFiles();
    ArrayList ficheros = new ArrayList();
    ArrayList sizes = new ArrayList();
    ArrayList smbPath = new ArrayList();
    
        for (SmbFile file : files) {
            
            long sizeInMb = file.length() / (1024);
            
            ficheros.add(file.getName());
            sizes.add(sizeInMb);
            smbPath.add(file.getCanonicalPath());
            
        }
        
        FileData datos = new FileData(ficheros, sizes, smbPath);
    
            return datos;

    } 
}
    


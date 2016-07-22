/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import java.util.ArrayList;

/**
 *
 * @author Asir
 */
    public class FileData {
       
      public ArrayList ficheros;
      public ArrayList sizes; 
      public ArrayList smbPath;

    FileData(ArrayList ficheros, ArrayList sizes, ArrayList smbPath) {
        
         this.ficheros = ficheros;
         this.sizes = sizes;
         this.smbPath = smbPath;
         
    }
 
}


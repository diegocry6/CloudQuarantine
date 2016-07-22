/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

/**
 *
 * @author Asir
 */

import JAXB.Operacion;
import JAXB.Operaciones;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class OperationFactory {
    
    static HashMap<String,Operacion> operationMap = null;
    private static volatile OperationFactory instance = null;
    
    private OperationFactory() {
        OperationFactory.operationMap = new HashMap<String,Operacion>();
    }
    
    public static OperationFactory getInstance() {
        if (instance == null) {
            synchronized (OperationFactory.class) {
                // Doble comprobacion de instancia
                if (instance == null) {
                    instance = new OperationFactory();
                }
            }
        }
        return instance;
    }
    
    public void populate(InputStream file) throws JAXBException {
        
        JAXBContext jc = JAXBContext.newInstance(Operaciones.class);
        
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Operaciones operaciones = (Operaciones) unmarshaller.unmarshal(file);
        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        for (int i = 0; i < operaciones.getOperaciones().size(); i++) {
            
            operationMap.put(operaciones.getOperaciones().get(i).getKey(), operaciones.getOperaciones().get(i));
            
        }
        
    }
    
    
    public Operations getOperation(String key) {
        Operacion operacion = operationMap.get(key);
        String value = operacion.getValue();
        if (value != null) {
            try {
                Class objectClass = Class.forName("Operations."+value);
                Constructor userConstructor = objectClass.getConstructor(new Class[] {});
                Operations operation = (Operations) userConstructor.newInstance();
                return operation;
                
            } catch(Exception e) {
                return null;
            }
            
        }
        return null;
    }
    
}


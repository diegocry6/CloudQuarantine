/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package JAXB;

/**
 *
 * @author Asir
 */
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Operaciones {
    
    private List<Operacion> operaciones;
    
    @XmlElement(name="operacion")
    public List<Operacion> getOperaciones() {
        return operaciones;
    }
    
    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }
    
}

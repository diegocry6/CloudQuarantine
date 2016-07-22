

import Operations.Operations;
import Operations.OperationFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Asir
 */
@WebServlet(urlPatterns = {"/ServletHandler"})
public class ServletHandler extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            OperationFactory.getInstance().populate(getServletContext().getResourceAsStream("/WEB-INF/operaciones.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(ServletHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operation = request.getParameter("operacion");
        if (operation != null) {
            Operations object = OperationFactory.getInstance().getOperation(operation);
            object.execute(request,response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
}

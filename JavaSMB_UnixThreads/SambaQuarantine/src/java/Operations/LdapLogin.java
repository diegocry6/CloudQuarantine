/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Operations;

import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;

/**
 *
 * @author Asir
 */
public class LdapLogin {
    
    public static boolean autenticar(String username, String password) throws LDAPException {
        
        String HOSTNAME = "127.0.0.1";
        int PORT = 389;
        
        LDAPConnection connection = new LDAPConnection();
        connection.connect(HOSTNAME, PORT);
        
        if(connection.isConnected()) {
            BindResult br = connection.bind("cn="+username+",dc=diego,dc=com", password);
            if(br.getResultCode().toString().equals("0 (success)")) {
                
                return true;
                
            } else
                
                connection.close();
            
        }
        
        return false;
    }
}
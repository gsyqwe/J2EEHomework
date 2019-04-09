package Factory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EJBFactory {
    public static Object getEJB(String path) {
        try {
            Properties jndiProps = new Properties();
            jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            jndiProps.put("jboss.naming.client.ejb.context", true);

            final Context context = new InitialContext(jndiProps);
            return context.lookup(path);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
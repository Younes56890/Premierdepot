package HelloWorldClient;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import HelloWorldApp.*;

public class Main {
    static Hello hello;

    public static void main(String[] args) {
        try {
        	ORB orb = ORB.init(args, null);
        	org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        	NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        	Hello hello = HelloHelper.narrow(ncRef.resolve_str("Hello"));
            System.out.println("Connexion au serveur réussie !");
            System.out.println(hello.HelloMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

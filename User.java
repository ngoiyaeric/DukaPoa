package SmartShoppers;
import java.util.*;
import javax.swing.*;

public class User extends Authentication {
    static Double Location;
    ArrayList<Store> UserOnStores;
    
    public User(String username, String password, String role) {
        super(username, password, role);
        //TODO Auto-generated constructor stub
    }

    //Query Database for user authentication and authorization
    public boolean isAuthorized(String role, String username, String password) {
        if (this.role.equals(role)) {
            return true;
        } else {
            return false;
        }
    }

    public void setLocation(Double Location) {
        User.Location = Location;
    }

    public static Double getUserLocation() {
        return Location;
    }
    


    
    

    
}

package SmartShoppers;
import java.util.*;
import java.sql.*;
import javax.swing.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrator extends Authentication {
   
    Store ManagedStore;
    

    public Administrator(String username, String password, String role) {
        super(username, password, role);
        //TODO Auto-generated constructor stub
    }

    //create new method to create Manager 
    public void createManager(String username, String password, String role, Store ManagedStore) {
        Manager newManager = new Manager(username, password, role);
        newManager.setManagedStore(ManagedStore);
        ManagedStore.addManager(newManager);
    }

    //create method to remove manager 
    public void removeManager(String username, String password, String role, Store ManagedStore) {
        Manager newManager = new Manager(username, password, role);
        newManager.setManagedStore(ManagedStore);
        ManagedStore.removeManager(newManager);
    }



    
}

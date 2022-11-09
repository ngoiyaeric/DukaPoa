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


public class Authentication implements Registry {
    
    protected String username;
    protected String password;
    protected String role;


    public Authentication(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }


    public String getRole() {
        return role;
    }



    public void setRole(String role) {
        this.role = role;
    }

    
    //authenticate user from postgresql database

    public boolean authenticateUser(String username, String password, String role) {
        boolean authenticated = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password) && rs.getString("role").equals(role)) {
                    authenticated = true;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticated;
    }

    //authorize user from postgresql database based on role

    public boolean authorizeUser(String username, String password, String role) {
        boolean authorized = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password) && rs.getString("role").equals(role)) {
                    authorized = true;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorized;
    }

    //connect to postgresql database
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //add user to postgresql database
    public void createUser(String username, String password, String role) {
        try {
            Connection conn = connect();
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //remove user from postgresql database

    public void removeUser(String username, String password, String role) {
        try {
            Connection conn = connect();
            String sql = "DELETE FROM users WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

package SmartShoppers;
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

public class Item {
    int Price;
    int id;
    String name;
    String description;
    Boolean Sale;

    public Item(int Price, int id, String name, String description, Boolean Sale) {
        this.Price = Price;
        this.id = id;
        this.name = name;
        this.description = description;
        this.Sale = Sale;
    }

    public Item(String string, double double1, String string2, String string3, boolean boolean1, int int1) {
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setSale(Boolean Sale){
        this.Sale = Sale;
    }

    public Boolean getSale() {
        return this.Sale;
    }

    public void setSalePrice (int price, int discount) {
        this.Price = price - (price * discount)/100;
    }


    

}

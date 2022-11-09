package SmartShoppers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Store {
    
    Double Location;
    String Name;
    int StoreID;
    ArrayList<Item> AllItems;
    ArrayList<Item> RecommenderList;
    ArrayList<Item> ShoppingList;
    ArrayList<Item> SaleList;
    final int MaxInt = Integer.MAX_VALUE;
    Random random = new Random();

    
    public Store(Double Location, String Name, ArrayList<Item> AllItems, ArrayList<Item> ShoppingList, ArrayList<Item> SaleList, int StoreID) {
        this.Location = Location;
        this.Name = Name;
        this.AllItems = AllItems;
        this.ShoppingList = ShoppingList;
        this.SaleList = SaleList;
    }

    public Double getLocation() {
        return Location;
    }

    public void setLocation(Double Location) {
        this.Location = Location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


   public void addItemtoItemList(Item inputItem) {
        this.AllItems.add(inputItem);
    }

    public void addItemtoShoppingList(Item inputItem) {
        this.ShoppingList.add(inputItem);
    }

    public void addItemtoSaleList(Item inputItem) {
        if (inputItem.getSale() == true) {
            this.SaleList.add(inputItem);
        }
        this.SaleList.add(inputItem);
    }

    public void removeItemfromItemList(Item inputItem) {
        this.AllItems.remove(inputItem);
    }

    public void removeItemfromShoppingList(Item inputItem) {
        this.ShoppingList.remove(inputItem);
    }

    public void removeItemfromSaleList(Item inputItem) {
        this.SaleList.remove(inputItem);
    }

    public void printItemList() {
        for (Item item : this.RecommenderList) {
            System.out.println(item.getName());
        }
    }

    public void printShoppingList() {
        for (Item item : this.ShoppingList) {
            System.out.println(item.getName());
        }
    }

    public void printSaleList() {
        for (Item item : this.SaleList) {
            System.out.println(item.getName());
        }
    }

    public int generateStoreID(int StoreID) {
        this.StoreID = random.nextInt(MaxInt);
        return this.StoreID;
    }
   
//fix method search method to search by ID and Generate Name
   public Item SearchbyName(String name) {
        for (Item item : this.AllItems) {
            if (item.getName().equals(name)) {
                Item output = item;
            }
            }
        return null;
    }
   
   public ArrayList SelectShoppingItems (List ArraylistItems){
        ArrayList<Item> ShoppingList = new ArrayList<Item>();
        for (Item item : this.AllItems) {
            if (item.getSale() == true) {
                ShoppingList.add(item);
            }
        }
        return ShoppingList;
    }

    public ArrayList SelectSaleItems (List ArraylistItems){
        ArrayList<Item> SaleList = new ArrayList<Item>();
        for (Item item : this.AllItems) {
            if (item.getSale() == false) {
                SaleList.add(item);
            }
        }
        return SaleList;
    }
    
    public ArrayList SortShoppingList(List AllItems, String sortBy) {
        ArrayList<Item> ShoppingList = new ArrayList<Item>();
        for (Item item : this.AllItems) {
            if (item.getSale() == true) {
                ShoppingList.add(item);
            }
        }
        return ShoppingList;
    }

    public void addManager(Manager newManager) {
    }

    public void removeManager(Manager newManager) {
    }


     //initiate datbase connection and query all products to allitems arraylist

     public void getAllItems() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM items");
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("category"), rs.getBoolean("sale"), rs.getInt("itemID"));
                this.AllItems.add(item);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   } 



package SmartShoppers;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class Manager extends Authentication {

    Store ManagedStore;
    

    public Manager(String username, String password, String role) {
        super(username, password, role);
        //TODO Auto-generated constructor stub
    }

    //create method to add new item to this store
    public void addItem(Item inputItem) {
        ManagedStore.addItemtoItemList(inputItem);
    }

    //remove item from this store 
    public void removeItem(Item inputItem) {
        ManagedStore.removeItemfromItemList(inputItem);
    }

    //create method to add item to sale list
    public void addItemtoSaleList(Item inputItem) {
        if (inputItem.getSale() == true) {
            ManagedStore.addItemtoSaleList(inputItem);
        }
    }

    //create method to remove item from sale list
    public void removeItemfromSaleList(Item inputItem) {
        if(inputItem.getSale() == true) {
            ManagedStore.removeItemfromSaleList(inputItem);
        }
    }

    public void setManagedStore(Store managedStore2) {
    }


   
    
    
    
}


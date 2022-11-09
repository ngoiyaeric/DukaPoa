package SmartShoppers;

public interface Registry {

    //create new user
    public void createUser(String username, String password, String role);

    //remove user
    public void removeUser(String username, String password, String role);
    
}

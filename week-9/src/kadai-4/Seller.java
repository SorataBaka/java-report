public class Seller extends User {
    private String storeName;
    public Seller Seller(String firstName, String lastName, String email, String storeName){
        super(firstName, lastName, email);
        this.storeName = storeName;
        return this;
    }
    public Seller setStoreName(String newStoreName){
        this.storeName = newStoreName;
        return this;
    }
    public String getStoreName(){
        return this.storeName;
    }
}
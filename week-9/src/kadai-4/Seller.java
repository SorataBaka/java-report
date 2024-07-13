import java.util.ArrayList;

public class Seller extends User {
    private String storeName;
    private ArrayList<Item> itemList;
    public Seller(String firstName, String lastName, String email, String storeName){
        super(firstName, lastName, email);
        this.storeName = storeName;
        this.itemList = new ArrayList<>();
        
    }
    public Seller setStoreName(String newStoreName){
        this.storeName = newStoreName;
        return this;
    }
    public String getStoreName(){
        return this.storeName;
    }
    public ArrayList<Item> getAllItems(){
        return this.itemList;
    }
    public Item getItem(int itemIndex){
        return this.itemList.get(itemIndex);
    }
    public Item getItem(String id){
        Item retrievedItem = null;
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getItemId().equals(id)){
                retrievedItem = itemList.get(i);
            }
        }
        return retrievedItem;
    }
    public ArrayList<Item> addItem(Item newItem){
        this.itemList.add(newItem);
        return this.itemList;
    }
    public Item removeItem(String targetId){
        Item removedItem = null;
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getItemId().equals(targetId)){
                removedItem = itemList.get(i);
                itemList.remove(i);
            }
        }
        return removedItem;
    }
}
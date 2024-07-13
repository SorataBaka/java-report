import java.util.UUID;
import java.time.LocalDate;
public class Item {
    private String itemName;
    private double price;
    private String[] category;
    private UUID itemId;
    private LocalDate createdAt;
    public Item(String itemName, double price, String[] category){
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.itemId = UUID.randomUUID();
        this.createdAt = LocalDate.now();
    }
    public Item setName(String itemName){
        this.itemName = itemName;
        return this;
    }
    public Item setPrice(double newPrice){
        this.price = newPrice;
        return this;
    }
    public Item setCategory(String[] newCategory){
        this.category = newCategory;
        return this;
    }
    public String getName(){
        return this.itemName;
    }
    public double getPrice(){
        return this.price;
    }
    public String[] getCategory(){
        return this.category;
    }
    public String getItemId(){
        return this.itemId.toString();
    }
    public LocalDate getCreatedAt(){
        return this.createdAt;
    }

    
}
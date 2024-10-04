import java.util.ArrayList;
// IS-A User
class Buyer extends User {
  private ArrayList<Item> orders;
  public Buyer(String firstName, String lastName, String email){
    super(firstName, lastName, email);
    this.orders = new ArrayList<>();
  }
  public ArrayList<Item>addOrder(Item newOrder){
    this.orders.add(newOrder);
    return this.orders;
  }
  public ArrayList<Item>getAllOrders(){
    return this.orders;
  }
}
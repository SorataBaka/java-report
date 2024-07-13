import java.util.ArrayList;
class Furima{
  public static void main(String[] args){
    Seller seller = new Seller("Emma","Johnson","emma.johnson@example.com","Chic Boutique");
    Buyer buyer = new Buyer("Christian", "Harjuno", "harjuno.tian@gmail.com");
    //確認
    System.out.println(seller.getStoreName());
    System.out.println(seller.getName());
    System.out.println(buyer.getName());

    System.out.println("");

    //商品を追加
    String[] categories = {"シャツ"};
    seller.addItem(new Item("コットンシャツ", 900.00, categories));
    seller.addItem(new Item("エアリズムコットンT", 999.00, categories));
    seller.addItem(new Item("間違い商品", 999.00, categories));
    
    //全ての商品を印刷
    ArrayList<Item> items = seller.getAllItems();
    for(int i = 0; i < items.size(); i++){
      System.out.println(items.get(i).getName() + " " + items.get(i).getPrice());
    }

    System.out.println("");

    //間違い商品を直し
    seller.getItem(2).setName("正しい商品").setPrice(1000.00); //チェンメソッド

    //全ての商品を印刷
    items = seller.getAllItems();
    for(int i = 0; i < items.size(); i++){
      System.out.println(items.get(i).getName() + " " + items.get(i).getPrice());
    }



    String itemId = seller.getItem(0).getItemId();
    System.out.println("\n商品のID: " + itemId);

    Item orderedItem = seller.removeItem(itemId);
    buyer.addOrder(orderedItem);

    //全ての商品を印刷
    System.out.println("\n売り手");
    items = seller.getAllItems();
    for(int i = 0; i < items.size(); i++){
      System.out.println(items.get(i).getName() + " " + items.get(i).getPrice());
    }
    System.out.println("\n買い手");
    items = buyer.getAllOrders();
    for(int i = 0; i < items.size(); i++){
      System.out.println(items.get(i).getName() + " " + items.get(i).getPrice());
    }
  }
}
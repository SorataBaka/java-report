
class Vector2DApp {
    public static void main(String[] args){
        Vector2D a = new Vector2D(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        Vector2D b = new Vector2D(Double.parseDouble(args[2]), Double.parseDouble(args[3]));


        a.print();
        b.print();
        System.out.println(a.innerProduct(b));




        
    }
}
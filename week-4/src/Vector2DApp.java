
class Vector2DApp {
    public static void main(String[] args){
        Vector2D a = new Vector2D(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        Vector2D b = new Vector2D(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        a.print();
        a.subtract(b);
        double distance = a.magnitude();
        System.out.println(distance);
    }
}
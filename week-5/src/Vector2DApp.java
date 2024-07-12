
class Vector2DApp {
    public static void main(String[] args){
        Double x1 = Double.parseDouble(args[0]);
        Double y1 = Double.parseDouble(args[1]);
        Double x2 = Double.parseDouble(args[2]);
        Double y2 = Double.parseDouble(args[3]);
        Vector2D a = new Vector2D(x1, y1);
        Vector2D b = new Vector2D(x2, y2);

        a.add(b);
        a.add(a , b)



    }
}
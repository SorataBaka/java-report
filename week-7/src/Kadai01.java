class Kadai01 {
    static double calcArea(double a, double b){
        return a * b / 2;
    }
    public static void main(String[] args){
        double arg1 = Double.parseDouble(args[0]);
        double arg2 = Double.parseDouble(args[1]);
        double result = Kadai01.calcArea(arg1, arg2);
        System.out.println(result);
    }
}
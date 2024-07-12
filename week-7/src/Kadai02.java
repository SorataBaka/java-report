class Kadai02 {
    static double calcAve(int a, int b, int c, int d, int e){
        return (a + b + c + d + e)/5.0;
    }
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);
        double average = Kadai02.calcAve(a, b, c, d, e);
        System.out.println(average);
    }
}
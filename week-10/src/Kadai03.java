public class Kadai03 {
    public static double calcMean(int[] a){
        double total = 0;
        for(int i = 0; i < a.length; i++){
            total += a[i];
        }
        return total / a.length;
    }
    public static void main(String[] args){
        int[] a = new int[args.length];
        for(int i = 0; i < args.length; i++){
            a[i] = Integer.parseInt(args[i]);
        }
        double mean = calcMean(a);
        System.out.println(mean);
    }
}
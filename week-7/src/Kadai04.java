class Kadai04 {
    static int isU18(int input){
        return input < 18 ? 1 : 0;
    }
    public static void main(String[] args){
        int input = Integer.parseInt(args[0]);
        System.out.println(Kadai04.isU18(input));
    }
}
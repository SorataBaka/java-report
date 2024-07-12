class Kadai03 {
    static int isOddNum(int num){
        return num % 2;
    }
    public static void main(String[] args){
        int inputNum = Integer.parseInt(args[0]);
        System.out.println(Kadai03.isOddNum(inputNum));
    }
}
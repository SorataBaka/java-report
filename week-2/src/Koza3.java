class Koza3 {
    double riritsu;
    int gankin;

    Koza3(int gankinInit) {
        //後で定義するではなく、このクラスを発生するとき、gankin変数の値をすぐ定義する
        riritsu = 0.01;
        gankin = gankinInit;
    }
    // 最も効率がいいコード。それだけではなく、新しい変数を発生することが必要はありません。
    double risoku(int month){
        return (double) gankin * riritsu * (double)month/12;
    }
    public static void main (String[] args){
        try {
            if(args.length == 0 || args.length > 2){
                System.out.println("使い方：java Koza3 {gankin} {getsu}");
                throw new Exception("args が正しく入力されませんでした。");
            }
            int gankin = Integer.parseInt(args[0]);
            int months = Integer.parseInt(args[1]);

            if(gankin < 0 || months < 1) throw new Exception("入力に間違いがあります。");

            Koza3 my_koza = new Koza3(gankin);
            System.out.println("my_kozaの値は　" + my_koza);

            double kotae = my_koza.risoku(months);
            String formattedString = String.format("利息は %.2f", kotae);
            System.out.println(formattedString);
            System.exit(0);
            
        } catch (Exception e){
            System.out.println(e);
            System.exit(-1);
        }
    }
}
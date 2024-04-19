class Koza2 {
    double riritsu;
    int gankin;

    Koza2(int gankinInit) {
        //後で定義するではなく、このクラスを発生するとき、gankin変数の値をすぐ定義する
        riritsu = 0.01;
        gankin = gankinInit;
    }
    // 最も効率がいいコード。それだけではなく、新しい変数を発生することが必要はありません。
    double risoku(int month){
        return (double)gankin * riritsu * (double)month/12;
    }
    public static void main (String[] args){
        if(args.length == 0){
            System.out.println("args が入力されませんでした。");
            System.exit(-1);
            return;
        }
        //1 行のコードですべてがすっきりします
        int gankin = Integer.parseInt(args[0]);
        Koza2 my_koza = new Koza2(gankin);
        System.out.println("my_kozaの値は　" + my_koza);
        double kotae = my_koza.risoku(6);
        
        System.out.println("利息は"+ kotae);
        System.exit(0);
    }
}

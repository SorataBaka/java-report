class Koza {
    double riritsu;
    int gankin;

    Koza(int gankinInit) {
        //後で定義するではなく、このクラスを発生するとき、gankin変数の値をすぐ定義する
        riritsu = 0.01;
        gankin = gankinInit;
    }

    // double risoku(int month){
    //     double kekka;
    //     kekka = (double)gankin * riritsu * (double)month / 12.0;
    //     return kekka;
    // }
    // 最も効率がいいコード。それだけではなく、新しい変数を発生することが必要はありません。
    double risoku(int month){
        return (double)gankin * riritsu * (double)month/12;
    }
    public static void main (String[] args){
        //1 行のコードですべてがすっきりします
        Koza my_koza = new Koza(10000);
        System.out.println("my_kozaの値は　" + my_koza);
        //さっきから定義されましたから、この下のコードは必要ではない。
        // my_koza.gankin = 10000;
        double kotae = my_koza.risoku(6);
        
        System.out.println("利息は"+ kotae);
        System.exit(0);
    }
}
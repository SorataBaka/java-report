public class ArrayListInt {
    private int saidai;
    private int[] a;
    private int jissai;
    public ArrayListInt(){
        this.saidai = 5;
        this.a = new int[this.saidai];
        this.jissai = 0;
    }
    public void add(int newNumber){
        if(this.jissai == this.saidai){
            System.out.println("エラーが発生しました。配列が最大容量に達しました。");
            return;
        }
        this.a[this.jissai++] = newNumber;
        return;
    }
    public void print(){
        for(int i = 0; i < this.jissai; i++){
            System.out.println(this.a[i]);
        }
        return;
    }
    public int size(){
        return this.jissai;
    }
    public int get(int index){
        return this.a[index];
    }
}
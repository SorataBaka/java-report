public class ClassRoom {
    private int saidai;
    private Kosensei[] a;
    private int jissai;
    public ClassRoom(){
        this.saidai = 5;
        this.a = new Kosensei[this.saidai];
        this.jissai = 0;
    }
    public void add(Kosensei newStudent){
        if(this.jissai == this.saidai){
            System.out.println("エラーが発生しました。配列が最大容量に達しました。");
            return;
        }
        this.a[this.jissai++] = newStudent;
        return;
    }
    public int size(){
        return this.jissai;
    }
    public Kosensei get(int index){
        return this.a[index];
    }
    public void shokai(){
        for(int i = 0; i < this.jissai; i++){
            this.a[i].intro();
        }
    }

}
public class Tsusei extends Kosensei {
    private String tsugaku;
    public Tsusei(String name, int year, String department, String tsugaku){
        super(name, year, department);
        this.tsugaku = tsugaku;
    }
    public String getTsugaku(){
        return this.tsugaku;
    }
    public void intro(){
        String introString = String.format("私は、%d年%sの%sでございます。毎日%sで学校へ行きます。", this.getYear(), this.getDepartment(), this.getName(), this.tsugaku);
        System.out.println(introString);
    }
}
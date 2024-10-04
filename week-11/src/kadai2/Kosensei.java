public class Kosensei {
    private String name;
    private int year;
    private String department;

    public Kosensei(String name, int year, String department){
        this.name = name;
        this.year = year;
        this.department = department;
    }
    public void intro(){
        System.out.println(String.format("私は、%d年%sの%sでございます。", this.year, this.department, this.name));
    }
    public int getYear(){
        return this.year;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getName(){
        return this.name;
    }
}
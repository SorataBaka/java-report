public class Ryosei extends Kosensei {
    private Ryosei doshitsusha;
    public Ryosei(String name, int year, String department){
        super(name, year, department);
        this.doshitsusha = null;
    }
    public void intro(){
        String doshitsushaNamae = this.doshitsusha == null ? "なし" : this.doshitsusha.getName();
        String introString = String.format("私は、%d年%sの%sでございます。%sと同室しています。", this.getYear(), this.getDepartment(), this.getName(), doshitsushaNamae);
        System.out.println(introString);
    }
    public void setDoshitsusha(Ryosei student){
        this.doshitsusha = student;
        if(student.getDoshitsusha() == this) return; //無限的に繰り返さないように
        student.setDoshitsusha(this);
    }
    public Ryosei getDoshitsusha(){
        return this.doshitsusha;
    }

}
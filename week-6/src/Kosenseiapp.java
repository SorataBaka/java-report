class Kosenseiapp {
    public static void main(String[] args){
        Kosensei student = new Kosensei("Chris", 4, "情報", "寮");
        Kosensei studentA = new Kosensei("Peem", 4, "情報", "自宅");
        student.shinkyu();
        Kosensei.shinkyu(studentA);
    }
}
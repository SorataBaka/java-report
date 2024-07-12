public class RyoseiApp {
    public static void main(String[] args){
        Ryosei student = new Ryosei("クリス", 4, "情報");
        Ryosei doshitsusha = new Ryosei("バチカ", 4, "建築");
        student.setDoshitsusha(doshitsusha);
        student.intro();
        doshitsusha.intro();
    }
}
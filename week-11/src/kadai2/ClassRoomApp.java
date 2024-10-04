public class ClassRoomApp {
    public static void main(String[] args){
        ClassRoom newClassroom = new ClassRoom();
        Ryosei a = new Ryosei("クリス",4, "情報");
        Ryosei b = new Ryosei("バチカ",4, "情報");
        Tsusei c = new Tsusei("西村",4, "情報", "バス");

        a.setDoshitsusha(b);

        newClassroom.add(a);
        newClassroom.add(b);
        newClassroom.add(c);

        //エラーを発生するように
        newClassroom.add(new Ryosei("ア様",4 , "情報"));
        newClassroom.add(new Ryosei("イ様",4 , "情報"));
        newClassroom.add(new Ryosei("ウ様",4 , "情報"));


        int currentSize = newClassroom.size();
        Kosensei firstStudent = newClassroom.get(0);
        newClassroom.shokai();

        System.out.println("配列の現在のサイズは" + currentSize);
        System.out.println("配列の最初の学生は" + firstStudent.getName());


    }
}
class Kosenseiapp {
    public static void main(String[] args){
        Sumaho newPhone = new Sumaho();
        newPhone.setName("Iphone");
        newPhone.setMemory(128);
        newPhone.setStorage(256);

        Kosensei student = new Kosensei();
        student.setName("クリス"); 
        student.setAddress("釧路");
        student.setYear(4); //ここで値が変わる
        student.setDepartment("機械"); //ここで値が変わる。

        System.out.println("スマホなし");
        student.intro();
        System.out.println("\nスマホあり");
        student.setSmartphone(newPhone);
        student.intro();

    }
}
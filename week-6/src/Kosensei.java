class Kosensei {
    String name;
    int year;
    String department;
    String address;

    Kosensei(String name, int year, String department, String address){
        this.name = name;
        this.year = year;
        this.department = department;
        this.address = address;
    }
    void intro(){
        System.out.println(String.format("私は、%d年%sの%sでございます。現在、私は%sに住んでいます。", this.year, this.department, this.name, this.address));
    }
    static void intro(Kosensei student){
        System.out.println(String.format("彼は、%d年%sの%sです。現在、私は%sに住んでいます。", student.year, student.department, student.name, student.address));
    }
    void hantei(Kosensei student){
        if(this.address.equals(student.address)){
            System.out.println(String.format("私\"%s\"と\"%s\"さんは通学仲間です。", this.name, student.name));
        } else {
            System.out.println(String.format("私\"%s\"と\"%s\"さんは通学仲間ではありません。", this.name, student.name));
        }

    }
    static void hantei(Kosensei studentA, Kosensei studentB){
        if(studentA.address.equals(studentB.address)){
            System.out.println(String.format("\"%s\"と\"%s\"さんは通学仲間です。", studentA.name, studentB.name));
        } else {
            System.out.println(String.format("\"%s\"と\"%s\"さんは通学仲間ではありません。", studentA.name, studentB.name));
        }
    }
    void shinkyu(){
        this.year += 1;
        System.out.println(String.format("私は%d年に進級しました!", this.year));
        return;
    }
    static void shinkyu(Kosensei student){
        student.year += 1;
        System.out.println(String.format("彼は%d年に進級しました!", student.year));
        return;
    }

}
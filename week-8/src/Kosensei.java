import java.util.Arrays;
class Kosensei {
    private String name;
    private int year;
    private String department;
    private String address;

    private Sumaho smartphone;

    Kosensei(){
        this.smartphone = null;
        this.year = 0;
        this.department = "未定";
        this.name = "未定";
        this.address = "未定";
    }
    void intro(){
        System.out.println(String.format("私は、%d年%sの%sでございます。現在、私は%sに住んでいます。", this.year, this.department, this.name, this.address));
        if(this.smartphone != null){
            System.out.println("私は" + this.smartphone.getName() + "を持っています.");
        }
    }

    void setYear(int year){
        if (year < 1 || year > 5) return;
        this.year = year;
        return;
    }
    int getYear(){
        return this.year;
    }
    void setDepartment(String departmentName){
        String[] validDepartments = {"情報", "機械", "電気", "電子", "建築"};
        if(Arrays.asList(validDepartments).indexOf(departmentName) == -1) return;
        this.department = departmentName;
        return;
    }
    String getDepartment(){
        return this.department;
    }
    void setName(String name){
        this.name = name;
        return;
    }
    String getName(){
        return this.name;
    }
    void setAddress(String address){
        this.address = address;
        return;
    }
    String getAddress(){
        return this.address;
    }
    void setSmartphone(Sumaho phone){
        this.smartphone = phone;
        return;
    }   
    Sumaho getSmartphone(){
        return this.smartphone;
    }
}
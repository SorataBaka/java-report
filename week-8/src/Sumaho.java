import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sumaho {
    private String name;
    private int memory;
    private int storage;
    Sumaho(){
        this.name = "未定";
        this.memory = 0;
        this.storage = 0;
    }
    void setName(String name){
        Pattern namePattern = Pattern.compile("^[A-Z][A-Za-z0-9]{3,9}$");
        Matcher matcher = namePattern.matcher(name);
        boolean isValid = matcher.find();
        if(!isValid) return;
        this.name = name;
        return;
    }
    String getName(){
        return this.name;
    }
    void setMemory(int memory){
        if(memory < 64) return;
        if(memory % 64 != 0) return;
        this.memory = memory;
        return;
    } 
    int getMemory(){
        return this.memory;
    }
    void setStorage(int storage){
        if(storage < 128) return;
        if(storage % 128 != 0) return;
        this.storage = storage;
        return;
    }
    int getStorage(){
        return this.storage;
    }



}
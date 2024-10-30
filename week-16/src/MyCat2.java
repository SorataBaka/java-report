import java.io.*;
public class MyCat2 {
    public static void main(String[] args){
        try {
            if(args.length == 0) throw new Exception("引数足りない");
            String fileName = args[0];
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String buffer;
            String concat = new String();
            while((buffer = bufferedReader.readLine()) != null){
                concat += buffer;
                concat += System.getProperty("line.separator");
            }
            System.out.println(concat);
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
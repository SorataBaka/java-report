import java.io.*;
public class MyCat {
    public static void main(String[] args){
        try {
            if(args.length == 0) throw new Exception("引数足りない");
            String fileName = args[0];
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String buffer;
            while((buffer = bufferedReader.readLine()) != null){
                System.out.println(buffer);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
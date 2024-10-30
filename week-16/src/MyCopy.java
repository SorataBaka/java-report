import java.io.*;
public class MyCopy {
    public static void main(String[] args){
        try {
            if(args.length < 2) throw new Exception("引数足りない");
            String fileName = args[0];
            String fileName2 = args[1];

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //読み込み
            String buffer;
            String concat = new String();
            while((buffer = bufferedReader.readLine()) != null){
                concat += buffer;
                concat += System.getProperty("line.separator");
            }

            //掃除
            bufferedReader.close();
            fileReader.close();
            
            //書き込み
            FileWriter fileWrite = new FileWriter(fileName2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);

            bufferedWriter.write(concat);
            bufferedWriter.flush();

            //掃除
            fileWrite.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
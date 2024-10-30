import java.io.*;
public class MyCopyAll {
    public static void main(String[] args){
        try {
            if(args.length < 2) throw new Exception("引数足りない");
            String fileName2 = args[args.length - 1];
            //読み込み
            String buffer;
            String concat = new String();


            for(int i = 0; i < args.length - 1; i++){
                String fileName = args[i];
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while((buffer = bufferedReader.readLine()) != null){
                    concat += buffer;
                    concat += System.getProperty("line.separator");
                }
                fileReader.close();
                bufferedReader.close();
            }

            FileWriter fileWriter = new FileWriter(fileName2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(concat);
            bufferedWriter.flush();

            bufferedWriter.close();
            fileWriter.close();
           
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
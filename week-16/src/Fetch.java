import java.net.*;
import java.io.*;
public class Fetch {
    public static void main(String[] args){
        try {
            String urlString = "http://jsuri1.info.kushiro-ct.ac.jp/~tenmo/java/hello.txt";
            URL urlObject = new URL(urlString);

            HttpURLConnection http = (HttpURLConnection)urlObject.openConnection();
            http.setRequestMethod("GET");
            http.connect();

            InputStreamReader streamReader = new InputStreamReader(http.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String buffer;
            String concat = new String();

            while((buffer = bufferedReader.readLine()) != null){
                concat += buffer;
                concat += System.getProperty("line.separator");
            }

            bufferedReader.close();
            streamReader.close();

            System.out.println(concat);
        } catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
    }
}
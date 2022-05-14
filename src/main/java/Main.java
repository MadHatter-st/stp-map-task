import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {//commit
        Map<Integer, String> map = new TreeMap<Integer, String>();
        BufferedReader in = new BufferedReader(new FileReader("access.log"));
        String  line = "";
        int i = 0;
        while ((line = in.readLine()) != null) {
            String[] parts = line.split("\\s+");
            i++;
            map.put(i, parts[2] + " " + parts[4]);
        }
        in.close();
        System.out.println(map.toString());
    }
}

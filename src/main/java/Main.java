import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {//commit
        Map<Integer, String> map = new TreeMap<Integer, String>();
        Map<String,Integer> test = new TreeMap<String,Integer>();
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\access.log"));
        String  line = "";
        int i = 0;
        while ((line = in.readLine()) != null) {
            String[] parts = line.split("\\s+");
            i++;
            map.put(i, parts[2]);
            if(!test.containsKey(parts[2])){
                test.put(parts[2],Integer.parseInt(parts[4]));
            }else{
                test.put(parts[2], test.get(parts[2]) + Integer.parseInt(parts[4]));
            }
        }
        in.close();
        System.out.println(test.toString());
    }
}

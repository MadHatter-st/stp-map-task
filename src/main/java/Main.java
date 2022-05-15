import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<Integer, String> map = new TreeMap<Integer, String>();
        Map<Integer, String> logs = new TreeMap<Integer, String>();
        Map<String, Double> data = new HashMap<String, Double>();
        ValueComparator bvc = new ValueComparator(data);
        Map<String, Integer> time = new TreeMap<String, Integer>();
        Map<String, Double> maxData = new TreeMap<String, Double>(bvc);
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\access.log"));
        String line = "";
        int i = 0;
        while ((line = in.readLine()) != null) {
            String[] parts = line.split("\\s+");
            i++;
            map.put(i, parts[2]);
            logs.put(i, line);
            if (!data.containsKey(parts[2])) {
                data.put(parts[2], Double.parseDouble(parts[4]));
                time.put(parts[2], Integer.parseInt(parts[1]));
            } else {
                data.put(parts[2], data.get(parts[2]) + Double.parseDouble(parts[4]));
                time.put(parts[2], time.get(parts[2]) + Integer.parseInt(parts[1]));
            }
            data.put(parts[2], data.get(parts[2]) / time.get(parts[2]));
        }
        in.close();

        maxData.putAll(data);
        System.out.println("results: " + maxData);

//        System.out.println(data.toString());
//        data.entrySet().stream()
//                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
//                .forEach();

        try (FileWriter writer = new FileWriter("out.txt")) {
                for (Integer key : logs.keySet()) {
                    if(maxData.containsKey(map.get(key))){
                        writer.write(logs.get(key)+"\n");
                    }
                }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

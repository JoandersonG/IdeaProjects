import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String caminho, line;
        caminho = "/home/joanderson/PersonalProjects/summary.csv";
        Map<String,Integer> map = new TreeMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            line = br.readLine();
            String[] parts;
            while(line != null) {

                parts = line.split(",");
                if (map.containsKey(parts[0])) {
                    map.put(parts[0],map.get(parts[0]) + Integer.parseInt(parts[1]));
                }
                else {
                    map.put(parts[0],Integer.parseInt(parts[1]));
                }
                line = br.readLine();
            }

            for (String key : map.keySet() ) {
                System.out.println(key + ": " + map.get(key));
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}

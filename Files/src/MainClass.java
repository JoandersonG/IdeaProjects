import javax.imageio.IIOException;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        double price;
        int quantity;

        Locale.setDefault(Locale.US);
        String pathRead = "/home/joanderson/PersonalProjects/summary.csv";
        boolean success = new File("/home/joanderson/PersonalProjects/out").mkdir();
        String pathWrite ="/home/joanderson/PersonalProjects/out/summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(pathRead))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite))) {


                String line = br.readLine();
                ;
                while (line != null) {
                    String[] splitted = line.split(",");
                    bw.write(splitted[0]+",");

                    price = Double.parseDouble(splitted[1]);
                    quantity = Integer.parseInt(splitted[2]);
                    bw.write(String.valueOf(price * quantity));
                    bw.newLine();
                    line = br.readLine();
                }

            }
        }
        catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());

        }
    }
}

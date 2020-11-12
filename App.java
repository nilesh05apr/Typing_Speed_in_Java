import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        String[] word = new String[0];
        String line;
        int score = 0;
        try (InputStream fis = new FileInputStream("F:\\Codings\\Java\\inteliJ Java\\TypingSpeedChecker\\src\\dataFile.txt")) {
            try (InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8)) {
                try (BufferedReader br = new BufferedReader(isr)) {
                    while ((line = br.readLine()) != null) {
                        word = line.split(" ");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long start = System.nanoTime();
        while(true){
            Random rand = new Random();
            int i = rand.nextInt((word.length)-1);
            String output_string = word[i];
            System.out.println("Type: " + output_string);
            Scanner sc = new Scanner(System.in);
            String input_string = sc.nextLine();
            if(input_string.equals(output_string)){
                System.out.println("Correct.\n");
                score += 10;
            }
            else{
                System.out.println("Incorrect");
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Grand Score: " + score+" points.");
        float results =  (float) ((score/10)*60)/(float) (end-start);
        System.out.println("Your typing speed is: " + results+ " words per minute.");
/*        for (String s : word) {
            System.out.println(s);
        }*/
    }
}

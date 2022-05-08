import java.util.Arrays;
import java.util.Scanner;
import gtc.DATABASE.Data;
import gtc.CALCULATE.Calculate;

public class Demo {
    public static void main(String[] args) {
        Calculate c = new Calculate();
        Scanner sc = new Scanner(System.in);
        int fi = 0;
        for(int i = 0 ; i < Data.Q.length ; i++){    
            System.out.print(Data.Q[i] + " : ");
            int choice = sc.nextInt();
            fi = c.categorizeInput(i, choice);
        }
        System.out.println("I am Thinking of : " + Data.Name[fi]);
        sc.close();
    }
}

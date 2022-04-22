import Database.Data;
import FRONTEND.Frontend;

public class Main {
    public static void main(String[] args) {
        // System.out.println(Data.val);
        int A[] = Data.getData();
        for(int i = 0 ; i < A.length; i++){
            System.out.println(A[i]);
        }
        // Frontend f = new Frontend();
    }
}

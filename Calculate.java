package gtc.CALCULATE;
import gtc.DATABASE.Data;
import java.util.Arrays;
public class Calculate {
    
    static Float fav[];
    static Integer inp[];

    public Calculate(){
        int NOC = Data.Name.length;
        fav = new Float[NOC];
        Arrays.fill(fav, 0.0f);
        inp = new Integer[Data.Q.length];
        Arrays.fill(inp, 0);
    }

    public int categorizeInput(int pos, int val){
        inp[pos] = val;
        for(int i = 0 ; i < Data.Name.length; i++){
            if(Data.YN[i][pos] == inp[pos])
                fav[i] = fav[i] + (float)1/(Data.Q.length);
            else
                fav[i] = fav[i] - (float)1/(Data.Q.length);
        }
        int max = -1;
        for(int i = 0 ; i < Data.Name.length ; i++){
            if(fav[i] >= 1)
                max = i;   
        }
        return max;
    }
}
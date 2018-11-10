import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class oddbinom {
    public static void main(String[] args){
        long n;
        Scanner input = new Scanner(System.in);

        n = input.nextLong();

        System.out.println(numOfOddBinom2(n));
    }

    public static int numOfOddBinom(int n){
        int[] prev = new int[]{1};
        int[] cur;
        int count = 1;

        for(int i = 1; i < n; i++){
            cur = new int[i+1];
            cur[0] = 1;
            cur[i] = 1;
            count += 2;

            for(int j = 1; j < (i+1)/2; j++){
                cur[j] = (prev[j] + prev[j-1]) % 2;
                if(cur[j] == 1) count += 2;
            }

            prev = cur;
        }

        return count;
    }

    public static int numOfOddBinom2(long n){
        int odd = 0, count;
        ArrayList<Integer> i_bin;

        for(long i = 0; i < n; i++){
            i_bin = toBinary(i);

            // count the number of 1 in i_bin
            count = 0;
            for(int x: i_bin){
                if (x == 1) count++;
            }

            odd += Math.pow(2, count);
        }

        return odd;
    }

    public static ArrayList<Integer> toBinary(long n){
        ArrayList<Integer> bin = new ArrayList<>();

        while(n != 0){
            bin.add((int)n%2);
            n = n/2;
        }

        return bin;
    }
}

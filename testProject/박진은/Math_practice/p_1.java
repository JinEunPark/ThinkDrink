package Math_practice;

import java.io.*;

public class p_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int rest = 0;


        count = n / 5;
        rest = n % 5;

        if (count == 0) {
            if (rest == 3) {
                count = 1;
            } else {
                count = -1;
            }
        } else {

            if (rest == 1) {
                count++;

            } else if (rest == 2) {
                if (count >= 2)
                    count += 2;
                else
                    count = -1;

            } else if (rest == 3) {
                count++;
            } else if (rest == 4) {
                    count += 2;
            }
        }
        System.out.print(count);
    }
}
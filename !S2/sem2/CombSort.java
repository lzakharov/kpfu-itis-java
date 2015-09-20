import java.io.*;

/**
 * Created by lzakharov on 14.03.15.
 */

public class CombSort {
    public static Long[] combSort(int[] a) {
        long time = System.nanoTime();
        int gap = a.length;
        boolean swapped = true;
        long cnt = 0;

        while (gap > 1 || swapped) {
            if (gap > 1.247330950103979) {
                gap = (int)(gap / 1.247330950103979);
            }

            int i = 0;
            swapped = false;

            while (i + gap < a.length) {
                if (a[i] > a[i + gap]) {
                    int k = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = k;
                    swapped = true;
                }

                cnt++;
                i++;
            }
        }

        Long[] ans = new Long[2];
        ans[0] = System.nanoTime() - time;
        ans[1] = cnt;

        return ans;
    }

    public static void main(String[] args) {
        int n;
        int[] a;

        try {
            BufferedReader fin = new BufferedReader(new FileReader("input.txt"));
            PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("output.csv")));
            fout.write("N;Time;Steps");
            fout.write('\n');
            String s;
            while ((s = fin.readLine()) != null) {
                n = Integer.parseInt(s);
                a = new int[n];
                s = fin.readLine();
                int i = 0;
                for (String t : s.split(" ")) {
                    a[i] = Integer.parseInt(t);
                    i++;
                }

                Long[] ans = combSort(a);
                fout.write(Integer.toString(n) + ";" + Long.toString(ans[0]) + ";" + Long.toString(ans[1]));
                fout.write('\n');
            }

            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

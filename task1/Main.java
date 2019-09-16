import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String str = args[0];

        float[] arr = convert(str);

        float perc = percentile(arr,90);

        float med = median(arr);

        float max = maxNum(arr);

        float min = minNum(arr);

        float aver = average(arr);

        System.out.print( String.format("%(.2f", perc) + "\n" + med + "\n"  + max + "\n" + min + "\n" + String.format("%(.2f", aver));
    }
    private static int k = 0;

    static float[] convert (String dir){
        String replace , str;
        float[] array = new float[1000];
        try (BufferedReader br = new BufferedReader(new FileReader(new File(dir)))) {
            int i = 0;
            while ((str = br.readLine()) != null) {
                {
                    replace  = str.replaceAll("\\\\n", "");

                    float f = Float.parseFloat(replace);
                    array[i] = f;
                    i++; k++;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return array;
    }
    static float percentile (float arr[], int per){
        float temp, NumFl, percen, mod;
        double NumInt;
        float p = (float)per;
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        NumFl = (p / 100f * (k - 1) +1);
        NumInt = Math.floor(NumFl);
        mod = NumFl % 1;
        int i = (int) NumInt;

        percen = arr[i] + (mod * (arr[i+1] - arr[i]));

        return percen;
    }
    static float median (float arr[]){
        float med, temp;

        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        if(k % 2 == 1){
            int i = k / 2;
            med = arr[i];
        }
        else {
            int i = k / 2;
            med = (arr[i-1] + arr[i]) / 2;
        }
        return med;
    }
    static float maxNum (float arr[]){
        float max = arr[0];
        for(int i = 0; i < k; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static float minNum (float arr[]){
        float min = arr[0];
        for(int i = 0; i < k; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    static float average (float arr[]){
        float aver = 0;
        for(int i = 0; i < k; i++){
            aver = aver + arr[i];
        }
        aver = aver / k;
        return aver;
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        String directory = args[0];

        float[] cash1 = convert(directory + "\\Cash1.txt");
        float[] cash2 = convert(directory + "\\Cash2.txt");
        float[] cash3 = convert(directory + "\\Cash3.txt");
        float[] cash4 = convert(directory + "\\Cash4.txt");
        float[] cash5 = convert(directory + "\\Cash5.txt");

        float[] sumArr = sumArray(cash1, cash2, cash3, cash4, cash5);

        float max = sumArr[0];
        int result = 0;
        for(int i=0; i<16; i++){
           if (sumArr[i]> max){
               max = sumArr[i];
               result = i+1;
           }
        }
        System.out.println(result);
        }

    public static float[] convert (String dir){
        String replace , str;
        float[] array = new float[16];
        try (BufferedReader br = new BufferedReader(new FileReader(new File(dir)))) {
            int i = 0;
            while ((str = br.readLine()) != null) {
                {
                    replace  = str.replaceAll("\\\\n", "");

                    float f = Float.parseFloat(replace);
                    array[i] = f;
                    i++;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return array;
    }

    public static float[] sumArray (float[] arr1, float[] arr2, float[] arr3, float[] arr4, float[] arr5){
        float[] sum = new float[16];

        for (int i=0; i<16; i++){
            sum[i]= arr1[i]+arr2[i]+arr3[i]+arr4[i]+arr5[i];
        }
        return sum;
    }
}

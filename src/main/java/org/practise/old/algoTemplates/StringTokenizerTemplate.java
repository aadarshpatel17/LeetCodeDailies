package algoTemplates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerTemplate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        5
//        [10, 20, 30, 40, 50]

        int n = Integer.parseInt(br.readLine());
        // Read the line with brackets
        String line = br.readLine();
        // Remove [ and ] and spaces
        line = line.replace("[", "").replace("]", "").replace(" ", "");
        // Use StringTokenizer with comma delimiter
        StringTokenizer st = new StringTokenizer(line, ",");
        int[] arr = new int[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        System.out.println("Array: " + Arrays.toString(arr));
    }
}

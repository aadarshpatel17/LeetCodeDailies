package org.practise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContainsDuplicateII219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] arr = str.trim().split(",");
        int[] ar = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            ar[i] = Integer.parseInt(arr[i]);
        }
        
        String k = br.readLine();

        bw.write(String.valueOf(containsNearbyDuplicate(ar, Integer.parseInt(k))));

        bw.flush();
        bw.close();
    }
	
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	return false;
    }
}

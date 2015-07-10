import java.io.*;    // In order to use BufferReader/Writer and FileReader/Writer.
import java.util.*;  // In order to use List and Set.
 
public class WordsTweeted {
    public static void main(String[] args) throws IOException {
        // Try to get the process time for this code with the start time, now comment out below.
		/*
		long start = System.currentTimeMillis();
        */
		
		// Use BufferReader/Writer and FileReader/Writer to read and write the input and output .txt files.
        BufferedReader br = new BufferedReader(new FileReader(args[0]));        
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        
		// Read the input line by line and declare a map to help me to count the words.		
		// Where I use TreeMap instead of HashMap to get the words in order as the example automatically.
        String line;
        Map<String, Integer> map = new TreeMap<String, Integer>();              
             
        while ((line = br.readLine()) != null) {
			// Spilt each line with one or more white space into a String Array.			
            String[] strArray = line.split(" +");
			// Use the TreeMap to help me to count the words.
            for (String str : strArray) {                   
                if (!map.containsKey(str)) {
                    map.put(str, 1);                        
                }else {
                    map.put(str, map.get(str) + 1);                 
                }
            }
        }           
		// Close the BufferedReader.
        br.close();
        
		// Use the variable, maxLength,	to get the max length of all the words to have an organized output.
        int maxLength = 0;
        for (String key : map.keySet()) {
            maxLength = Math.max(key.length(), maxLength);              
        }
        
		// Write the words and corresponding counts into the output.
		// Where I use map.entrySet() instead of map.keySet() in order to have better efficiency.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
			// Write the words first.
            bw.write(entry.getKey());               
			// Use the variable, maxLength, to write the output with organized format.
            for (int i = 0; i < maxLength - entry.getKey().length(); i++) {
                bw.write(" ");
            }
			// Write the corresponding counts.
            bw.write("\t" + entry.getValue() + "\r\n");             
        }
		// Close the BuferedWriter.
        bw.close(); 
        
		// Try to get the process time for this code and print it, now comment out below.
		/*
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
		*/
    }           
}
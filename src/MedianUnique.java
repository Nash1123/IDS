import java.io.*;    // In order to use BufferReader/Writer and FileReader/Writer.
import java.util.*;  // In order to use List and Set.
//import java.text.*;   In order to use DecimalFormat from line 58 to line 61 in this code (commented out now).
 
public class MedianUnique {
    public static void main(String[] args) throws IOException {
        // Try to get the process time for this code with the start time, now comment out below.
	/*
	long start = System.currentTimeMillis();
	*/

	// Use BufferReader/Writer and FileReader/Writer to read and write the input and output .txt files.
        BufferedReader br = new BufferedReader(new FileReader(args[0]));        
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        
	// Read the input line by line and store the number of unique words with each line in a List.
        String line;        
        List<Integer> list = new ArrayList<Integer>();      
         
        while ((line = br.readLine()) != null) {
		// Declare a HashSet for each line to help me to get the number of unique words for each line.
            	Set<String> set = new HashSet<String>();
		// Spilt each line with one or more white space into a String Array.
            	String[] strArray = line.split(" +");
		// Add every word into the set and will get the set with all words in this line without any repeat word.
           	for (String str : strArray) {
                	set.add(str);                   
      		}                                   
		// Use an int variable, index, to help me to add the number of unique words of each line into the List in order.
		// Where the number of unique words of each line is set.size().
		// There is an alternative way with easier code by using Collections below:
		/* 
		list.add(set.size());
		Collections.sort(list);
		*/
		// However, I use the way with index variable in order to get better efficiency.			
            	int index = 0;
            	int preLen = list.size();
        	int num = set.size();
        	while (index < preLen) {
        		if (num < list.get(index)) break;
        		index++;
        	}
            	list.add(index, num);
			
		// In order to write the median to the output, I try to get the size of the list first.
		// If the size of the list is odd, just write list.get(len / 2) into the output.
		// If the size of the list is even, then check the sum of list.get(len / 2) + list.get(len / 2 - 1).
		// If the sum is even, just write sum / 2 into the output.
		// If the sum is odd, write ".5" after sum / 2.
		// Where I did not use double for this feature with the same result of 9th FAQ.
		// Because for getting median, there will not have any 2/3 case. 
		// There will be only integer or an integer with .5 after it.
		// I keep this feature whit the same result of the original READEME.md example.		
		// However, I also write the code with the same result of 9th FAQ below by using DecimalFormat below:
		// (By using DecimalFormat, need to import java.text.* in 3rd line in this code which is commented out now).
		/*
		DecimalFormat df = new DecimalFormat("0.00");			
		int len = list.size();
		double median = (len % 2 == 1)? list.get(len / 2) : (double)(list.get(len / 2) + list.get(len / 2 - 1)) / 2; 
		bw.write(df.format(median) + "\r\n");
		*/
        	int len = list.size();
            	if (len % 2 == 1) {
                	bw.write(list.get(len / 2) + "\r\n");               
            	}else {
                	int sum = list.get(len / 2) + list.get(len / 2 - 1);
                	if (sum % 2 == 0) {
                    		bw.write(sum / 2 + "\r\n");
	                }else {
        	            	bw.write(sum / 2 + ".5\r\n");
                	}               
            	}                                   
        }        
		
	// Close the BufferedReader and BufferedWriter.
        br.close();         
        bw.close();     
        
	// Try to get the process time for this code and print it, now comment out below.
        /*
	long time = System.currentTimeMillis() - start;     
        System.out.println(time);
	*/
    	}
}

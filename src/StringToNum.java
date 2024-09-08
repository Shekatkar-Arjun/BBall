import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringToNum {
   public static void main(String[] args) {
       // Define the file path
       String filePath = "src/input.txt"; // Update this with your file path
       String line="";

       // Initialize a Scanner to read from the file
       Scanner scanner = null;
       
       try {
           // Create a File object representing the text file
           File file = new File(filePath);

           // Initialize the Scanner with the File object
           scanner = new Scanner(file);

           // Read and output each line from the file
           while (scanner.hasNextLine()) {
               line = scanner.nextLine();
               System.out.println(line);
           }
       } catch (FileNotFoundException e) {
           // Handle file not found exception
           System.err.println("File not found: " + e.getMessage());
       } finally {
           // Close the scanner if it has been initialized
           if (scanner != null) {
               scanner.close();
           }
       }
       
       String num1=line.substring(0,2);
       String sign=line.substring(2,3);
       String num2 = line.substring(3,5);
       int res=0;
       switch(sign) {
       case "+" : res= Integer.parseInt(num1) +Integer.parseInt(num2);
       case "-" : res =Integer.parseInt(num1)-Integer.parseInt(num2);
       }
      
       System.out.println(res);
   }
}
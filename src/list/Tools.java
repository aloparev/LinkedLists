package list;

import data.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andrej Loparev 557966
 * Methods for input validation (int & string) and element-construct
 *
 */
public class Tools {
	
	public static int intCheck (int lowerBound, int upperBound) {
		if (lowerBound == 0 && upperBound == 0) {
			lowerBound = -2147483648;
			upperBound = 2147483647;
		}
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = 0;
        String in;
        boolean loop;
        
        do {                    
            try {
                loop = false;
                in = br.readLine();
                temp = Integer.parseInt(in);                
                
				if (temp < lowerBound) {
                    System.out.printf("Only numbers between %d and %d are allowed!\n", lowerBound, upperBound);
                    loop = true;
                }                
                if (temp > upperBound) {
                	System.out.printf("Only numbers between %d and %d are allowed!\n", lowerBound, upperBound);
                    loop = true;
                }
            }
            
            catch (NumberFormatException nfe) {
                System.out.println("Please enter a number!");
                loop = true;
            }            
            catch (IOException ioe) {
                loop = true;
                System.out.println("Input error!");
            }
            
        } while (loop);        
        return temp;
    }
    
    public static String stringCheck() {
    	Pattern pt = Pattern.compile("[a-zA-Z\\-\\']+");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        boolean loop;
        
        do {                    
            try {
                loop = false;
                in = br.readLine();
                Matcher m = pt.matcher(in);
				if (!m.matches() || in.length() < 2) {
                	loop = true;
                	System.out.println("Input format error!\nTry again:");
                }
            }          
            catch (IOException ioe) {
                loop = true;
                System.out.println("Input error!");
            }
            
        } while (loop);    	
    	return in;
    }
    
    public static Student composeStudent(){
    	System.out.print("\nType the prename: ");
    	String pn = stringCheck();
    	System.out.print("Type the surname: ");
    	String sn = stringCheck();
    	System.out.print("Type the matriculation number: ");
    	int nr = intCheck(0, 1000000);
    	System.out.print("Choose the course: ");
    	CourseList c = CourseList.select();
    	System.out.println("\nNew student entry has been created successfully!");
    	return new Student(pn, sn, nr, c);
    }
}

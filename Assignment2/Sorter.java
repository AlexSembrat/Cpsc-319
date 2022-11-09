import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;  

public class Sorter {

	public FileWriter fw;
	public PrintWriter pw;
	
	public void validArray(String[] array) {
		
		boolean valid = false;
		
		for(int i = 0; i<array.length; i++) {
			
			if(array[i].equals("Do") || array[i].equals("Re") || array[i].equals("Mi") || array[i].equals("&") || array[i].equals("@") || array[i].equals("%") || array[i].equals("Asymbolwithareallylongname") || array[i].equals("$") || array[i].equals("Fa") || array[i].equals("One") || array[i].equals("Two") || array[i].equals("Three") || array[i].matches("\\d+")) {
	
				if(array[i].length()>1){
					if((array[i].charAt(0) == '0') && (array[i].charAt(1) >= '0') && (array[i].charAt(1) <= '9')) {
						valid = false;
					}
					else {
						valid = true;
					}
				}
				else {
					valid = true;
				}
			}
			else {
				valid = false;
			}
			
			if(valid == false) {
				//System.out.println("Input error 2.");
				this.pw.println("Input error.");
				this.pw.close();
				System.exit(0);
			}
		}
	}
	
	public String[] sort(String[] array) {
		
		boolean b = false;
		String[] temp;
		
		for(int i = 0; i<array.length; i++) {
			if(array[i].equals("666")) {
				b = true;
			}
		}
		
		if(b==true) {
			//ascending order
			String[] array1 = this.remove666(array);
			
			temp = this.ascending(array1);
		}
		else {
			temp = this.descending(array);
		}

		return temp;
	}
	
	public String[] ascending(String[] array) {
		
		double[] temp = this.encode(array);					//used to be int
		
		double replace;										//used to be double
		
		for (int i = 0; i < temp.length; i++) 
        {
            for (int j = i + 1; j < temp.length; j++) { 
                if (temp[i] > temp[j]) 
                {
                    replace = temp[i];
                    temp[i] = temp[j];
                    temp[j] = replace;
                }
            }
        }
		
		return this.decode(temp);
		
	}
	
	public String[] descending(String[] array) {
		
		double[] temp = this.encode(array);					//used to be int
		
		double replace;										//used to be double
		
		for (int i = 0; i < temp.length; i++) 
        {
            for (int j = i + 1; j < temp.length; j++) { 
                if (temp[i] < temp[j]) 
                {
                    replace = temp[i];
                    temp[i] = temp[j];
                    temp[j] = replace;
                }
            }
        }
		
		return this.decode(temp);
		
	}
	
	public String[] remove666(String[] array) {											//if multiple 666 are inputted in a row it breaks
		
		int count = 0;
		
		for(int i = 0; i<array.length; i++) {
			if(array[i].equals("666")) {
				if(count == 0) {
					array[i] = "@";
				}
				else {
					array[i] = null;
				}
				count++;
			}
		}
		
		String[] temp = new String[array.length-count+1];
		int j =0;
		for( int i = 0; i<array.length; i++) {
			if(array[i]!=null) {
				temp[j] = array[i];
				j++;
			}
		}
		

		return temp;
		
	}
	
	public double[] encode(String[] array) {							//used to return double array
		
		double[] temp = new double[array.length];						//used to be int array
		
		for(int i = 0; i<array.length; i++) {
			
			if(array[i].matches("\\d+")) {
				temp[i] = Integer.parseInt(array[i]);				//used to multiply by 10
			}
			else if(array[i].equals("Do")) {
				temp[i] = 0.5;
			}
			else if(array[i].equals("Re")) {
				temp[i] = 100.5;
			}
			else if(array[i].equals("Mi")) {
				temp[i] = 1000.5;
			}
			else if(array[i].equals("&")) {
				temp[i] = 3.5;
			}
			else if(array[i].equals("@")) {
				temp[i] = 3.4;
			}
			else if(array[i].equals("%")) {
				temp[i] = 1005000.5;
			}
			else if(array[i].equals("Asymbolwithareallylongname")) {
				temp[i] = 55.5;
			}
			else if(array[i].equals("$")) {
				temp[i] = 20.5;
			}
			else if(array[i].equals("Fa")) {
				temp[i] = 15.5;
			}
			else if(array[i].equals("One")) {
				temp[i] = 103.5;
			}
			else if(array[i].equals("Two")) {
				temp[i] = 103.6;
			}
			else if(array[i].equals("Three")) {
				temp[i] = 103.7;
			}

		}
		
		return temp;
	}
	
	public String[] decode(double[] array) {
		
		String[] temp = new String[array.length];
		
		for(int i = 0; i<array.length; i++) {
				
			if(array[i]>0 && array[i]<1) {
				temp[i] = "Do";
			}
			else if(array[i]>100 && array[i]<101) {
				temp[i] = "Re";
			}
			else if(array[i]>1000 && array[i]<1001) {
				temp[i] = "Mi";
			}
			else if(array[i]>3.45 && array[i]<4) {			//maybe just >3.4 but doubles are finiky
				temp[i] = "&";
			}
			else if(array[i]>3 && array[i]<3.45) {			//maybe just >3.5 but doubles are finiky
				temp[i] = "@";
			}
			else if(array[i]>1005000 && array[i]<1005001) {
				temp[i] = "%";
			}
			else if(array[i]>55 && array[i]<56) {
				temp[i] = "Asymbolwithareallylongname";
			}
			else if(array[i]>20 && array[i]<21) {
				temp[i] = "$";
			}
			else if(array[i]>15 && array[i]<16) {
				temp[i] = "Fa";
			}
			else if(array[i]>103 && array[i]<103.55) { 		//maybe just >.5 but doubles are finiky
				temp[i] = "One";
			}
			else if(array[i]>103.55 && array[i]<103.65) { 		//maybe just >.6 but doubles are finiky
				temp[i] = "Two";
			}
			else if(array[i]>103.65 && array[i]<104) {		//maybe just >.7 but doubles are finiky
				temp[i] = "Three";
			}	
			else if(array[i] >= 0){
				int place = (int)array[i];
				temp[i] = String.valueOf(place);			//removed /10
			}
		}
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		
		Sorter sort = new Sorter();
		
		File input =  new File(args[0]);
		//input.createNewFile();
	    
	    int count = 0;
	    Scanner scan = new Scanner(input);    
		while(scan.hasNextLine()) {
			 count++;
			 scan.nextLine();
		}
		scan.close();
	    
		//System.out.println("Count is: "+ count);
	    
		String[] array = new String[count];
		
		input = new File(args[0]);
		
		File output = new File(args[1]);
		output.createNewFile();
		
		sort.fw = new FileWriter(output);
		sort.pw = new PrintWriter(sort.fw);
		
		Scanner scnr = new Scanner(input);    
		int i = 0;
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
				
			array[i] = line;
			
			if(array[i].isEmpty()) {
				//System.out.println("Input error 1.");
				sort.pw.println("Input error.");
				sort.pw.close();
				System.exit(0);
			}
			
			i++;
		}
		scnr.close();
		
/*		System.out.println("Current Data:");
		for(int j = 0; j<array.length; j++) {		//big printer 
			System.out.println(array[j]);
		}
		System.out.println();
*/
		sort.validArray(array);
		String[] array1 = sort.sort(array);
		
		
		//System.out.println("Sorted Data:");
		for( int a  = 0; a<array1.length; a++) {
			//System.out.println(array1[a]);
			sort.pw.println(array1[a]);
		}
		//System.out.println();
		
		
		sort.pw.close();	
	}
}

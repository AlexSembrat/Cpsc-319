import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TheStack {

	private int top = -1;
	
	private int[] stack = new int[1000000];
	
	public FileWriter fw;
	public PrintWriter pw;
	
	
	public TheStack() {
		for(int i = 0; i<stack.length; i++) {
			stack[i] = -1;
		}
	}
	
	public void push(int x) {
		
		if(x>=0) {
			if(x==0 && top<0) {
				top++;
				stack[top] = x; 
				return;
			}
			if(x==0 && top>=0) {
				return;
			}
			if(x==666) {
				top++;
				stack[top] = x; 
				top++;
				stack[top] = x; 
				top++;
				stack[top] = x; 
				return;
			}
			if(x==3) {
				top++;
				stack[top] = 7; 
				return;
			}
			if(x==13) {
				//pop everything
				while(top!=-1) {
					this.pop();
				}
				top++;
				stack[top] = x; 
				return;
			}
			else {
				top++;
				stack[top] = x; 
			}
		}
		else {
			pw.println("Imput error.");	// Forces closes if not a natural number
			pw.close();
			System.exit(0);
			
		}
		
	}
	
	public void pop() {
		
		if(top>=0) {
			if(stack[top]==666) {
				pw.println(stack[top]);
				top--;
				if(top>=0) {
					top--;
				}
				return;
			}
			if(stack[top]==7) {
				pw.println(stack[top]);
				return;
			}
			if(stack[top]==42) {
				pw.println(stack[top]);
				//remove all elements from da stack
				top = -1;
				return;
			}
			else {
			
			pw.println(stack[top]);
			top--;
			}
		}
		else {
			pw.println("Error");	// Forces closes if you try to pop an empty stack
			pw.close();
			
			System.exit(0);
		}
		
	}
	
	public void top() {
		if(top>=0) {
			if(stack[top]==666) {
		
				pw.println(999);
				return;
			}
			if(stack[top]==7) {
				top--;
				return;
			}
			if(stack[top]==319){
			
				pw.println(666);
				return;
			}
			else {
			
			pw.println(stack[top]);
			}
		}
		else {
			pw.println("null");	// Prints null if stack is empty
			
		}
	}
		
	
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException {
		
		TheStack stacker = new TheStack();
		String[] commands = new String[1000000];
		
		File input =  new File(args[0]);
		input.createNewFile();
		
		File output = new File(args[1]);
		output.createNewFile();
		
		stacker.fw = new FileWriter(output);
		stacker.pw = new PrintWriter(stacker.fw);
		
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(input);    
		int i = 0;
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
		
			if(line.startsWith(" ")==true) {
				System.out.println("Blank Line");
				stacker.pw.println("Input error.");
				stacker.pw.close();
				System.exit(0);
			}
			commands[i] = line;
			i++;
		}
		
		
		char[] temp;
		
		boolean check = true;
		for( i = 0; commands[i]!=null; i++) {
			check = true;
			
			if(commands[i].equals("top()")) {
				stacker.top();
				continue;
			}
			else if(commands[i].equals("pop()")) {
				
				stacker.pop();
				continue;
			}
			else{
				
				temp = commands[i].toCharArray();
				
				if(temp.length>=6) {
					if(temp[5]==')') {
						stacker.pw.println("Input error.");
						stacker.pw.close();
						System.exit(0);
					}
				}
				else {
					
					stacker.pw.println("Input error.");
					stacker.pw.close();
					System.exit(0);
				}
				
				if(temp[0]=='p' && temp[1]=='u' && temp[2]=='s' && temp[3]=='h' && temp[4]=='(' && temp[temp.length-1]==')') {
					
					for(int j = 5; j<temp.length-1; j++) {
						if((temp[j]!='0') && (temp[j]!='1') && (temp[j]!='2') && (temp[j]!='3') && (temp[j]!='4') && (temp[j]!='5') && (temp[j]!='6') && (temp[j]!='7') && (temp[j]!='8') && (temp[j]!='9')) {
							check = false;
							
						}
					}
					
					if(check==true) {
					
						int result = 0;
						int digit;
						for(int j = 5; j<temp.length-1; j++) {
							digit = temp[j] - '0';
							result = result*10 + digit;
						}
					
						stacker.push(result);
						
					}
					else {
					
						stacker.pw.println("Imput error.");
						stacker.pw.close();
						System.exit(0);
					}
					
				}
				else {
					
					stacker.pw.println("Input error.");
					stacker.pw.close();
					System.exit(0);
				}
				
			}
			
		}
		
		stacker.pw.close();	
		
	}
}

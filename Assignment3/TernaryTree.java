import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 

public class TernaryTree {
	
	public FileWriter fw;
	public PrintWriter pw;
	
	private String[] tree = new String[7200000];
	
	
	public TernaryTree() {
		tree[0] = "root";
	}
	//private Node root = new Node("root");
	
	
	public void AddL(String a, String b) {
		//System.out.println("AddL Called a and b are: " + a + " " + b);
		
		int index = this.index(a);
		
		if(a.equals("root")) {
			if(b.charAt(0)=='$') {
				b = b.substring(1);
				tree[1] = b;
				//System.out.println("In dollariedo");
			}
			else if(tree[1]==null) {
				tree[1] = b;
			}
			else {
				this.pw.println("Add operation not possible.");
				//System.out.println("Add operation not possible");
			}
		}
		else if(index==-1) {
			
			return;
		}
		else {
			
			int level = this.findLevel(index);
			
			int temp = level - 1;
			int number = index;
			
			while(temp>=0) {
				//System.out.println("B: Current Level is " + temp + " Current number is " + number);
				number = number - pow(3,temp);
				temp--;
				//System.out.println("A: Current Level is " + temp + " Current number is " + number);
			}
			
			int newIndex = index + pow(3,level) + 2*number;
			
			if(b.charAt(0)=='$') {
				b = b.substring(1);
				tree[newIndex] = b;
			}
			else if(tree[newIndex]==null) {
				tree[newIndex] = b;
			}
			else {
				this.pw.println("Add operation not possible.");
				//System.out.println("Add operation not possible");
			}
		}
		
	}
	
	public void AddM(String a, String b) {
		//System.out.println("AddM Called a and b are: " + a + " " + b);
		
		int index = this.index(a);
		
		if(a.equals("root")) {
			if(b.charAt(0)=='$') {
				b = b.substring(1);
				tree[2] = b;
				//System.out.println("In dollariedo");
			}
			else if(tree[2]==null) {
				tree[2] = b;
			}
			else {
				this.pw.println("Add operation not possible.");
				//System.out.println("Add operation not possible");
			}
		}
		else if(index==-1) {
			
			return;
		}
		else {
			
			int level = this.findLevel(index);
			
			int temp = level - 1;
			int number = index;
			
			while(temp>=0) {
				number = number - pow(3,temp);
				temp--;
			}
			
			int newIndex = index + pow(3,level) + 2*number + 1;
			
			if(b.charAt(0)=='$') {
				b = b.substring(1);
				tree[newIndex] = b;
			}
			else if(tree[newIndex]==null) {
				tree[newIndex] = b;
			}
			else {
				this.pw.println("Add operation not possible.");
				//System.out.println("Add operation not possible");
			}
		}
		
	}

	public void AddR(String a, String b) {
		//System.out.println("AddR Called a and b are: " + a + " " + b);
		
		int index = this.index(a);
		
		if(a.equals("root")) {
			if(b.charAt(0)=='$') {
				b = b.substring(1);
				tree[3] = b;
				//System.out.println("In dollariedo");
			}
			else if(tree[3]==null) {
				tree[3] = b;
			}
			else {
				this.pw.println("Add operation not possible.");
				//System.out.println("Add operation not possible");
			}
		}
		else if(index==-1) {
			
			return;
		}
		else {
			
			int level = this.findLevel(index);
			
			int temp = level - 1;
			int number = index;
			
			while(temp>=0) {
				number = number - pow(3,temp);
				temp--;
			}
			
			int newIndex = index + pow(3,level) + 2*number + 2;
			//System.out.println("char at 0 is" + b.charAt(0));
			if(b.charAt(0)=='$') {
				b = b.substring(1);
				tree[newIndex] = b;
				//System.out.println("In dollariedo");
			}
			else if(tree[newIndex]==null) {
				tree[newIndex] = b;
			}
			else {
				this.pw.println("Add operation not possible.");
				//System.out.println("Add operation not possible");
			}
		}
		
	}
	
	public void DelL(String a) {
		//System.out.println("DelL Called a is: " + a);
		
		int mostRight = this.index(a);
		if(mostRight==-1) {
			return;
		}
		int mostLeft = this.mostLeft(mostRight, a);
		if(mostLeft==-1) {
			return;
		}
		else{
			
			int level = this.findLevel(mostLeft);
			
			int temp = level - 1;
			int number = mostLeft;
			
			while(temp>=0) {
				//System.out.println("B: Current Level is " + temp + " Current number is " + number);
				number = number - pow(3,temp);
				temp--;
				//System.out.println("A: Current Level is " + temp + " Current number is " + number);
			}
			
			int newIndex = mostLeft + pow(3,level) + 2*number;
					
			if(tree[newIndex]==null) {
				return;
			}
			else {
				tree[newIndex] = null;
			}
			
			int nextLeft = newIndex;
			
			for(int i = newIndex; i<tree.length; i++) {
				nextLeft = this.nextL(nextLeft);
				if(nextLeft>=tree.length) {
					return;
				}
				tree[nextLeft] = null;
				
				int mumbojumbo = this.findLevel(nextLeft) - 1;
				mumbojumbo = pow(3,mumbojumbo) + nextLeft;
				
				for(int j = nextLeft; j<mumbojumbo; j++) {
					if(j<tree.length) {
					tree[j] = null;
					}
					else {
						return;
					}
				}
			}
			
		}
		
	}
	
	public void DelM(String a) {
		//System.out.println("DelM Called a is: " + a);
		
		int mostRight = this.index(a);
		if(mostRight==-1) {
			return;
		}
		int mostLeft = this.mostLeft(mostRight, a);
		if(mostLeft==-1) {
			return;
		}
		else{
			
			int level = this.findLevel(mostLeft);
			
			int temp = level - 1;
			int number = mostLeft;
			
			while(temp>=0) {
				//System.out.println("B: Current Level is " + temp + " Current number is " + number);
				number = number - pow(3,temp);
				temp--;
				//System.out.println("A: Current Level is " + temp + " Current number is " + number);
			}
			
			int newIndex = mostLeft + pow(3,level) + 2*number + 1;
			
			if(tree[newIndex]==null) {
				return;
			}
			else {
				tree[newIndex] = null;
			}
			
			int nextLeft = newIndex;
			
			for(int i = newIndex; i<tree.length; i++) {
				nextLeft = this.nextL(nextLeft);
				if(nextLeft>=tree.length) {
					return;
				}
				tree[nextLeft] = null;
				
				int mumbojumbo = this.findLevel(nextLeft) - 1;
				mumbojumbo = pow(3,mumbojumbo) + nextLeft;
				
				for(int j = nextLeft; j<mumbojumbo; j++) {
					if(j<tree.length) {
						tree[j] = null;
						}
						else {
							return;
						}
				}
			}
			
		
			
		}
	}

	public void DelR(String a) {
		//System.out.println("DelR Called a is: " + a);
		
		int mostRight = this.index(a);
		if(mostRight==-1) {
			return;
		}
		int mostLeft = this.mostLeft(mostRight, a);
		//System.out.println("here" + mostLeft);
		if(mostLeft==-1) {
			return;
		}
		else{
			
			int level = this.findLevel(mostLeft);
			
			int temp = level - 1;
			int number = mostLeft;
			
			while(temp>=0) {
				//System.out.println("B: Current Level is " + temp + " Current number is " + number);
				number = number - pow(3,temp);
				temp--;
				//System.out.println("A: Current Level is " + temp + " Current number is " + number);
			}
			
			int newIndex = mostLeft + pow(3,level) + 2*number + 2;
			//System.out.println("here" + newIndex);
			if(tree[newIndex]==null) {
				return;
			}
			else {
				tree[newIndex] = null;
				//System.out.println("here" + newIndex);
			}
			
			int nextLeft = newIndex;
			
			for(int i = newIndex; i<tree.length; i++) {
				nextLeft = this.nextL(nextLeft);
				if(nextLeft>=tree.length) {
					return;
				}
				tree[nextLeft] = null;
				
				int mumbojumbo = this.findLevel(nextLeft) - 1;
				mumbojumbo = pow(3,mumbojumbo) + nextLeft;
				
				for(int j = nextLeft; j<mumbojumbo; j++) {
					if(j<tree.length) {
						tree[j] = null;
						}
						else {
							return;
						}
				}
			}
			
		
			
		}
	}
	
	public void Exchange(String a, String b) {
		//System.out.println("Exchange Called a and b are: " + a + " " + b);
		
		if(b.charAt(0)=='$') {
			b = b.substring(1);
			b = a.concat(b);
		}
		
		
		for(int i = 0; i<tree.length; i++) {
			if(tree[i]==null) {
				
			}
			else if(tree[i].equals(a)) {
				tree[i] = b;
			}
		}
	}
	
	public void Print() {
		//System.out.println("Print Called");
		//System.out.println();
		
		
		
		int newline = 1;
		int counter = 1;
		int biggestIndex = 0;
		for(int i = 0; i<tree.length; i++) {
			
			if(i==newline) {
				newline = newline + pow(3,counter);
				counter++;
				if(this.restNull(i)==false) {
					//System.out.println();  //obviously add the output to the file here, check if the rest of the array is null, if the rest is null break loop
					this.pw.println();
				}
				if(this.restNull(i)==true) {
					break;
				}
			}
			
			if(tree[i]!=null) {
				biggestIndex = i;
				//System.out.print(tree[i]); //obviously add the output to the file here
				this.pw.print(tree[i]);
			}
			
			if(i+1<tree.length) {
				if(nullLevel(i,newline) == false && (i+1!=newline) && tree[i]!=null) { //tree[i+1]!=null //nullLevel(i,newline) == false
					//System.out.print(" ; "); //obviously add the output to the file here
					this.pw.print(" ; ");
				}
			}
		}
		
		//System.out.println();
		//System.out.println();
		//for(int i = 0; i<biggestIndex+1; i++) {
		//	System.out.println("["+i+"] = "+tree[i]);
		//}
		
		//if(thing!=0) {
			this.pw.println();
		//}
		
	}
	
	public int index(String find) {
		
		int index = -1;
		//int i = 0;
		for(int i = 0; i<tree.length; i++) {
			
			if(tree[i]==null) {
				
			}
			else if(tree[i].equals(find)) {
				index = i;
			}
		}
		//System.out.println("This is index given the string " + find + ": "+ index);
		return index;
	}
	
	public int findLevel(int index) {
		
		int level = 0;
		
		while(index>0) {
			index = index - pow(3,level); //3^level
			if(index>0) {
				level++;
			}
		}
		
		return level;
		
	}
	
	public boolean restNull(int index) {
		
		for(int i = index; i<tree.length; i++) {
			if(tree[i]!=null) {
				return false;
			}
		}
		
		return true;
	}
	
	public int pow(int base, int exponent) {
		
		int result = 1;
		
		while(exponent!=0) {
			result *= base;
			exponent--;
		}
		
		return result;
	}
	
	public boolean nullLevel(int index, int newline) {
		
		if(newline<=tree.length) {
		for(int i = index+1; i<newline; i++) {
			if(tree[i]!=null) {
				return false;
			}
		}
		}
		return true;
	}
	
	public int mostLeft(int index, String a) {
		//System.out.println("This is index: " + index);
		int level = this.findLevel(index) - 1;
		int start = 0;
		//System.out.println("This is level: " + level);
		while(level>=0) {
			start = start + pow(3,level);
			level--;
		}
		//System.out.println("This is start: " + start);
		for(int i = start; i<tree.length; i++) {
			if(tree[i]==null) {
				
			}
			else if(tree[i].equals(a)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	public int nextL(int index) {
		
		int level = this.findLevel(index);
		
		int temp = level - 1;
		int number = index;
		
		while(temp>=0) {
			number = number - pow(3,temp);
			temp--;
		}
		
		int newIndex = index + pow(3,level) + 2*number;
		return newIndex;

	}
	
/*	public boolean nextM(int index) {
		
		int level = this.findLevel(index);
		
		int temp = level - 1;
		int number = index;
		
		while(temp>=0) {
			number = number - pow(3,temp);
			temp--;
		}
		
		int newIndex = index + pow(3,level) + 2*number + 1;
		
		if(tree[newIndex]!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean nextR(int index) {
		
		int level = this.findLevel(index);
		
		int temp = level - 1;
		int number = index;
		
		while(temp>=0) {
			number = number - pow(3,temp);
			temp--;
		}
		
		int newIndex = index + pow(3,level) + 2*number + 2;
		
		if(tree[newIndex]!=null) {
			return true;
		}
		else {
			return false;
		}
	}
*/	
	public static void main(String[] args) throws IOException {
		
		String[] array = new String[10000];
		
		TernaryTree tree = new TernaryTree();
		
		File input = new File(args[0]);
		
		File output = new File(args[1]);
		output.createNewFile();
		
		tree.fw = new FileWriter(output);
		tree.pw = new PrintWriter(tree.fw);
		
		Scanner scnr = new Scanner(input);    
		int i = 0;
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
				
			array[i] = line;
			
			if(array[i].isEmpty()) {
				//System.out.println("Input error 1.");
				tree.pw.println("Input error.");
				tree.pw.close();
				System.exit(0);
			}
			
			i++;
		}
		scnr.close();
		
		for(int j = 0; array[j]!=null; j++) {
			//System.out.println("["+j+"] = "+array[j]);
			
			if(array[j].contains(" ")) {
				//System.out.println("Input error.");
				tree.pw.println("Input error.");
				tree.pw.close();
				System.exit(0);
			}
			
			if(array[j].equals("Print()")) {
				tree.Print();
			}
			else if(array[j].startsWith("AddL(") && array[j].endsWith(")") && array[j].equals("AddL()")==false) {
				
				if(array[j].contains(",")==false) {
					//System.out.println("Input error.");
					tree.pw.println("Input error.");
					tree.pw.close();
					System.exit(0);
				}
				
				StringBuilder buildA = new StringBuilder(array[j].length());
				StringBuilder buildB = new StringBuilder(array[j].length());
			
				int comma = array[j].indexOf(',');
				while(array[j].charAt(comma+1) == ',') {
					comma++;
				}
				
				for(int k = 5; k<comma; k++) {
					buildA = buildA.append(array[j].charAt(k));
				}
				
				for(int k = comma+1; k<array[j].length()-1; k++) {
					buildB = buildB.append(array[j].charAt(k));
				}
				
				String a = buildA.toString();
				String b = buildB.toString();
				
				tree.AddL(a, b);
			}
			else if(array[j].startsWith("AddM(") && array[j].endsWith(")") && array[j].equals("AddM()")==false) {
				
				if(array[j].contains(",")==false) {
					//System.out.println("Input error.");
					tree.pw.println("Input error.");
					tree.pw.close();
					System.exit(0);
				}
				
				
				StringBuilder buildA = new StringBuilder(array[j].length());
				StringBuilder buildB = new StringBuilder(array[j].length());
				
				int comma = array[j].indexOf(',');
				while(array[j].charAt(comma+1) == ',') {
					comma++;
				}
				
				for(int k = 5; k<comma; k++) {
					buildA = buildA.append(array[j].charAt(k));
				}
				
				for(int k = comma+1; k<array[j].length()-1; k++) {
					buildB = buildB.append(array[j].charAt(k));
				}
				
				String a = buildA.toString();
				String b = buildB.toString();
				
				tree.AddM(a, b);
			}
			else if(array[j].startsWith("AddR(") && array[j].endsWith(")") && array[j].equals("AddR()")==false) {
				
				if(array[j].contains(",")==false) {
					//System.out.println("Input error.");
					tree.pw.println("Input error.");
					tree.pw.close();
					System.exit(0);
				}
				
				
				StringBuilder buildA = new StringBuilder(array[j].length());
				StringBuilder buildB = new StringBuilder(array[j].length());
				
				int comma = array[j].indexOf(',');
				while(array[j].charAt(comma+1) == ',') {
					comma++;
				}
				
				for(int k = 5; k<comma; k++) {
					buildA = buildA.append(array[j].charAt(k));
				}
				
				for(int k = comma+1; k<array[j].length()-1; k++) {
					buildB = buildB.append(array[j].charAt(k));
				}
				
				String a = buildA.toString();
				String b = buildB.toString();
				
				tree.AddR(a, b);
			}
			else if(array[j].startsWith("DelL(") && array[j].endsWith(")") && array[j].equals("DelL()")==false) {
				
				StringBuilder buf = new StringBuilder(array[j].length());
				for(int k = 5; k<array[j].length()-1; k++) {
					buf = buf.append(array[j].charAt(k));
				}
				
				String a = buf.toString();
				
				tree.DelL(a);
			}
			else if(array[j].startsWith("DelM(") && array[j].endsWith(")") && array[j].equals("DelM()")==false) {
				
				StringBuilder buf = new StringBuilder(array[j].length());
				for(int k = 5; k<array[j].length()-1; k++) {
					buf = buf.append(array[j].charAt(k));
				}
				
				String a = buf.toString();
				
				tree.DelM(a);
			}
			else if(array[j].startsWith("DelR(") && array[j].endsWith(")") && array[j].equals("DelR()")==false ) {
				
				StringBuilder buf = new StringBuilder(array[j].length());
				for(int k = 5; k<array[j].length()-1; k++) {
					buf = buf.append(array[j].charAt(k));
				}
				
				String a = buf.toString();
				
				tree.DelR(a);
			}
			else if(array[j].startsWith("Exchange(") && array[j].endsWith(")") && array[j].equals("Exchange()")==false) {
				
				if(array[j].contains(",")==false) {
					//System.out.println("Input error.");
					tree.pw.println("Input error.");
					tree.pw.close();
					System.exit(0);
				}
				
				
				StringBuilder buildA = new StringBuilder(array[j].length());
				StringBuilder buildB = new StringBuilder(array[j].length());
				
				int comma = array[j].indexOf(',');
				while(array[j].charAt(comma+1) == ',') {
					comma++;
				}
				
				for(int k = 9; k<comma; k++) {
					buildA = buildA.append(array[j].charAt(k));
				}
				
				for(int k = comma+1; k<array[j].length()-1; k++) {
					buildB = buildB.append(array[j].charAt(k));
				}
				
				String a = buildA.toString();
				String b = buildB.toString();
				
				tree.Exchange(a, b);
			}
			else {
				//System.out.println("Input error.");
				//tree.pw.println();
				tree.pw.println("Input error.");
				tree.pw.close();
				System.exit(0);
			}
		}
		tree.pw.close();
	}

}

class Node{
	
	String payload;
	Node left = null;
	Node middle = null;
	Node right = null;
	
	public Node(String payload) {
		this.payload = payload;
	}
	
}
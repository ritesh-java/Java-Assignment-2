package packageone;

public class StringPractice{
	void countCharacters(String str){
		String nospace = str.replaceAll("\\s","");
		String[] strarr = nospace.split("");
        String unique = "" + nospace.charAt(0);
        String singleletter = "";
        for(int i =1;i<strarr.length;i++){ //Loop to separate unique characters
			String temp = ""+nospace.charAt(i); 
			if(!unique.contains(temp)){
				unique = unique + temp;
			}
		}
		
		String[] uniquearr = unique.split(""); //Unique character array	
		for(int i =0;i<uniquearr.length;i++){
			int count = 0;
			for(int j =0;j<strarr.length;j++){
				if(uniquearr[i].equals(strarr[j])){
					count++;
				}
			}
			
			if(count==1){
				singleletter = singleletter + uniquearr[i];
			}
			
			System.out.println(uniquearr[i]+" count is "+count);
		}
		
		System.out.println();
		System.out.print("10.) Letters with are not repeated are :");
		for(int i =0;i<singleletter.length();i++){
			System.out.print(" "+singleletter.charAt(i));
		}
		
	}
	
	public static void main(String args[]){
		StringPractice t = new StringPractice();
		String s = "This is a java class";
		String len = s.replaceAll("\\s", "");
		System.out.println("\"This is a java class\" is our string!!");
		System.out.println();
		System.out.println("1.) Number of words in the string are: "+len.length());
		System.out.println("2.) String's length is: "+s.length());
		
		String[] words = s.split(" ");
        int countsingle = 0;
        
        for(int i =0;i<words.length;i++){	
        	if(words[i].length()==1)
        		countsingle++;	
        }
        
        System.out.println("3.) Single character words count in the string is "+countsingle);
        
        String[] reverse = new String[words.length];
        System.out.print("4.) Reverse each word of the string is: ");
        for(int i =0;i<words.length;i++){
        	reverse[i]="";
        	for(int j=0;j<words[i].length();j++){
        		reverse[i] = reverse[i] + words[i].charAt(words[i].length()-1-j);
        	}
        	
        	System.out.print(reverse[i]+" ");
        }
		System.out.println();
        System.out.print("5.) Reverse of the entire string is: ");
        String reversestr="";
        
        for(int i =0;i<s.length();i++)
        	reversestr = reversestr + s.charAt(s.length()-i-1);
        
        System.out.print(reversestr);
        System.out.println();
        String replacejava = s.replace("java", "SQL");
        System.out.println("6.) Final string after replacing java with SQL: "+replacejava);
        
        System.out.println("7.) Letter at the center of the string is: "+s.charAt(s.length()/2));
        System.out.println("8.) Index of letter \"j\" is: "+s.indexOf("j"));
        System.out.println("9.) Count of unique characters is as follows: ");
        t.countCharacters(s);
        System.out.println();
        System.out.println("11.) Index of each word in the string is as follows: ");
        for(int i =0;i<words.length;i++){
        	String word = words[i];
        	System.out.println(word+" : "+s.indexOf(word));
        }
        System.out.println();
        System.out.println("12.) Whole string to upper case is: "+s.toUpperCase());
        
	}
}



/*
Output Result:
"This is a java class" is our string!!

1.) Number of words in the string are: 16
2.) String's length is: 20
3.) Single character words count in the string is 1
4.) Reverse each word of the string is: sihT si a avaj ssalc 
5.) Reverse of the entire string is: ssalc avaj a si sihT
6.) Final string after replacing java with SQL: This is a SQL class
7.) Letter at the center of the string is: j
8.) Index of letter "j" is: 10
9.) Count of unique characters is as follows: 
T count is 1
h count is 1
i count is 2
s count is 4
a count is 4
j count is 1
v count is 1
c count is 1
l count is 1

10.) Letters with are not repeated are : T h j v c l
11.) Index of each word in the string is as follows: 
This : 0
is : 2
a : 8
java : 10
class : 15

12.) Whole string to upper case is: THIS IS A JAVA CLASS
*/
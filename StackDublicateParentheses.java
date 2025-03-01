
import java.util.*;
public class StackDublicateParentheses{
    public static boolean isValid(String str)  {
        Stack <Character> s=new Stack<>();

        for(int i=0; i<str.length() ;i++) {
           char ch =str.charAt(i);


           //ignore spaces
           if(ch == ' ') {  continue; }
           
           //  step1 opening
           if(ch == '(' || ch == '{' || ch == '['){
            s.push(ch);
           } else{
            //step2 closing
            if(s.isEmpty()) {
                return false;
            }
            if( (s.peek() == '(' && ch == ')')  //()
            ||(s.peek() == '{' && ch == '}')   //{ }
            ||(s.peek() == '[' && ch == ']') ) {  //[]
              
              s.pop();
            }  else{
                return false;
            }
           }
        }  
  
        //step3 my stack empty
        if(s.isEmpty()) {
            return true;
        }  else {
            return false;
        }
    }
    public static boolean isDublicate(String str ) {
  Stack<Character> s= new Stack<>();
    
    for(int i=0 ; i<str.length(); i++)  {
        char ch = str.charAt(i) ;

        //clasing 
        if(ch == ')') {
            int count = 0;
            while( s.peek() != '(')  {
                 s.pop();
                 count ++;
            }
            if(count < 1) {
                return true;  //dublicate
            }  else {
                s.pop();         //opening pair
            } 
        } 

            else {
                //opening
                s.push(ch);
            }
        }

        return false;
    }
    public static void main(String args[]) {
        String str ="((a+b))"; //true 
        String str2 ="(a-b)";  //false

        System.out.print(isDublicate(str));
    }
}
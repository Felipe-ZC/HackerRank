/*
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Stack;

public class Solution {
    // Start my code
    /*
    * Returns true if bracket1 is the corresponding opening brace
    * for bracket2. So if bracket1 is a '(' bracket2 must be ')'
    * for this function to return true.
    */
    public static boolean corresponds(char bracket1, char bracket2){
        switch (bracket1){
            case '(':
                return bracket2 == ')';
            case '{':
                return bracket2 == '}';
            case '[':
                return bracket2 == ']';
            default:
                return false;
        }
    }
    
    public static boolean isBalanced(String expression) {
        // Init
        Stack<Character> bStack = new Stack<>();
        
        // Iterate through expression
        for(int i = 0; i < expression.length(); ++i){
            char currChar = expression.charAt(i);
            // Push all operning braces onto stack
            if(currChar == '(' || currChar == '{' || currChar == '['){
                bStack.push(currChar);
            }
            /*
            * The character is a closing brace, look for its 
            * corresponding opening brace. Return false if the
            * opening brace is never found.
            */
            if(currChar == ')' || currChar == '}' || currChar == ']'){
                //System.out.println("closing found!");
                boolean openingFound = false;
                while(!bStack.empty()){
                    char tempChar = bStack.pop();
                    //System.out.println("tempChar: " + tempChar);
                    if(corresponds(tempChar,currChar)){
                        openingFound = true;
                        break;
                    }
                }
                // No opening brace found, brackets are unbalanced
                if(!openingFound){
                    //System.out.println("false");
                    return false;
                }
            }
            // Move on to next character
        }
        // Stack should be empty after algorithm completes
        return bStack.empty();
    }
    // End my code
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}

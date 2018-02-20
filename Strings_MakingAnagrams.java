import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.HashMap;

public class Solution {
    
    // Start my code
    
    public static int numberNeeded(String first, String second) {
      // Init
      int answer = 0;
      HashMap<Character, Integer> map = new HashMap<>();
      HashMap<Character, Integer> map2 = new HashMap<>();
        
      // Make a hashmap of the first string
      for(int i = 0; i < first.length(); ++i){
          if(map.containsKey(first.charAt(i))){
              int count = map.get(first.charAt(i));
              count++;
              map.put(first.charAt(i),count);
          }
          else{
              map.put(first.charAt(i),1);
          }
      }
      // Make a hashmap of the second string
      for(int i = 0; i < second.length(); ++i){
          if(map2.containsKey(second.charAt(i))){
              int count = map2.get(second.charAt(i));
              count++;
              map2.put(second.charAt(i),count);
          }
          else{
              map2.put(second.charAt(i),1);
          }
      }
     // Find different characters in both hash maps
     for (Character key : map.keySet()) {
        if(map2.containsKey(key)){
            int val1 = map.get(key);
            int val2 = map2.get(key);
            answer += Math.abs(val1-val2);
        }
        else{
            answer += map.get(key);
        }
     }
    for (Character key : map2.keySet()) {
         if(!map.containsKey(key)){
            answer += map2.get(key);
        }
     }
      return answer;
    }
    // End my code 
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

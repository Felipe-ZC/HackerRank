import java.util.*;

public class Solution {
    HashMap<String,Integer> magazine = new HashMap<>();
    HashMap<String,Integer> note = new HashMap<>();
    
    // Start my code
    // Create a hash map from the given string
    public HashMap<String,Integer> hashifyString(String str){
        HashMap<String,Integer> strMap = new HashMap<>();
        String[] strings = str.split(" ");
        
        for(int i = 0; i < strings.length ; ++i){
            if(strMap.get(strings[i]) == null){
                strMap.put(strings[i],1);
            }
            else{
                int count = strMap.get(strings[i]);
                count++;
                strMap.put(strings[i],count);
            }
        }
        //System.out.println(strMap);
        return strMap;
    }
    
    // Constructor
    public Solution(String magazine, String note) {
        this.magazine = hashifyString(magazine);
        this.note = hashifyString(note);
    }
    
    /*
    * Compare hash maps, if the magazine map contains
    * all the words in the note map then return true. 
    * Otherwise return false.
    */
    public boolean solve() {
        for(String key : note.keySet()){
            // Check for word
            if(!magazine.containsKey(key)){
                return false;
            }
            // Check frequency
            else{
                if(note.get(key) > magazine.get(key)){
                    return false;
                }
            }
            // Proceed to next word in the note string. 
        }
        return true;
    }
    
    // End my code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}

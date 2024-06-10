import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
       
        hs.add("S");
        hs.add("A");
        hs.add("I");
        hs.add("S");
        hs.add("R");
        hs.add("E");
        
    
        System.out.println("Original HashSet: " + hs);        
        
        System.out.println("Size of HashSet: " + hs.size());
        
       
        System.out.println("Removing A from HashSet: " + hs.remove("R"));
       
        if(hs.remove("A")) {
        	System.out.println("A removed from the Set");
        } else {
        	System.out.println("A is not present in the Set");
        }
        
        
        System.out.println("Checking if S is present: " + hs.contains("S"));
        
        System.out.println("Updated HashSet: " + hs);
    }
}
import java.util.HashMap;
import java.util.Map;
/*
 * oneAway checks to see if two strings are either the same or 1 character difference
 */
public class oneAway {


	public static void main(String[] args) { 
		System.out.println(checkString("Hi", "Hi")); // true
		System.out.println(checkString("Hi", "Hii")); // insertion true
		System.out.println(checkString("Hi", "Hiii")); //insertion false
		System.out.println(checkString("ci", "Hi")); // change true
		System.out.println(checkString("Hit", "Rit")); // change true
		System.out.println(checkString("Hit", "Rct")); // change false
		
		
	}
	public static boolean checkString(String s, String y) { 
		//if more than 1 charc diff, return false
		if(Math.abs(s.length() - y.length()) > 1) { 
			return false;
		}
		// assumes theres no difference in length or only 1 char diff
		else  { 
			Map<Character, Integer> m1 = new HashMap<Character,Integer>();
			Map<Character, Integer> m2 = new HashMap<Character, Integer>();
			// counts occurance of all characters in first string
			for(char c : s.toCharArray()) { 
				if(!m1.containsKey(c)) { 
					m1.put(c, 1);
				}
				else { 
					int value = m1.get(c);
					m1.put(c, value + 1);
				}
				
			}
			// counts occurance of all characters in secnod string
			for(char c : y.toCharArray()) { 
				if(!m2.containsKey(c)) { 
					m2.put(c, 1);
				}
				else { 
					int value = m2.get(c);
					m2.put(c, value + 1);
				}
				
			}
			// if a key exists in m1 but not in m2, return false
			// if value of key does is not same in both maps, return false
				int checkKey = 0;
				int checkValue =0;
				for(char c: m1.keySet()) { 
					if(!m2.containsKey(c)) { 
						checkKey++;
					}
					if(m1.get(c) != m2.get(c)) { 
						checkValue++;
						
					}
					// if there's a diff between char 
					if(checkKey == 2 || checkValue == 2) { 
						return false;
					}
				}
			
		
			
		}
		return true;
		
	}
	

}

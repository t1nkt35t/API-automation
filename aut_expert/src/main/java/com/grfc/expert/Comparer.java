package main.java.com.grfc.expert;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Comparer {
	
	public static Set<?> stringToSet (String one) {
		
		Set<String> set = new HashSet<>();
		Scanner scanner = new Scanner(one);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  set.add(line);
		}
		scanner.close();
//		System.out.println(set);
		return set;		
	}
	
	public static boolean equals(Set<?> set1, Set<?> set2) {
		
		if(set1 == null || set2 ==null){
            return false;
        }

        if(set1.size()!=set2.size()){
            return false;
        }
        System.out.println(set1.containsAll(set2));
        return set1.containsAll(set2);
		
	}
}

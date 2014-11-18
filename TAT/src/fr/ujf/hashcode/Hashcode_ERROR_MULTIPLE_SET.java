package fr.ujf.hashcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Hashcode_ERROR_MULTIPLE_SET {

	public static void main (String args[]) {
		
		Set<Collection<String>> s1 = new HashSet<Collection<String>>();
		Set<Collection<String>> s2 = new HashSet<Collection<String>>();
		Set<Collection<String>> s3 = new HashSet<Collection<String>>();
		
		Collection<String> c = new ArrayList<String>();
		
		c.add("ok");
		
		s1.add(c);
		s2.add(c);
		s3.add(c);
		
		s1.remove(c);
		s2.remove(c);
		
		//Add the following line to correct the program: 
		//s3.remove(c);
		
		c.remove("ok");
		
	}
	
}

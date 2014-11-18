package fr.ujf.hashcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Hashcode_OK {

	public static void main (String args[]) {
		
		Set<Collection<String>> s1 = new HashSet<Collection<String>>();
		Set<Collection<String>> s2 = new HashSet<Collection<String>>();
		Set<Collection<String>> s3 = new HashSet<Collection<String>>();
		
		Collection<String> c1 = new ArrayList<String>();
		Collection<String> c2 = new ArrayList<String>();
		Collection<String> c3 = new ArrayList<String>();
		
		c1.add("ok");
		c2.add("ok");
		c3.add("ok");
		
		s1.add(c1);
		s1.add(c2);
			
		s2.add(c2);
		
		s3.add(c1);
		s3.add(c2);
		s3.add(c3);
		
		// c1 in {s1, s3}
		// c2 in {s1, s2, s3}
		// c3 in {s3}
		
		s1.remove(c1);
		s3.remove(c1);
		c1.add("ok2");
		
		s1.remove(c2);
		s2.remove(c2);
		s3.remove(c2);
		c2.remove("ok");
		
		s3.remove(c3);
		c3.add("ok2");
		
	}
	
}

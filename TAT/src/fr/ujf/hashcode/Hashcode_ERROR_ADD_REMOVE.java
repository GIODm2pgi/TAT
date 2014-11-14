package fr.ujf.hashcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Hashcode_ERROR_ADD_REMOVE {

	public static void main (String args[]) {
		Set<Collection<String>> s1 = new HashSet<Collection<String>>();
		Set<Collection<String>> s2 = new HashSet<Collection<String>>();
		
		Collection<String> c1 = new ArrayList<String>();
		Collection<String> c2 = new ArrayList<String>();
		
		c1.add("ok");
		c2.add("ok");
		
		s1.add(c1);
		s2.add(c2);
		
		c1.add("not ok"); //error: c1 is in s1
		c2.remove("ok"); //error: c2 is in s2
	}
}

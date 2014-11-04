package fr.ujf.hashcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashcodeOK {

	public static void main (String args[]) {
		Set<Collection<String>> s = new HashSet<Collection<String>>();
		Collection<String> c = new ArrayList<String>();
		c.add("this is ok");
		s.add(c);
		System.out.println(s.contains(c));
	}
}

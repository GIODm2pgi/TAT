package fr.ujf.hashcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Hashcode_OK_TYPE_DOUBLE {

	public static void main (String args[]) {
		Set<Collection<Double>> s1 = new HashSet<Collection<Double>>();
		Set<Collection<Double>> s2 = new HashSet<Collection<Double>>();
		Set<Collection<Double>> s3 = new HashSet<Collection<Double>>();
		
		Collection<Double> c1 = new ArrayList<Double>();
		Collection<Double> c2 = new ArrayList<Double>();
		Collection<Double> c3 = new ArrayList<Double>();
		
		c1.add(2.0);
		c2.add(1.0);
		c3.add(3.0);
		
		s1.add(c1);
		s1.add(c2);
			
		s2.add(c2);
		
		s3.add(c1);
		s3.add(c2);
		s3.add(c3);
		
		s1.remove(c1);
		s3.remove(c1);
		c1.add(4.0);
		
		s1.remove(c2);
		s2.remove(c2);
		s3.remove(c2);
		c2.remove(5.2);
		
		s3.remove(c3);
		c3.add(6.4);
	}
}

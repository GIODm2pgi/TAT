package fr.ujf.enumeration;

import java.util.Vector;

import fr.ujf.enumeration.resource.Enumeration;

public class Enumeration_ERROR_ADD_REMOVE {

	public static void main (String args[]) {
		
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);
		v.add(2);
		v.add(3);
		
		Enumeration<Integer> en = new Enumeration<Integer>();
		en.create(v);
		
		while(en.hasMoreElements()) {
			Integer i = (Integer) en.nextElement();
			if (i == 2) {
				v.add(4); //error
				v.remove((Integer) 4); //error
			}
		}
		
	}
	
}

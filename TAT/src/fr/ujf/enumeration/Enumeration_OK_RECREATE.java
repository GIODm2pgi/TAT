package fr.ujf.enumeration;

import java.util.Vector;

import fr.ujf.enumeration.resource.Enumeration;

public class Enumeration_OK_RECREATE {
	
	public static void main (String args[]) {
		
		Vector<Integer> v1 = new Vector<Integer>();
		for (int i=0; i<5; i++)
			v1.add(i);

		Vector<Integer> v2 = new Vector<Integer>();
		for (int i=0; i<5; i++)
			v2.add(i);
		
		Enumeration<Integer> en1 = new Enumeration<Integer>();
		en1.create(v1);
		Enumeration<Integer> en2 = new Enumeration<Integer>();
		en2.create(v2);
		
		while(en1.hasMoreElements() && en2.hasMoreElements()) {
			en1.nextElement();
			en2.nextElement();			
		}
		
		v1.add(1000);
		v1.remove((Integer) 1000);
		v1.add(2000);
		
		en1.create(v1);
		while(en1.hasMoreElements()) {
			en1.nextElement();
		}	
		
	}
	
}

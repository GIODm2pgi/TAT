package fr.ujf.enumeration;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationOK_SIMPLE {

	public static void main (String args[]) {
		Vector<Integer> v1 = new Vector<Integer>();
		for (int i=0; i<5; i++)
			v1.add(i);

		Vector<Integer> v2 = new Vector<Integer>();
		for (int i=0; i<5; i++)
			v2.add(i);

		Enumeration<Integer> en1 = v1.elements();
		Enumeration<Integer> en2 = v2.elements();

		while(en1.hasMoreElements() && en2.hasMoreElements()) {
			Integer i1 = (Integer) en1.nextElement();
			Integer i2 = (Integer) en2.nextElement();
			
			System.out.println("["+(i1+i2)+"]");
		}

	}
}

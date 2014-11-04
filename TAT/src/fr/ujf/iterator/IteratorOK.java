package fr.ujf.iterator;

import java.util.Iterator;
import java.util.Vector;

public class IteratorOK {

	public static void main (String args[]) {

		Vector<String> words = new Vector<String>();
		words.add("Antoine");
		words.add("de");
		words.add("St Exupery");

		Iterator<String> it = words.iterator();
		while(it.hasNext()) {
			String w1 = (String) it.next();
			System.out.println(w1);
		}
	}

}

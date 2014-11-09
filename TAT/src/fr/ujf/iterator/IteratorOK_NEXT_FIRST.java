package fr.ujf.iterator;

import java.util.Iterator;
import java.util.Vector;

public class IteratorOK_NEXT_FIRST {

	public static void main (String args[]) {

		Vector<String> words1 = new Vector<String>();
		words1.add("Mais");
		words1.add("Ou");
		words1.add("Et");
		words1.add("Donc");
		words1.add("Or");
		words1.add("Ni");
		words1.add("Car");
		
		Vector<String> words2 = new Vector<String>();
		words2.add("Un peu");
		words2.add("Beaucoup");
		words2.add("Énormément");
		words2.add("Pas du tout");
		words2.add("Très peu");
		words2.add("À peine");
		words2.add("À la folie");
		
		Iterator<String> it1 = words1.iterator();
		Iterator<String> it2 = words2.iterator();
		
		it1.next();
		it2.next();
		
		while(it1.hasNext() && it2.hasNext()) {
			String w1 = (String) it1.next();			
			String w2 = (String) it2.next();

			System.out.print("[("+w1+")("+w2+")]");
		}
	}

}

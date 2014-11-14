package fr.ujf.hashcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Hashcode_INTENSE_USE {

	/**
	 * Aj : AjHashCode.aj
	 * Config : no print in monitors 
	 * Number of exec : 100
	 * 
	 * 					    avg execution time with monitor      (61.56)
	 * Overhead in time = ------------------------------------ = ------- = 6.45
	 *                     avg execution time without monitor    (9.54)
	 */

	public static void main (String args[]) {

		long time = 0;
		int N = 100;

		for (int i=0; i<N; i++){
			long tmp = doService();
			time +=tmp;
			System.out.println(i + " / " + tmp);
		}

		System.out.println(((double) time) / ((double) N));

	}

	public static long doService (){

		long startTime = System.currentTimeMillis();	

		int N = 10000;

		for (int i=0; i<N; i++){
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

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}

}

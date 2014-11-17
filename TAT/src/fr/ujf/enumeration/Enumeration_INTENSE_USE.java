package fr.ujf.enumeration;


public class Enumeration_INTENSE_USE {

	/**
	 * Aj : AjEnumeration.aj
	 * Config : no print in monitors 
	 * Number of exec : 100
	 * 
	 * 					    avg execution time with monitor      (123.72)
	 * Overhead in time = ------------------------------------ = ------- = 41.94
	 *                     avg execution time without monitor    (2.95)
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

		int N = 5000;

		for (int i=0; i<N; i++){
			Enumeration_OK.main(null);
			Enumeration_OK_ADD.main(null);
			Enumeration_OK_RECREATE.main(null);
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}

}

package fr.ujf.hashcode;


public class Hashcode_INTENSE_USE {

	/**
	 * Aj : AjHashCode.aj
	 * Config : no print in monitors 
	 * Number of exec : 100
	 * 
	 * 					    avg execution time with monitor      (70.33)
	 * Overhead in time = ------------------------------------ = ------- = 10.80
	 *                     avg execution time without monitor    (6.51)
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

		int N = 2000;

		for (int i=0; i<N; i++){
			Hashcode_OK_TYPE_DOUBLE.main(null);
			Hashcode_OK.main(null);
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}

}

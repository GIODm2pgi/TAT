package fr.ujf.q3;

import fr.ujf.q3.ressource.File;


public class Question3_ERROR_NO_OPEN {
	
	public static void main (String args[]) {

		File f1 = new File("fichier1.txt");
		File f2 = new File("fichier2.txt");
		File f3 = new File("fichier3.txt");
		
		f1.read(); //error: no open on f1		
		f2.write();	//error: no open on f2	 	
		f3.close(); //error: no open on f3	
		
	}

}

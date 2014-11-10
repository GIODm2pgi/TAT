package fr.ujf.q3;

import fr.ujf.q3.ressource.File;


public class Question3_ERROR_CLOSE_BEFORE {
	
	public static void main (String args[]) {

		File f1 = new File("fichier1.txt");
		
		f1.close();
		
	}

}

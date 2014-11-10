package fr.ujf.q3;

import fr.ujf.q3.ressource.File;
import fr.ujf.q3.ressource.File.MODE;


public class Question3_ERROR_WRONG_ACCESS {
	
	public static void main (String args[]) {

		File f1 = new File("fichier1.txt");
		File f2 = new File("fichier2.txt");
		
		f1.open(MODE.READ);
		f1.write();
		f2.open(MODE.WRITE);
		f2.read();
		f2.close();
		f1.close();
		
	}

}

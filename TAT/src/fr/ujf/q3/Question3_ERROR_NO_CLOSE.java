package fr.ujf.q3;

import fr.ujf.q3.resource.File;
import fr.ujf.q3.resource.File.MODE;


public class Question3_ERROR_NO_CLOSE {
	
	public static void main (String args[]) {

		File f1 = new File("fichier1.txt");
		File f2 = new File("fichier2.txt");
		
		f1.open(MODE.READ);
		f1.read();
		f2.open(MODE.WRITE);
		f2.write();
		
		//CURRENTLY_FALSE: f1 never close
		//CURRENTLY_FALSE: f2 never close
	}

}

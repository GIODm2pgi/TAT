package fr.ujf.q3;

import fr.ujf.q3.resource.File;
import fr.ujf.q3.resource.File.MODE;


public class Question3_OK {
	
	public static void main (String args[]) {

		File f1 = new File("fichier1.txt");
		File f2 = new File("fichier2.txt");
		
		f1.open(MODE.READ);
		f1.read();
		f2.open(MODE.WRITE);
		f2.write();
		f2.close();
		f1.close();
		
	}

}

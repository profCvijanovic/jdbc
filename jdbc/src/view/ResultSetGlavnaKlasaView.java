package view;

import java.util.List;
import controller.ResultSetController;
import model.Student;

public class ResultSetGlavnaKlasaView {

	public static void main(String[] args) {
		
		ResultSetController controller = new ResultSetController();
		
		List<Student> sviStudenti = controller.dajMiSveStudenteIzBaze();

		System.out.println("id**ime**prezime**index**smer**drzava**polozeni ispiti**");
		
		for(Student s: sviStudenti) {			
			System.out.println(s.getIdStudent() + "   "
								+ s.getIme() + "   " 
								+ s.getPrezime() + "   " 
								+ s.getBrojIndexa() + "   " 
								+ s.getSmer() + "   " 
								+ s.getDrzava() + "   " 
								+ s.getIspiti() );		
		}
		
		
		

	}

}

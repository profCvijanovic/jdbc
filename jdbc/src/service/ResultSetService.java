package service;

import java.util.List;

import dao.ResultSetLogic;
import model.Predmet;
import model.Student;

public class ResultSetService {
	
	ResultSetLogic logic = new ResultSetLogic();

	public String dajMiNazivSmera(String id) {
		return logic.vratiNazivSmeraPoId(id);
	}

	// ovde je controller prosledio metodu (zadatak)
	// servis prosledjuje zadatak logici
	public Predmet vratiMiPredmet(String id) {
		// ovde pozivamo metodu iz logica koja ce da napuni predmet i da vrati servisu
		// servis ce rezultat obrade metode iz logica proslediti nazad kontroleru
		return logic.vratiPredmetPoId(id);
	}

	public List<Student> dajMiSveStudenteIzBaze() {
		return logic.vratiSveStudente();
	}
	
	

}

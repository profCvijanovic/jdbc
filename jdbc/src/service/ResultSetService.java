package service;

import dao.ResultSetLogic;
import model.Predmet;

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

}

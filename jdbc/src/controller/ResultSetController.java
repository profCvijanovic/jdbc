package controller;

import model.Predmet;
import service.ResultSetService;

public class ResultSetController {
	
	ResultSetService service = new ResultSetService();

	public String dajMiNazivSmera(String id) {
		return service.dajMiNazivSmera(id);
	}

	// ovde sam prosledio iz glavne klase
	// controller prosledjuje servisu zadatak
	public Predmet vratiMiPredmet(String id) {
		// ovde trazim od servisa da mi vrati predmet
		// servis mi vraca odgovor koji je dobio iz logica
		// kontroler vraca odgovor glavnoj klasi (user interface-u)
		return service.vratiMiPredmet(id);
	}

}

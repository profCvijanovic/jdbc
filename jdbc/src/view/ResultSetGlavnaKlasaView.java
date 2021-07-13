package view;

import java.util.Scanner;

import controller.ResultSetController;
import model.Predmet;

public class ResultSetGlavnaKlasaView {

	public static void main(String[] args) {
		
		ResultSetController controller = new ResultSetController();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesite id predmeta: ");
		String id = scanner.nextLine();
		scanner.close();
		
		/*
		 * String nazivSmera = controller.dajMiNazivSmera(id);
		 * System.out.println("Naziv smera je: " + nazivSmera);
		 */
		
		// krecemo od user interface-a, tj glavne klase
		// pozivamo kontroler da nam vrati objekat predmet
		// (koji smo prethodno napravili kao model po uzoru na tabelu predmet iz baze)
		Predmet predmet = controller.vratiMiPredmet(id);
		
		//na kraju: ispis predmeta iz baze
		System.out.println("Izabrani predmet: ");
		System.out.println("ID: " + predmet.getIdPredmet());
		System.out.println("Naziv predmeta: " + predmet.getNazivPredmeta());
		System.out.println("Broj semestara: " + predmet.getBrojSemestara());
		System.out.println("Smer: " + predmet.getSmer());

	}

}

package metode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Student;

public class CommonMethods {
	
	public static Connection konektujSe(String imeBaze) throws SQLException {
		
		final String user = "root";
		final String password = "root";
		final String url = "jdbc:mysql://localhost:3306/" + imeBaze;
		
		return DriverManager.getConnection(url, user, password);
		
	}
	
	public void pozdrav() {
		System.out.println("Pozdrav iz nase aplikacije...");
	}
	
	public Student setStudent(String ime, String prezime, int index, int drzava, int smer, int ispiti) {
		
		Student student = new Student();
			student.setIme(ime);
			student.setPrezime(prezime);
			student.setBrojIndexa(index);
			student.setSmer(smer);
			student.setDrzava(drzava);
			student.setIspiti(ispiti);
			
		return student;
	}
	

}

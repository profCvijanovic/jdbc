package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metode.CommonMethods;
import model.Predmet;
import model.Student;

public class ResultSetLogic {
	
	public String vratiNazivSmeraPoId(String id) {
		
		String smer = "";
		
		FakultetSqlLogic logic = new FakultetSqlLogic();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = CommonMethods.konektujSe("fakultet");
			String query = "SELECT naziv \n"
					+ "FROM smer\n"
					+ "WHERE\n"
					+ "id = ?";
			ps = con.prepareStatement(query);
				ps.setInt(1, Integer.parseInt(id));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				smer = rs.getString("naziv");
			}
			
		} catch (SQLException e) {
			System.out.println("Nije uspelo vracanje naziva...");
			e.printStackTrace();
		} finally {
			logic.zatvoriResultSet(rs);
			logic.zatvoriPreparedStatement(ps);
			logic.zatvoriKonekciju(con);
		}
		
		return smer;	
	}
	
	
	// ovde idemo u bazu, preko upita "vadimo" red iz baze
	// mapiramo na objekat predmet kolone iz result seta
	// vracamo pun objekat servisu
	public Predmet vratiPredmetPoId(String id) {
		
		Predmet predmet = new Predmet();
		FakultetSqlLogic logic = new FakultetSqlLogic();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = CommonMethods.konektujSe("fakultet");
			System.out.println("Konekcija OK...");
			String query = "SELECT *\n"
					+ "FROM predmet\n"
					+ "WHERE\n"
					+ "id = ?";
			ps = con.prepareStatement(query);
				ps.setInt(1, Integer.parseInt(id));
			
			rs = ps.executeQuery();
			while(rs.next()) {
				//mapiranje modela i resultset-a
				predmet.setIdPredmet(rs.getInt("id"));
				predmet.setNazivPredmeta(rs.getString("naziv_predmeta"));
				predmet.setBrojSemestara(rs.getInt("broj_semestara"));
				predmet.setSmer(rs.getInt("smer"));
			}
			
		} catch (SQLException e) {
			System.out.println("Nisam uspeo da vratim predmet...");
			e.printStackTrace();
		}finally {
			logic.zatvoriResultSet(rs);
			logic.zatvoriPreparedStatement(ps);
			logic.zatvoriKonekciju(con);
		}

		return predmet;	
	}


	public List<Student> vratiSveStudente() {
		
		List<Student> studentiIzBaze = new ArrayList<>();
		FakultetSqlLogic logic = new FakultetSqlLogic();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = CommonMethods.konektujSe("fakultet");
			System.out.println("Konekcija OK...");
			String query = "SELECT * FROM student";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Student student = new Student();
				//ovde je mapiranje
					student.setIdStudent(rs.getInt("id_student"));
					student.setIme(rs.getString("ime"));
					student.setPrezime(rs.getString("prezime"));
					student.setBrojIndexa(rs.getInt("broj_indexa"));
					student.setSmer(rs.getInt("smer"));
					student.setDrzava(rs.getInt("drzava"));
					student.setIspiti(rs.getInt("polozeni_ispiti"));
				// dodajem studenta u listu
				studentiIzBaze.add(student);
			}
			
		} catch (SQLException e) {
			System.out.println("Nesto nije u redu sa vrati studente iz baze!");
			e.printStackTrace();
		}finally {
			logic.zatvoriResultSet(rs);
			logic.zatvoriPreparedStatement(ps);
			logic.zatvoriKonekciju(con);
		}

		return studentiIzBaze;
	}
	
	

}

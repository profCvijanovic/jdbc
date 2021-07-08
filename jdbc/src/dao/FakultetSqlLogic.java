package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metode.CommonMethods;
import model.Drzava;
import model.Student;

public class FakultetSqlLogic {
	
	private void zatvoriPreparedStatement(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
				System.out.println("Zatvorio ps...");
			} catch (SQLException e) {
				System.out.println("Nije zatvorio ps!");
				e.printStackTrace();
			}
		}
	}
	
	private void zatvoriKonekciju(Connection con) {
		if(con != null) {
			try {
				con.close();
				System.out.println("Zatvorio konekciju...");
			} catch (SQLException e) {
				System.out.println("Nije zatvorio konekciju!");
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void unesiDrzavu(String imeDrzave) {
			
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = CommonMethods.konektujSe("fakultet");
			System.out.println("Konekcija OK...");
			String query = "INSERT INTO drzava VALUES (null,?)";
			ps = con.prepareStatement(query);
				ps.setString(1, imeDrzave);
			ps.execute();
			System.out.println("Upisan " + imeDrzave + " u tabelu drzava");
			
		} catch (SQLException e) {
			System.out.println("Nije konektovan...");
			e.printStackTrace();
		} finally {
			zatvoriPreparedStatement(ps);
			zatvoriKonekciju(con);
		}
		
		
	}
	
	
	
	public void unesiStudenta(Student student) {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = CommonMethods.konektujSe("fakultet");
			System.out.println("Konekcija OK...");
			String query = "INSERT INTO student VALUES (null,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
				ps.setString(1, student.getIme());
				ps.setString(2, student.getPrezime());
				ps.setInt(3, student.getBrojIndexa());
				ps.setInt(4, student.getSmer());
				ps.setInt(5, student.getDrzava());
				ps.setInt(6, student.getIspiti());
			ps.execute();
			System.out.println("Upisan student u tabelu student");
			
		} catch (SQLException e) {
			System.out.println("Nije konektovan...");
			e.printStackTrace();
		}finally {
			zatvoriPreparedStatement(ps);
			zatvoriKonekciju(con);
		}	
	}

	public void updateNazivDrzave(Drzava drzava) {
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = CommonMethods.konektujSe("fakultet");
			System.out.println("Konekcija OK...");
			String sql = "UPDATE drzava \n"
					+ "SET naziv = ? \n"
					+ "WHERE id_drzava = ?";
			pst = con.prepareStatement(sql);
				pst.setString(1, drzava.getNazivDrzave());
				pst.setInt(2, drzava.getIdDrzave());
			
			pst.executeUpdate();
			
			System.out.println("Ime drzave promenjeno na " + drzava.getNazivDrzave());							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			zatvoriPreparedStatement(pst);
			zatvoriKonekciju(con);
		}	
	}
	
	
	
	
	

}

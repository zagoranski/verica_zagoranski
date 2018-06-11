import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MeritveDao {
	DataSource baza;

	private MeritveDao() {
		try {
			baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/aiv123");	
			//kreirajTabele();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
private static MeritveDao inst=new MeritveDao();
	
	public static MeritveDao getInstance() {
		return inst;
	}

	public void kreirajTabele() throws Exception {
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			
			conn.createStatement().execute("create table meritve if not exists(id int auto_increment, datumMeritve date, visina DOUBLE PRECISION, opsegPasu DOUBLE PRECISION, teza DOUBLE PRECISION, tk_sifra_clan varchar, primary key (id))");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	// sifra denes v metodi  preko izbranaOseba
	public void shrani(Meritve o, String sifra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 String datum = sdf.format(o.getDatumMeritve());
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			System.out.print("saokdoaskdaosdkao");
			conn=baza.getConnection();
				PreparedStatement ps = conn.prepareStatement("insert into meritve(datumMeritve, visina, opsegPasu, teza, tk_sifra_clan) values (?,?,?,?,?)");
				ps.setDate(1,java.sql.Date.valueOf(datum));
				ps.setDouble(2, o.getVisina());
				ps.setDouble(3, o.getObsegPasu());
				ps.setDouble(4, o.getTeza());
				ps.setString(5, sifra);
				ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	public Meritve najdi(Date datum) throws Exception {
		Meritve ret = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 String date = sdf.format(datum);
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from meritve where datumMeritve=?");
			ps.setDate(1, java.sql.Date.valueOf(date));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ret = new Meritve(datum, rs.getDouble("visina"), rs.getDouble("opsegPasu"), rs.getDouble("teza"));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}
	public ArrayList<Meritve> vrniVse(String sifra) throws Exception {
		ArrayList<Meritve> ret = new ArrayList<Meritve>();
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();

			PreparedStatement ps = conn.prepareStatement("select * from meritve where tk_sifra_clan=?");
			ps.setString(1, sifra);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Meritve o = new Meritve(rs.getDate("datumMeritve"), rs.getDouble("visina"), rs.getDouble("opsegPasu"), rs.getDouble("teza"));
				ret.add(o);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}
	public void spremeni(Meritve o,String sifra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 String datum = sdf.format(o.getDatumMeritve());
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
				PreparedStatement ps = conn.prepareStatement("update meritve set datumMeritve=?, visina=?, opsegPasu=?, teza=? where tk_sifra_clan=?");
				ps.setDate(1,java.sql.Date.valueOf(datum));
				ps.setDouble(2, o.getVisina());
				ps.setDouble(3, o.getObsegPasu());
				ps.setDouble(4, o.getTeza());
				ps.setString(5, sifra);
				ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

			

	}
	public void zbrisi(Date datum, String sifra) throws SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 String date= sdf.format(datum);
	Connection conn=null;
	 try 
	 {  
    conn=baza.getConnection();
	PreparedStatement st = conn.prepareStatement("DELETE FROM meritve WHERE tk_sifra_clan=? and datumMeritve=?");
	st.setString(1,sifra);
	st.setDate(2,java.sql.Date.valueOf(date));
	st.executeUpdate(); 
	 } catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	 
	}


}

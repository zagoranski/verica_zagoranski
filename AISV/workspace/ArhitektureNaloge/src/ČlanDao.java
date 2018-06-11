import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ÈlanDao {
	
	DataSource baza;

	private ÈlanDao() {
		try {
			baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/aiv123");	
			//kreirajTabele();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
private static ÈlanDao inst=new ÈlanDao();
	
	public static ÈlanDao getInstance() {
		return inst;
	}

	public void kreirajTabele() throws Exception {
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			
			conn.createStatement().execute("create table clan  if not exists(id int auto_increment, ime varchar(255), priimek varchar(255), spol varchar(255), rojstvo date, datum date, sifra varchar(255), primary key (id))");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public OsebaClan najdi(String sifra) throws Exception {
		OsebaClan ret = null;
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from clan where sifra=?");
			ps.setString(1, sifra);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ret = new OsebaClan(rs.getString("ime"), rs.getString("priimek"), rs.getString("spol"), rs.getDate("rojstvo"),rs.getDate("datum"), sifra);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}

	public void shrani(OsebaClan o) throws Exception {
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 String datum = sdf.format(o.getDatum());
	 String datumVpisa = sdf.format(o.getDatumVpisa());

		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
				PreparedStatement ps = conn.prepareStatement("insert into clan(ime , priimek, spol, rojstvo, datum, sifra, email) values (?,?,?,?,?,?,?)");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setString(3, o.getSpol());
				ps.setDate(4, java.sql.Date.valueOf(datum));
				ps.setDate(5,java.sql.Date.valueOf(datumVpisa));
				ps.setString(6, o.getSifra());
				ps.setString(7, o.getMail());
				ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public List<OsebaClan> vrniVse() throws Exception {
		List<OsebaClan> ret = new ArrayList<OsebaClan>();
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();

			ResultSet rs=conn.createStatement().executeQuery("select * from clan");
			while (rs.next()) {
				OsebaClan o = new OsebaClan(rs.getString("ime"), rs.getString("priimek"), rs.getString("spol"), rs.getDate("rojstvo"), rs.getDate("datum"), rs.getString("sifra"));
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
	public void spremeni(OsebaClan o,String sifra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 String datum = sdf.format(o.getDatum());
		 String datumVpisa = sdf.format(o.getDatumVpisa());

		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			PreparedStatement ps = conn.prepareStatement("update clan set ime=?, priimek=?, spol=?, rojstvo=?, datum=? where sifra=?");
			ps.setString(1, o.getIme());
			ps.setString(2, o.getPriimek());
			ps.setString(3, o.getSpol());
			ps.setDate(4, java.sql.Date.valueOf(datum));
			ps.setDate(5,java.sql.Date.valueOf(datumVpisa));
			ps.setString(6, sifra);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	public void zbrisi(String sifra) throws SQLException {
	Connection conn=null;
	 try 
	 {  
    conn=baza.getConnection();
	PreparedStatement st = conn.prepareStatement("DELETE FROM meritve WHERE tk_sifra_clan=?");
	st.setString(1,sifra);
	st.executeUpdate(); 
	PreparedStatement s = conn.prepareStatement("DELETE FROM clan WHERE sifra=?");
	s.setString(1,sifra);
	s.executeUpdate(); 
	 } catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	 
	}

}

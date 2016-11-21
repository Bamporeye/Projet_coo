package Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bdd.ConnectionBD;
import Domaine.Personne;

public class PersonneMapper {
	public Connection connect = ConnectionBD.getInstance();
	private int ID;
	static PersonneMapper inst;
	
	public PersonneMapper() {
		ID = 1;
	}
	
	static public PersonneMapper getInstance() {
		if (inst == null)
			inst = new PersonneMapper();
		return inst;
	}
	
	/**
	 ** Trouver une personne pars son id
	 *@param id de la personne 
	 *@return Personne 
	 * 
	 * */
	public Personne find(int id) {
		Personne p= null;
		try {
				String req = "SELECT id,nom, prenom, evaluation FROM PERSONNE_1 WHERE ID=?";
				PreparedStatement ps= connect.prepareStatement(req);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				p =new Personne (id, rs.getString(1),rs.getString(2));
			}catch (SQLException e) {e.printStackTrace();}
				
		return p;
		
	}
	/**
	 * Trouver les fils d une personne en passant par son id
	 * @param id du pere
	 * @return List<Personne> listes des fils
	 */
	public ArrayList<Personne> findChilds(int id) {
		ArrayList<Personne> pe = new ArrayList<Personne>();
		try {
			String req = "SELECT id,nom, prenom, evaluation FROM PERSONNE_1 WHERE ID=?";
			PreparedStatement ps= connect.prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Personne p;
			p =new Personne (id, rs.getString(1),rs.getString(2));
			pe.add(p);
		}catch (SQLException e) {e.printStackTrace();}
			
	return pe;
	}
	/**
	 * Creer une nouvelle personne
	 * @param Personne
	 */
	public void create(Personne pers) {
		try{
			String  req = "INSERT INTO PERSONNE_1 (ID, Nom ,Prenom)" + "VALUES(?,?,?)";
			PreparedStatement ps= connect.prepareStatement(req);
			ps.setInt(1,ID);
			ps.setString(2,pers.getNom());
			ps.setString(3,pers.getPrenom());
			ps.executeUpdate();
			ID++;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Permet de mettre a jour une Personne d'une entree dans la base 
	 * @param Personne
	 */
	public void update(Personne pers) {
		try{
			String req = "UPDATE PERSONNE SET NOM=? , Prenom =?  WHERE IDPERS=?";
			PreparedStatement ps= connect.prepareStatement(req);
			ps.setString(1, pers.getNom());
			ps.setString(2, pers.getPrenom());
			ps.setInt(3, ID);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Supprimer la personne qu'on veut
	 * @param Personne
	 */
	public void delete(Personne pers) {
		try{
			String req = "DELETE FROM PERSONNE WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(req);
			ps.setInt(1, pers.getId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

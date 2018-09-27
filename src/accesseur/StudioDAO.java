package accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import donnee.BaseDeDonnee;
import modele.Studio;

public class StudioDAO {
	
	private Connection connection = null;
	
	public StudioDAO()
	{
		this.connection = BaseDeDonnee.getInstance().getConnection();
	}
	
	public List<Studio> listerStudio(int id_anime)
	{
		System.out.println("StudioDAO.listerStudio()");
		List<Studio> listeStudio =  new ArrayList<Studio>();			
		Statement requeteListeStudio;
		try {
			requeteListeStudio = connection.createStatement();

			
			ResultSet curseurListeStudio = requeteListeStudio.executeQuery("SELECT * FROM Studio WHERE id_anime = " + id_anime);
			while(curseurListeStudio.next())
			{
				int id = curseurListeStudio.getInt("id");
				String nom_studio = curseurListeStudio.getString("nom_studio");
				String producteurs = curseurListeStudio.getString("producteurs");				
				System.out.println("Studio " + nom_studio + " avec " + producteurs + " producteurs");
				
				Studio studio = new Studio(nom_studio, producteurs);
				studio.setId(id);
				listeStudio.add(studio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerStudio();
		return listeStudio;
	}	
	
	public List<Studio> simulerListeStudio() {
	
		List<Studio> listeStudio = new ArrayList<Studio>();
		Studio nom_studio;
		nom_studio = new Studio("Kinema Citrus", "Sentai Filmworks");
		listeStudio.add(nom_studio);
		
		return listeStudio;
	
	}

}

package accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Anime;

public class AnimeDAO {

	public List<Anime> simulerListerAnime()
	{
		List listeAnimeTest = new ArrayList<Anime>();
		listeAnimeTest.add(new Anime("Made in Abyss", "Kinema Citrus", "13", "Ete 2017"));
		listeAnimeTest.add(new Anime("A Silent Voice", "Kyoto Animation", "1", "Automne 2016"));
		listeAnimeTest.add(new Anime("Your Name", "CoMix Wave Films", "1", "Ete 2016"));
		listeAnimeTest.add(new Anime("Hyouka", "Kyoto Animation", "22", "Printemps 2012"));
		return listeAnimeTest;
		
	}
	
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/bergerie";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "root";
	
	private Connection connection = null;
	
	public AnimeDAO() 
	{

		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	public List<Anime> listerAnime()
	{	
		
		List<Anime> listeAnime =  new ArrayList<Anime>();
		Statement requeteListeAnime;
		try {
			requeteListeAnime = connection.createStatement();
			ResultSet curseurListeAnime = requeteListeAnime.executeQuery("SELECT * FROM mouton");
			while(curseurListeAnime.next())
			{
				String nom = curseurListeAnime.getString("nom");
				String studio = curseurListeAnime.getString("studio");
				String nbEpisode = curseurListeAnime.getString("nbEpisode");
				String diffusion = curseurListeAnime.getString("diffusion");
				System.out.println("Anime " + nom + " fait par le studio " + studio + " : " + nbEpisode + " épisodes " + diffusion);
				Anime anime = new Anime(nom, studio, nbEpisode, diffusion);
				listeAnime.add(anime);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		//return this.simulerListerAnime();
		return listeAnime;
	}
	
	public void ajouterAnime(Anime anime) {
		
		System.out.println("AnimeDAO.ajouterAnime()");
		
		
		try {
			Statement requeteAjouterAnime = connection.createStatement();
			String sqlAjouterAnime = "INSERT into Anime(nom, studio, nbEpisode, diffusion) VALUES('"+anime.getNom()+"','"+anime.getStudio()+"','"+anime.getNbEpisode()+"','"+anime.getDiffusion()+"')";
			System.out.println("SQL : " + sqlAjouterAnime);
			requeteAjouterAnime.execute(sqlAjouterAnime);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

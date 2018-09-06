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
	public List<Anime> listerAnime()
	{
		String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
		String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/bergerie";
		String BASEDEDONNEES_USAGER = "postgres";
		String BASEDEDONNEES_MOTDEPASSE = "root";
		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Anime> listeAnime =  new ArrayList<Anime>();
		try {
			Connection connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
			
			Statement requeteListeAnime = connection.createStatement();
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
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//return this.simulerListerAnime();
		return listeAnime;
	}
	
}

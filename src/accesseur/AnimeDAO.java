package accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import donnee.BaseDeDonnee;
import modele.Anime;

public class AnimeDAO {
	
	private Connection connection = null;
	
	public AnimeDAO()
	{
		this.connection = BaseDeDonnee.getInstance().getConnection();	
	}

	public List<Anime> simulerListerAnime()
	{
		List listeAnimeTest = new ArrayList<Anime>();
		listeAnimeTest.add(new Anime("Made in Abyss", "13", "Ete 2017"));
		listeAnimeTest.add(new Anime("A Silent Voice", "1", "Automne 2016"));
		listeAnimeTest.add(new Anime("Your Name", "1", "Ete 2016"));
		listeAnimeTest.add(new Anime("Hyouka", "22", "Printemps 2012"));
		return listeAnimeTest;
		
	}
		
	
	public List<Anime> listerAnime()
	{	
		
		List<Anime> listeAnime =  new ArrayList<Anime>();
		Statement requeteListeAnime;
		try {
			requeteListeAnime = connection.createStatement();
			ResultSet curseurListeAnime = requeteListeAnime.executeQuery("SELECT * FROM Anime");
			while(curseurListeAnime.next())
			{
				int id = curseurListeAnime.getInt("id");
				String nom = curseurListeAnime.getString("nom"); 
				//String studio = curseurListeAnime.getString("studio");
				String nbEpisode = curseurListeAnime.getString("nbEpisode");
				String diffusion = curseurListeAnime.getString("diffusion");
				System.out.println("Anime " + nom + " : " + nbEpisode + " épisodes " + diffusion);
				Anime anime = new Anime(nom, nbEpisode, diffusion);
				anime.setId(id);
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
			
			String SQL_AJOUTER_ANIME = "INSERT into Anime(nom, nbEpisode, diffusion) VALUES(?,?,?)";
			PreparedStatement requeteAjouterAnime = connection.prepareStatement(SQL_AJOUTER_ANIME);
			requeteAjouterAnime.setString(1, anime.getNom());
			requeteAjouterAnime.setString(2, anime.getNbEpisode());
			requeteAjouterAnime.setString(3, anime.getDiffusion());
			
			System.out.println("SQL : " + SQL_AJOUTER_ANIME);
			requeteAjouterAnime.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Anime rapporterAnime(int idAnime) {
		//Statement requeteAnime;
		PreparedStatement requeteAnime;
		try {
			//requeteAnime = connection.createStatement();
			String SQL_RAPPORTER_ANIME = "SELECT * FROM anime WHERE id = ?";
			requeteAnime = connection.prepareStatement(SQL_RAPPORTER_ANIME);
			requeteAnime.setInt(1, idAnime);
			
			System.out.println(SQL_RAPPORTER_ANIME);
			ResultSet curseurAnime = requeteAnime.executeQuery();
			curseurAnime.next();
			int id = curseurAnime.getInt("id");
			String nom = curseurAnime.getString("nom");
			//String studio = curseurAnime.getString("studio");
			String nbEpisode = curseurAnime.getString("nbEpisode");
			String diffusion = curseurAnime.getString("diffusion");
			System.out.println(nom + " avec " + nbEpisode + " épisodes, diffusé le " + diffusion);
			Anime anime = new Anime(nom, nbEpisode, diffusion);
			anime.setId(id);
			return anime;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void modifierAnime(Anime anime) {
		
		System.out.println("AnimeDAO.modifierAnime()");
		try {
	
			String SQL_MODIFIER_ANIME = "UPDATE anime SET nom = ? , nbEpisode = ?, diffusion = ? WHERE id = ?";
			PreparedStatement requeteModifierAnime = connection.prepareStatement(SQL_MODIFIER_ANIME);
			requeteModifierAnime.setString(1, anime.getNom());
			requeteModifierAnime.setString(2, anime.getNbEpisode());
			requeteModifierAnime.setString(3, anime.getDiffusion());
			requeteModifierAnime.setInt(4, anime.getId());
			System.out.println("SQL : " + SQL_MODIFIER_ANIME);
			requeteModifierAnime.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

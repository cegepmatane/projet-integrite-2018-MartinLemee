package controleur;


import java.util.List;

import accesseur.AnimeDAO;
import modele.Anime;
import vue.NavigateurDesVues;
import vue.VueAnime;
import vue.VueAjouterAnime;
import vue.VueListeAnime;

public class ControleurAnime {
	
	
	private VueAnime vueAnime = null;
	private VueListeAnime vueListeAnime = null;
	private VueAjouterAnime vueAjouterAnime = null;
	
	private NavigateurDesVues navigateur = null;
	public ControleurAnime() 
	{
		
	}
	
	private static ControleurAnime instance = null; // null est important
	public static ControleurAnime getInstance()
	{
		if(null == instance)
		{
			instance = new ControleurAnime();
		}
		return instance;
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAnime = this.navigateur.getVueAnime();
		this.vueListeAnime = this.navigateur.getVueListeAnime();
		this.vueAjouterAnime = this.navigateur.getVueAjouterAnime();
		
		
		
		/// TEST ///
		AnimeDAO animeDAO = new AnimeDAO();
		List<Anime> listeAnimeTest = animeDAO.listerAnime();
;		this.vueListeAnime.afficherListeAnime(listeAnimeTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
				
		//// TEST ////
		Anime anime = new Anime("Made in Abyss", "Kinema Citrus", "13", "Ete 2017");
		this.vueAnime.afficherAnime(anime); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		//// TEST Navigation ////
		this.navigateur.naviguerVersVueAnime();
		this.navigateur.naviguerVersVueListeAnime();
		this.navigateur.naviguerVersVueAjouterAnime();
				
	}

}

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
	
	private NavigateurDesVues navigateur;
	AnimeDAO animeDAO = null;
	
	public ControleurAnime() 
	{
		System.out.println("Initialisation du controleur");	
		this.animeDAO = new AnimeDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAnime = this.navigateur.getVueAnime();
		this.vueListeAnime = this.navigateur.getVueListeAnime();
		this.vueAjouterAnime = this.navigateur.getVueAjouterAnime();
		
		
		
		/// TEST ///
		List<Anime> listeAnimeTest = animeDAO.listerAnime();
;		this.vueListeAnime.afficherListeAnime(listeAnimeTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
				
		//// TEST ////
		Anime anime = new Anime("Made in Abyss", "Kinema Citrus", "13", "Ete 2017");
		this.vueAnime.afficherAnime(anime); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		//// TEST Navigation ////
		this.navigateur.naviguerVersVueListeAnime();
		
				
	}
	
	// SINGLETON DEBUT
		private static ControleurAnime instance = null;
		public static ControleurAnime getInstance()
		{
			if(null == instance) instance = new ControleurAnime();
			return instance;
		}
	
	//SINGLETON FINI
	public void notifierEnregistrerMouton()
	{
		System.out.println("ControleurAnime.notifierEnregistrerAnime()");
		Anime anime = this.navigateur.getVueAjouterAnime().demanderAnime();
		this.animeDAO.ajouterAnime(anime);
		this.vueListeAnime.afficherListeAnime(this.animeDAO.listerAnime()); // TODO optimiser
		this.navigateur.naviguerVersVueListeAnime();
	}
	
	public void notifierNaviguerAjouterAnime()
	{
		System.out.println("ControleurAnime.notifierNaviguerAjouterAnime()");
		this.navigateur.naviguerVersVueAjouterAnime();
	}

}

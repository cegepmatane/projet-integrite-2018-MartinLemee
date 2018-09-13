package controleur;


import java.util.List;

import accesseur.AnimeDAO;
import modele.Anime;
import vue.NavigateurDesVues;
import vue.VueAnime;
import vue.VueEditerAnime;
import vue.VueAjouterAnime;
import vue.VueListeAnime;

public class ControleurAnime {
	
	
	private VueAnime vueAnime = null;
	private VueListeAnime vueListeAnime = null;
	private VueAjouterAnime vueAjouterAnime = null;
	private VueEditerAnime vueEditerAnime = null;
	
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
		this.vueEditerAnime = this.navigateur.getVueEditerAnime();		
		
		
		
				
		//// TEST ////
		Anime anime = new Anime("Made in Abyss", "Kinema Citrus", "13", "Ete 2017");
		this.vueAnime.afficherAnime(anime); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		//// TEST Navigation ////
		this.navigateur.naviguerVersVueAnime();
		
		/// TEST ///
		List<Anime> listeAnimeTest = animeDAO.listerAnime();
		this.vueListeAnime.afficherListeAnime(listeAnimeTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
				
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
	public void notifierEnregistrerAnime()
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
	
	public void notifierNaviguerEditerAnime() {
		
		System.out.println("ControleurAnime.notifierEditerAnime()");
		this.navigateur.naviguerVersVueEditerAnime();
	}

}

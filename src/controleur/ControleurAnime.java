package controleur;


import java.util.ArrayList;
import java.util.List;

import donnee.AnimeDAO;
import donnee.StudioDAO;
import modele.Anime;
import modele.Studio;
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
	private AnimeDAO animeDAO = null;
	private StudioDAO studioDAO = null;
	
	public ControleurAnime() 
	{
		System.out.println("Initialisation du controleur");	
		this.animeDAO = new AnimeDAO();
		this.studioDAO = new StudioDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAnime = this.navigateur.getVueAnime();
		this.vueListeAnime = this.navigateur.getVueListeAnime();
		this.vueAjouterAnime = this.navigateur.getVueAjouterAnime();
		this.vueEditerAnime = this.navigateur.getVueEditerAnime();		
		
		
		
				
		//// TEST ////
		Anime anime = new Anime("Made in Abyss", "13", "Ete 2017");
		this.vueAnime.afficherAnime(anime); // Appel de ma fonction avant de la programmer (pour tester � mesure)
		
		//// TEST Navigation ////
		this.navigateur.naviguerVersVueAnime();
		
		/// TEST ///
		List<Anime> listeAnimeTest = animeDAO.listerAnime();
		this.vueListeAnime.afficherListeAnime(listeAnimeTest); // Appel de ma fonction avant de la programmer (pour tester � mesure)
		
		/// TEST studio ///
		
		this.navigateur.naviguerVersVueListeAnime();
		
		//this.vueEditerAnime.afficherListeStudio(this.studioDAO.listerStudio(id_anime));
		
		
				
	}
	
	// SINGLETON DEBUT
		private static ControleurAnime instance = null;
		public static ControleurAnime getInstance()
		{
			if(null == instance) instance = new ControleurAnime();
			return instance;
		}
	
	//SINGLETON FINI
	public void notifierEnregistrerNouvelAnime()
	{
		System.out.println("ControleurAnime.notifierEnregistrerNouvelAnime()");
		Anime anime = this.navigateur.getVueAjouterAnime().demanderAnime();
		this.animeDAO.ajouterAnime(anime);
		this.vueListeAnime.afficherListeAnime(this.animeDAO.listerAnime()); // TODO optimiser
		this.navigateur.naviguerVersVueListeAnime();
	}
	
	public void notifierEnregistrerAnime() {
		
		System.out.println("ControleurAnime.notifierEnregistrerAnime()");
		Anime anime = this.navigateur.getVueEditerAnime().demanderAnime();
		this.animeDAO.modifierAnime(anime);
		this.vueListeAnime.afficherListeAnime(this.animeDAO.listerAnime()); // TODO optimiser
		this.navigateur.naviguerVersVueListeAnime();
	}
	
	public void notifierNaviguerAjouterAnime()
	{
		System.out.println("ControleurAnime.notifierNaviguerAjouterAnime()");
		this.navigateur.naviguerVersVueAjouterAnime();
	}
	
	public void notifierNaviguerEditerAnime(int idAnime) {
		
		System.out.println("ControleurAnime.notifierEditerAnime("+idAnime+")");
		this.vueEditerAnime.afficherAnime(this.animeDAO.rapporterAnime(idAnime));
		this.navigateur.naviguerVersVueEditerAnime();
	}

}

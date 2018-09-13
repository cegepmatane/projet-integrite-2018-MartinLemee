package vue;

import controleur.ControleurAnime;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueAjouterAnime vueAjouterAnime = null;
	private VueListeAnime vueListeAnime = null;
	private VueEditerAnime vueEditerAnime = null;
	private VueAnime vueAnime = null;
	
	private ControleurAnime controleur = null;
	
	
	public NavigateurDesVues() 
	{
		this.vueAjouterAnime = new VueAjouterAnime();
		this.vueListeAnime = new VueListeAnime();
		this.vueAnime = new VueAnime();	
		this.vueEditerAnime = new VueEditerAnime();
		
		
	}
	
	
	
	@Override
	public void start(Stage stade) throws Exception {
		
		this.stade = stade;
		
		stade.setScene(null);
		stade.show();
		
		this.controleur = ControleurAnime.getInstance();
		this.controleur.activerVues(this);
		this.vueAjouterAnime.setControleur(controleur);
		this.vueListeAnime.setControleur(controleur);
		this.vueAnime.setControleur(controleur);
		this.vueAjouterAnime.setControleur(controleur);
		this.vueEditerAnime.setControleur(controleur);
		
		/*ControleurAnime controleur = ControleurAnime.getInstance();
		controleur.activerVues(this);*/
		
	}
	
	public VueAjouterAnime getVueAjouterAnime() {
		return vueAjouterAnime;
	}

	public void naviguerVersVueAjouterAnime( ){
		stade.setScene(this.vueAjouterAnime);
		stade.show();
	}

	public VueListeAnime getVueListeAnime() {
		return vueListeAnime;
	}

	public void naviguerVersVueListeAnime() {
		stade.setScene(this.vueListeAnime);
		stade.show();
	}

	public VueAnime getVueAnime() {
		return vueAnime;
	}

	public void naviguerVersVueAnime() {
		stade.setScene(this.vueAnime);
		stade.show();
	}
	
	public VueEditerAnime getVueEditerAnime() {
		return vueEditerAnime;
	}
	
	public void naviguerVersVueEditerAnime() {
		stade.setScene(this.vueEditerAnime);
		stade.show();
	}
	
	
}
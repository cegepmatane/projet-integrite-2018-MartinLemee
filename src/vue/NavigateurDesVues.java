package vue;

import controleur.ControleurAnime;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private VueAjouterAnime vueAjouterAnime;
	private VueListeAnime vueListeAnime;
	private VueAnime vueAnime;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterAnime = new VueAjouterAnime();
		this.vueListeAnime = new VueListeAnime();
		this.vueAnime = new VueAnime();	
	}
	
	private Stage stade = null;
	
	@Override
	public void start(Stage stade) throws Exception {
		
		this.stade = stade;
		
		stade.setScene(this.vueAnime);
		stade.show();
		
		ControleurAnime controleur = ControleurAnime.getInstance();
		controleur.activerVues(this);
		
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
	
	
}
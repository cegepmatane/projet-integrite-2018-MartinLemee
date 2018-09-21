package vue;
import controleur.ControleurAnime;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Anime;

public class VueAnime extends Scene{

	protected Label valeurNom;
	//protected Label valeurStudio;
	protected Label valeurNbEpisode;
	protected Label valeurDiffusion;
	private ControleurAnime controleur = null;
	
	public VueAnime() {
		super(new Pane(),400,400);
		Pane panneau = (Pane) this.getRoot();	
		GridPane grilleAnime = new GridPane();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new Label("");
		grilleAnime.add(new Label("Nom : "), 0, 0);
		grilleAnime.add(valeurNom, 1, 0);
		
		/*valeurStudio = new Label("");
		grilleAnime.add(new Label("Studio : "), 0, 1);
		grilleAnime.add(valeurStudio, 1, 1);*/

		valeurNbEpisode = new Label("");
		grilleAnime.add(new Label("Nombres d'épisodes : "), 0, 1);
		grilleAnime.add(valeurNbEpisode, 1, 1);		

		valeurDiffusion = new Label("");
		grilleAnime.add(new Label("Diffusion : "), 0, 2);
		grilleAnime.add(valeurDiffusion, 1, 2);				
			
		panneau.getChildren().add(grilleAnime);		
	}
	
	public void afficherAnime(Anime anime)
	{
		this.valeurNom.setText(anime.getNom());
		//this.valeurStudio.setText(anime.getStudio());
		this.valeurNbEpisode.setText(anime.getNbEpisode());
		this.valeurDiffusion.setText(anime.getDiffusion());	
	}
	
	public void setControleur(ControleurAnime controleur) {
		this.controleur  = controleur;
	}

}
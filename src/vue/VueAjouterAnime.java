package vue;
import controleur.ControleurAnime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Anime;

public class VueAjouterAnime extends Scene {

	protected TextField valeurNom;
	//protected TextField valeurStudio;
	protected TextField valeurNbEpisode;
	protected TextField valeurDiffusion;
	
	private ControleurAnime controleur = null;
	protected Button actionEnregistrerAnime = null;
	
	public VueAjouterAnime()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleAnime = new GridPane();
		
		this.actionEnregistrerAnime = new Button("Enregistrer");
		
		this.actionEnregistrerAnime.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerNouvelAnime();
				
			}});
		

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleAnime.add(new Label("Nom : "), 0, 0);
		grilleAnime.add(valeurNom, 1, 0);
		
		/*valeurStudio = new TextField("");
		grilleAnime.add(new Label("Studio : "), 0, 1);
		grilleAnime.add(valeurStudio, 1, 1);*/

		valeurNbEpisode = new TextField("");
		grilleAnime.add(new Label("Nombres d'épisodes : "), 0, 2);
		grilleAnime.add(valeurNbEpisode, 1, 2);		

		valeurDiffusion = new TextField("");
		grilleAnime.add(new Label("Diffusion : "), 0, 3);
		grilleAnime.add(valeurDiffusion, 1, 3);				
			
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Ajouter un anime")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleAnime);
		panneau.getChildren().add(actionEnregistrerAnime);
	}
	
	public Anime demanderAnime()
	{
		Anime anime = new Anime(this.valeurNom.getText(), 
								this.valeurNbEpisode.getText(), 
								this.valeurDiffusion.getText());
		return anime;
	}
	
	public void setControleur(ControleurAnime controleur) {
		this.controleur = controleur;
	}

}
package vue;

import java.util.ArrayList;
import java.util.List;

import controleur.ControleurAnime;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Anime;
import modele.Studio;

public class VueEditerAnime extends Scene {

	protected TextField valeurNom;
	protected TextField valeurStudio;
	protected TextField valeurNbEpisode;
	protected TextField valeurDiffusion;
	
	private ControleurAnime controleur = null;
	protected Button actionEnregistrerAnime = null;
	
	GridPane grilleListeStudio = new GridPane();
	
	private int idAnime = 0;
	
	public VueEditerAnime() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleAnime = new GridPane();
		this.actionEnregistrerAnime = new Button("Enregistrer");
		
		this.actionEnregistrerAnime.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierEnregistrerAnime();
			}
			
		});
		
		valeurNom = new TextField();
		grilleAnime.add(new Label("Nom : "), 0, 0);
		grilleAnime.add(valeurNom, 1, 0);
		
		/*valeurStudio = new TextField();
		grilleAnime.add(new Label("Studio : "), 0, 1);
		grilleAnime.add(valeurStudio, 1, 1);*/
		
		valeurNbEpisode = new TextField();
		grilleAnime.add(new Label("Nombre d'épisodes : "), 0, 2);
		grilleAnime.add(valeurNbEpisode, 1, 2);
		
		valeurDiffusion = new TextField();
		grilleAnime.add(new Label("Diffusion : "), 0, 3);
		grilleAnime.add(valeurDiffusion, 1, 3);
		
		// Données de test
		
		List<Studio> listeStudio = new ArrayList<Studio>();
		Studio nom_studio;
		
		nom_studio = new Studio("Kinema Citrus", "Sentai Filmworks");
		listeStudio.add(nom_studio);
		
		this.afficherListeStudio(listeStudio);
		
		
		
		panneau.getChildren().add(new Label("Editer un anime"));
		panneau.getChildren().add(grilleAnime);
		panneau.getChildren().add(this.actionEnregistrerAnime);
		panneau.getChildren().add(grilleListeStudio);
	}
	
	public Anime demanderAnime() {
		
		Anime anime = new Anime(this.valeurNom.getText(),
				this.valeurNbEpisode.getText(),
				this.valeurDiffusion.getText());
		
		anime.setId(idAnime);
		return anime;
	}
	
	public void setControleur(ControleurAnime controleur) {
		this.controleur = controleur;
	}
	
	public void afficherAnime(Anime anime) {
		
		this.idAnime = anime.getId();
		this.valeurNom.setText(anime.getNom());
		//this.valeurStudio.setText(anime.getStudio());
		this.valeurNbEpisode.setText(anime.getNbEpisode());
		this.valeurDiffusion.setText(anime.getDiffusion());
		
	}
	
	public void afficherListeStudio(List<Studio> listeStudio) {
		int item = 0;
		
		for(Studio studio : listeStudio)
		{
			this.grilleListeStudio.add(new Label(studio.getStudio() + "   "), 0, item);
			this.grilleListeStudio.add(new Label(studio.getProducteurs() + " "), 1, item);
			this.grilleListeStudio.add(new Button("Éditer"), 2, item);
			this.grilleListeStudio.add(new Button("Effacer"), 3, item);
			item++;
		}
	}
	
	

}

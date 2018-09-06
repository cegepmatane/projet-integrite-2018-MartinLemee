package vue;
import java.util.ArrayList;
import java.util.List;

import controleur.ControleurAnime;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Anime;

public class VueListeAnime extends Scene {

	protected GridPane grilleAnime;
	private ControleurAnime controleur = null;
	
	public VueListeAnime() {
		super(new Pane(), 400,400);
		Pane panneau = (Pane) this.getRoot();
		grilleAnime = new GridPane();
		
		panneau.getChildren().add(grilleAnime);		
	}
	
	public void afficherListeAnime(List<Anime> listeAnime)
	{
		int numero = 0;
		this.grilleAnime.add(new Label("Nom"), 0, numero);
		this.grilleAnime.add(new Label("Studio"), 1, numero);			
		for(Anime anime : listeAnime)
		{
			numero++;
			this.grilleAnime.add(new Label(anime.getNom()), 0, numero);
			this.grilleAnime.add(new Label(anime.getStudio()), 1, numero);	
			this.grilleAnime.add(new Button("Editer"), 2, numero);
		}
	}
	
	public void setControleur(ControleurAnime controleur) {
		this.controleur = controleur;
	}

}
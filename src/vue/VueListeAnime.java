package vue;
import java.util.ArrayList;
import java.util.List;

import controleur.ControleurAnime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private Button actionNaviguerAjouterAnime;
	
	public VueListeAnime() {
		super(new GridPane(), 400,400);
		grilleAnime = (GridPane) this.getRoot();
		this.actionNaviguerAjouterAnime = new Button("Ajouter un anime");
		
	}
	
	public void afficherListeAnime(List<Anime> listeAnime)
	{
		int numero = 0;
		this.grilleAnime.add(new Label("Nom"), 0, numero);
		this.grilleAnime.add(new Label("Studio"), 1, numero);			
		for(Anime anime : listeAnime)
		{
			Button actionEditerAnime = new Button("Editer");
			actionEditerAnime.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					controleur.notifierNaviguerEditerAnime();
				}
			});
			numero++;
			this.grilleAnime.add(new Label(anime.getNom()), 0, numero);
			this.grilleAnime.add(new Label(anime.getStudio()), 1, numero);	
			this.grilleAnime.add(new Button("Editer"), 2, numero);
		} 
		
		this.actionNaviguerAjouterAnime.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerAjouterAnime();
			}
		});
		
		this.grilleAnime.add(this.actionNaviguerAjouterAnime, 1, ++numero);
	}
	
	public void setControleur(ControleurAnime controleur) {
		this.controleur = controleur;
	}

}
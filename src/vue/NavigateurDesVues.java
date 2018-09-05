package vue;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Anime;

public class NavigateurDesVues extends Application{
	
	private VueAjouterAnime vueAjouterAnime;
	private VueListeAnime vueListeAnime;
	private VueAnime vueAnime;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterAnime = new VueAjouterAnime();
		this.vueListeAnime = new VueListeAnime();
		this.vueAnime = new VueAnime();
		
		/// TEST ///
		List listeAnimeTest = new ArrayList<Anime>();
		listeAnimeTest.add(new Anime("Made in Abyss", "Kinema Citrus", "13", "Ete 2017"));
		listeAnimeTest.add(new Anime("A Silent Voice", "Kyoto Animation", "1", "Automne 2016"));
		listeAnimeTest.add(new Anime("Your Name", "CoMix Wave Films", "1", "Ete 2016"));
		listeAnimeTest.add(new Anime("Hyouka", "Kyoto Animation", "22", "Printemps 2012"));
		this.vueListeAnime.afficherListeAnime(listeAnimeTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		//// TEST ////
		Anime anime = new Anime("Made in Abyss", "Kinema Citrus", "13", "Ete 2017");
		this.vueAnime.afficherAnime(anime); // Appel de ma fonction avant de la programmer (pour tester à mesure)		
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueAnime);
		stade.show();
	}
	
}
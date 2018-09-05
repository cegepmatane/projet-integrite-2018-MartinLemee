package accesseur;

import java.util.ArrayList;
import java.util.List;

import modele.Anime;

public class AnimeDAO {

	public List<Anime> simulerListerAnime()
	{
		List listeAnimeTest = new ArrayList<Anime>();
		listeAnimeTest.add(new Anime("Made in Abyss", "Kinema Citrus", "13", "Ete 2017"));
		listeAnimeTest.add(new Anime("A Silent Voice", "Kyoto Animation", "1", "Automne 2016"));
		listeAnimeTest.add(new Anime("Your Name", "CoMix Wave Films", "1", "Ete 2016"));
		listeAnimeTest.add(new Anime("Hyouka", "Kyoto Animation", "22", "Printemps 2012"));
		return listeAnimeTest;
	}
	public List<Anime> listerAnime()
	{
		return this.simulerListerAnime();
	}
	
}

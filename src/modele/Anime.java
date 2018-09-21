package modele;

public class Anime {

	protected int id;
	protected String nom;
	//protected String studio;
	protected String nbEpisode;
	protected String diffusion;
	
	public Anime(String nom) {
		super();
		this.nom = nom;
	}
	/*public Anime(String nom, String studio) {
		super();
		this.nom = nom;
		this.studio = studio;
	}*/
	public Anime(String nom, String nbEpisode) {
		super();
		this.nom = nom;
		this.nbEpisode = nbEpisode;
	}
	public Anime(String nom, String nbEpisode, String diffusion) {
		super();
		this.nom = nom;
		this.nbEpisode = nbEpisode;
		this.diffusion = diffusion;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNbEpisode() {
		return nbEpisode;
	}
	public void setNbEpisode(String nbEpisode) {
		this.nbEpisode = nbEpisode;
	}
	public String getDiffusion() {
		return diffusion;
	}
	public void setDiffusion(String diffusion) {
		this.diffusion = diffusion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
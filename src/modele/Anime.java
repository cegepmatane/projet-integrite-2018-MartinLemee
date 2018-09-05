package modele;

public class Anime {

	protected String nom;
	protected String studio;
	protected String nbEpisode;
	protected String diffusion;
	
	public Anime(String nom) {
		super();
		this.nom = nom;
	}
	public Anime(String nom, String studio) {
		super();
		this.nom = nom;
		this.studio = studio;
	}
	public Anime(String nom, String studio, String nbEpisode) {
		super();
		this.nom = nom;
		this.studio = studio;
		this.nbEpisode = nbEpisode;
	}
	public Anime(String nom, String studio, String nbEpisode, String diffusion) {
		super();
		this.nom = nom;
		this.studio = studio;
		this.nbEpisode = nbEpisode;
		this.diffusion = diffusion;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
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
	
}
package donnee;

public interface AnimeSQL {
	
	public static final String SQL_AJOUTER_ANIME = "INSERT into Anime(nom, nbEpisode, diffusion) VALUES(?,?,?)";
	public static final String SQL_RAPPORTER_ANIME = "SELECT * FROM anime WHERE id = ?";
	public static final String SQL_MODIFIER_ANIME = "UPDATE anime SET nom = ? , nbEpisode = ?, diffusion = ? WHERE id = ?";
	public static final String SQL_LISTER_ANIME = "SELECT * FROM anime";
	
}

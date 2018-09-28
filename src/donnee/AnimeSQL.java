package donnee;

public interface AnimeSQL {
	
	String SQL_AJOUTER_ANIME = "INSERT into Anime(nom, nbEpisode, diffusion) VALUES(?,?,?)";
	String SQL_RAPPORTER_ANIME = "SELECT * FROM anime WHERE id = ?";
	String SQL_MODIFIER_ANIME = "UPDATE anime SET nom = ? , nbEpisode = ?, diffusion = ? WHERE id = ?";
	String SQL_LISTER_ANIME = "SELECT * FROM anime";
	
}

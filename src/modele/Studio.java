package modele;

public class Studio {
	
	protected int id;
	protected String studio;
	protected String producteurs;
	
	
	public Studio(String studio, String producteurs) {
		super();
		this.producteurs = producteurs;
		this.studio = studio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStudio() {
		return studio;
	}
	
	public void setStudio(String studio) {
		this.studio = studio;
	}
	
	public String getProducteurs() {
		return producteurs;
	}
	
	public void setProducteurs(String producteurs) {
		this.producteurs = producteurs;
	}
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	protected String detail;

}

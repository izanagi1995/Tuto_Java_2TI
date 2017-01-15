package info.izanagi1995.tuto2ti.bibliotheque;

import java.util.Arrays;

public class Livre {
	private String titre;
	private String auteur;
	private int annee;
	private String[] pages;
	
	public Livre(String titre, String auteur, int annee) {
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setAnnee(annee);
		String[] pages = new String[100];
		this.setPages(pages);
	}
	
	
	public Livre(String titre, String auteur, int annee, String[] pages) {
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setAnnee(annee);
		this.setPages(pages);
	}


	/**
	 * @return Le titre du livre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * Permet de changer le titre du livre. Si aucun titre n'est fourni, alors enregistre "Titre inconnu"
	 * @param titre - Le titre du livre
	 */
	public void setTitre(String titre) {
		if(titre.equals("")){
			this.titre = "Titre inconnu";
		}else{
			this.titre = titre;
		}
	}
	/**
	 * @return L'auteur du livre
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur - L'auteur du livre
	 */
	public void setAuteur(String auteur) {
		if(auteur.equals("")){
			this.auteur = "Auteur inconnu";
		}else{
			this.auteur = auteur;
		}
	}
	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}
	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	/**
	 * @return the pages
	 */
	public String[] getPages() {
		return pages;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(String[] pages) {
		this.pages = pages;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + Arrays.hashCode(pages);
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;								//Livre livre2 = livre1;
		if (obj == null)
			return false;							
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		if (annee != other.annee)
			return false;
			
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (!Arrays.equals(pages, other.pages))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	
	public String getPage(int i){
		if(i <= 0 || i > this.pages.length){
			return null;
		}else{
			return this.pages[i-1];
		}
	}
	
	public String setPage(int i, String p) throws IllegalArgumentException{
		if(i <= 0 || i > this.pages.length){
			throw new IllegalArgumentException("Le numéro de page est invalide");
		}else{
			String old = this.pages[i-1];
			this.pages[i-1] = p;
			return old;
		}
	}
	
	
	
}

package com.aidenoo.data.model;

public class Competences {
	private String sfid;
	private String libelle;
		
	public Competences(String sfid, String libelle) {
		super();
		this.sfid = sfid;
		this.libelle = libelle;
	}
	
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sfid == null) ? 0 : sfid.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competences other = (Competences) obj;
		if (sfid == null) {
			if (other.sfid != null)
				return false;
		} else if (!sfid.equals(other.sfid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("competences [sfid=%s, libelle=%s]", sfid, libelle);
	}

}

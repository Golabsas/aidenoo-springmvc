package com.aidenoo.data.Sfamserv;

import javax.validation.constraints.Size;

public class Sfamserv {
	private String idsociete;

	@Size(min = 1, max = 2, message = "Entre 1 et 2 caracteres")
	private String sfam;

	@Size(min = 5, max = 100, message = "Entre 5 et 100 caracteres")
	private String libelle;

	public Sfamserv() {
		super();
	}

	public Sfamserv(String idsociete, String type, String libelle) {
		this();
		this.idsociete = idsociete;
		this.sfam = type;
		this.libelle = libelle;
	}

	public String getIdsociete() {
		return idsociete;
	}

	public void setIdsociete(String idsociete) {
		this.idsociete = idsociete;
	}

	public String getSfam() {
		return sfam;
	}

	public void setSfam(String sfam) {
		this.sfam = sfam;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return String.format("Famserv [idsociete=%s, sfam=%s, libelle=%s]", idsociete, sfam, libelle);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idsociete == null) ? 0 : idsociete.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((sfam == null) ? 0 : sfam.hashCode());
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
		Sfamserv other = (Sfamserv) obj;
		if (idsociete == null) {
			if (other.idsociete != null)
				return false;
		} else if (!idsociete.equals(other.idsociete))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (sfam == null) {
			if (other.sfam != null)
				return false;
		} else if (!sfam.equals(other.sfam))
			return false;
		return true;
	}
	
	
}

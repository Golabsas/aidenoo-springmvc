package com.aidenoo.data.Famserv;

import javax.validation.constraints.Size;

public class Famserv {
	private String idsociete;

	@Size(min = 1, max = 2, message = "Entre 1 et 2 caracteres")
	private String type;

	@Size(min = 5, max = 50, message = "Entre 5 et 50 caracteres")
	private String libelle;

	public Famserv() {
		super();
	}

	public Famserv(String idsociete, String type, String libelle) {
		this();
		this.idsociete = idsociete;
		this.type = type;
		this.libelle = libelle;
	}

	public String getIdsociete() {
		return idsociete;
	}

	public void setIdsociete(String idsociete) {
		this.idsociete = idsociete;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return String.format("Famserv [idsociete=%s, type=%s, libelle=%s]", idsociete, type, libelle);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idsociete == null) ? 0 : idsociete.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Famserv other = (Famserv) obj;
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}

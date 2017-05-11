package com.aidenoo.data.model;

import java.util.Arrays;

public class Sfamserv {
	private Character[] sfam;
	private String libelle;

	public Sfamserv(Character[] sfam, String libelle) {
		super();
		this.sfam = sfam;
		this.libelle = libelle;
	}

	public Character[] getSfam() {
		return sfam;
	}

	public void setSfam(Character[] sfam) {
		this.sfam = sfam;
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
		result = prime * result + Arrays.hashCode(sfam);
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
		if (!Arrays.equals(sfam, other.sfam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Sfamserv [sfam=%s, libelle=%s]", Arrays.toString(sfam), libelle);
	}

}

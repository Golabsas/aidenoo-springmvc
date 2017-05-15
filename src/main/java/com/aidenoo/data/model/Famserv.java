package com.aidenoo.data.model;

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
}

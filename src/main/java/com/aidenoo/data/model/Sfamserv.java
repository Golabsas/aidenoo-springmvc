package com.aidenoo.data.model;

import java.util.Arrays;

import javax.validation.constraints.Size;

public class Sfamserv {
	private String idsociete;

	@Size(min = 2, max = 2, message = "Entrez 2 caracteres")
	private String sfam;

	@Size(min = 5, max = 100, message = "Entre 5 et 100 caracteres")
	private String libelle;

	public Sfamserv() {
		super();
	}

	public Sfamserv(String idsociete, String sfam, String libelle) {
		this();
		this.idsociete = idsociete;
		this.sfam = sfam;
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
		return String.format("Sfamserv [idsociete=%s, sfam=%s, libelle=%s]", idsociete, sfam, libelle);
	}

}

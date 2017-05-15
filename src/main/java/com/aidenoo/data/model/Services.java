package com.aidenoo.data.model;

import javax.validation.constraints.Size;

public class Services {
	@Size(min = 4, max = 4, message = "Entre 4 et 4 caracteres")
	private String type;

	@Size(min = 1, max = 3, message = "Entre 1 et 3 caracteres")
	private String groupetarif;

	@Size(min = 5, max = 50, message = "Entre 5 et 50 caracteres")
	private String libelle;

	@Size(min = 1, max = 1, message = "Entrez 1 seul chiffre")
	private Integer specialisation;

	private String idsociete;

	public Services() {
		super();
	}

	public Services(String type, String groupetarif, String libelle, Integer specialisation, String idsociete) {
		this();
		this.type = type;
		this.groupetarif = groupetarif;
		this.libelle = libelle;
		this.specialisation = specialisation;
		this.idsociete = idsociete;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupetarif() {
		return groupetarif;
	}

	public void setGroupetarif(String groupetarif) {
		this.groupetarif = groupetarif;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Integer specialisation) {
		this.specialisation = specialisation;
	}

	public String getIdsociete() {
		return idsociete;
	}

	public void setIdsociete(String idsociete) {
		this.idsociete = idsociete;
	}

	@Override
	public String toString() {
		return String.format("Services [type=%s, groupetarif=%s, libelle=%s, specialisation=%s, idsociete=%s]", type,
				groupetarif, libelle, specialisation, idsociete);
	}

}

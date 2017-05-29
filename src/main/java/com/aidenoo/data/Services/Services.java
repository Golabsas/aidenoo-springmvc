package com.aidenoo.data.Services;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Services {
	private String idsociete;

	@Size(min = 4, max = 4, message = "Entre 4 et 4 caracteres")
	private String type;

	@Size(min = 1, max = 3, message = "Entre 1 et 3 caracteres")
	private String groupetarif;

	@Size(min = 5, max = 50, message = "Entre 5 et 50 caracteres")
	private String libelle;

	@NotNull
	@Range(min=0, max=9, message = "Entrer un seul chiffre")	
	private Integer specialisation;

	public Services() {
		super();
	}

	public Services(String idsociete, String type, String groupetarif, String libelle, Integer specialisation) {
		this();
		this.idsociete = idsociete;
		this.type = type;
		this.groupetarif = groupetarif;
		this.libelle = libelle;
		this.specialisation = specialisation;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Services other = (Services) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Services [idsociete=%s, type=%s, groupetarif=%s, libelle=%s, specialisation=%s]",
				idsociete, type, groupetarif, libelle, specialisation);
	}

}
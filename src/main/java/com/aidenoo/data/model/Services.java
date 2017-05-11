package com.aidenoo.data.model;

public class Services {
	private String type;
	private String groupetarif;
	private String libelle;
	private Integer specialisation;

	public Services(String type, String groupetarif, String libelle, Integer specialisation) {
		super();
		this.type = type;
		this.groupetarif = groupetarif;
		this.libelle = libelle;
		this.specialisation = specialisation;
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
		return String.format("Services [type=%s, groupetarif=%s, libelle=%s, specialisation=%s]", type, groupetarif,
				libelle, specialisation);
	}

}

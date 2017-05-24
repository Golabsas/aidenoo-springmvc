package com.aidenoo.data.grouptarifs;

public class Grouptarifs {
	private String idsociete;
	private String groupe;
	private String libelle;
	private Float tarifjour;
	private Float tarifnuit;
	private Float tarifjdf;
	private Float tarifndf;
	private Float tarifmj;
	private Float tarifmn;
	private Float tarifmjdf;
	private Float tarifmndf;
	private Integer specialisation;

	public Grouptarifs() {
		super();
	}

	public Grouptarifs(String idsociete, String groupe, String libelle, Float tarifjour, Float tarifnuit,
			Float tarifjdf, Float tarifndf, Float tarifmj, Float tarifmn, Float tarifmjdf, Float tarifmndf,
			Integer specialisation) {
		this();
		this.idsociete = idsociete;
		this.groupe = groupe;
		this.libelle = libelle;
		this.tarifjour = tarifjour;
		this.tarifnuit = tarifnuit;
		this.tarifjdf = tarifjdf;
		this.tarifndf = tarifndf;
		this.tarifmj = tarifmj;
		this.tarifmn = tarifmn;
		this.tarifmjdf = tarifmjdf;
		this.tarifmndf = tarifmndf;
		this.specialisation = specialisation;
	}

	public String getIdsociete() {
		return idsociete;
	}

	public void setIdsociete(String idsociete) {
		this.idsociete = idsociete;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getTarifjour() {
		return tarifjour;
	}

	public void setTarifjour(Float tarifjour) {
		this.tarifjour = tarifjour;
	}

	public Float getTarifnuit() {
		return tarifnuit;
	}

	public void setTarifnuit(Float tarifnuit) {
		this.tarifnuit = tarifnuit;
	}

	public Float getTarifjdf() {
		return tarifjdf;
	}

	public void setTarifjdf(Float tarifjdf) {
		this.tarifjdf = tarifjdf;
	}

	public Float getTarifndf() {
		return tarifndf;
	}

	public void setTarifndf(Float tarifndf) {
		this.tarifndf = tarifndf;
	}

	public Float getTarifmj() {
		return tarifmj;
	}

	public void setTarifmj(Float tarifmj) {
		this.tarifmj = tarifmj;
	}

	public Float getTarifmn() {
		return tarifmn;
	}

	public void setTarifmn(Float tarifmn) {
		this.tarifmn = tarifmn;
	}

	public Float getTarifmjdf() {
		return tarifmjdf;
	}

	public void setTarifmjdf(Float tarifmjdf) {
		this.tarifmjdf = tarifmjdf;
	}

	public Float getTarifmndf() {
		return tarifmndf;
	}

	public void setTarifmndf(Float tarifmndf) {
		this.tarifmndf = tarifmndf;
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
		result = prime * result + ((groupe == null) ? 0 : groupe.hashCode());
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
		Grouptarifs other = (Grouptarifs) obj;
		if (groupe == null) {
			if (other.groupe != null)
				return false;
		} else if (!groupe.equals(other.groupe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Grouptarifs [idsociete=%s, groupe=%s, libelle=%s, tarifjour=%s, tarifnuit=%s, tarifjdf=%s, tarifndf=%s, tarifmj=%s, tarifmn=%s, tarifmjdf=%s, tarifmndf=%s, specialisation=%s]",
				idsociete, groupe, libelle, tarifjour, tarifnuit, tarifjdf, tarifndf, tarifmj, tarifmn, tarifmjdf,
				tarifmndf, specialisation);
	}

}
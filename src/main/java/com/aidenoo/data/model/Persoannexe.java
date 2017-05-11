package com.aidenoo.data.model;

public class Persoannexe {
	private String id;
	private String referent;
	private String prenom;
	private String num_rue;
	private String rue;
	private String compl_rue;
	private String codepost;
	private String ville;
	private String portable;
	private String email;
	private Integer lienparente;
	private String observations;

	public Persoannexe(String id, String referent, String prenom, String num_rue, String rue, String compl_rue,
			String codepost, String ville, String portable, String email, Integer lienparente, String observations) {
		super();
		this.id = id;
		this.referent = referent;
		this.prenom = prenom;
		this.num_rue = num_rue;
		this.rue = rue;
		this.compl_rue = compl_rue;
		this.codepost = codepost;
		this.ville = ville;
		this.portable = portable;
		this.email = email;
		this.lienparente = lienparente;
		this.observations = observations;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReferent() {
		return referent;
	}

	public void setReferent(String referent) {
		this.referent = referent;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNum_rue() {
		return num_rue;
	}

	public void setNum_rue(String num_rue) {
		this.num_rue = num_rue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCompl_rue() {
		return compl_rue;
	}

	public void setCompl_rue(String compl_rue) {
		this.compl_rue = compl_rue;
	}

	public String getCodepost() {
		return codepost;
	}

	public void setCodepost(String codepost) {
		this.codepost = codepost;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPortable() {
		return portable;
	}

	public void setPortable(String portable) {
		this.portable = portable;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLienparente() {
		return lienparente;
	}

	public void setLienparente(Integer lienparente) {
		this.lienparente = lienparente;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Persoannexe other = (Persoannexe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Persoannexe [id=%s, referent=%s, prenom=%s, num_rue=%s, rue=%s, compl_rue=%s, codepost=%s, ville=%s, portable=%s, email=%s, lienparente=%s, observations=%s]",
				id, referent, prenom, num_rue, rue, compl_rue, codepost, ville, portable, email, lienparente,
				observations);
	}

}

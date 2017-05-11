package com.aidenoo.data.model;

public class Personnel {
	private String id;
	private String nom;
	private String prenom;
	private String num_rue;
	private String rue;
	private String compl_rue;
	private String codepost;
	private String ville;
	private String pays;
	private String localisation;
	private String portable;
	private String email;
	private String nationalite;
	private String num_ss;
	private Integer age;
	private String garde;
	private String diplomes;
	private String competences;
	private String observations;
	private Integer specialisation;

	public Personnel(String id, String nom, String prenom, String num_rue, String rue, String compl_rue,
			String codepost, String ville, String pays, String localisation, String portable, String email,
			String nationalite, String num_ss, Integer age, String garde, String diplomes, String competences,
			String observations, Integer specialisation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.num_rue = num_rue;
		this.rue = rue;
		this.compl_rue = compl_rue;
		this.codepost = codepost;
		this.ville = ville;
		this.pays = pays;
		this.localisation = localisation;
		this.portable = portable;
		this.email = email;
		this.nationalite = nationalite;
		this.num_ss = num_ss;
		this.age = age;
		this.garde = garde;
		this.diplomes = diplomes;
		this.competences = competences;
		this.observations = observations;
		this.specialisation = specialisation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNum_ss() {
		return num_ss;
	}

	public void setNum_ss(String num_ss) {
		this.num_ss = num_ss;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGarde() {
		return garde;
	}

	public void setGarde(String garde) {
		this.garde = garde;
	}

	public String getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(String diplomes) {
		this.diplomes = diplomes;
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
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
		Personnel other = (Personnel) obj;
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
				"Personnel [id=%s, nom=%s, prenom=%s, num_rue=%s, rue=%s, compl_rue=%s, codepost=%s, ville=%s, pays=%s, localisation=%s, portable=%s, email=%s, nationalite=%s, num_ss=%s, age=%s, garde=%s, diplomes=%s, competences=%s, observations=%s, specialisation=%s]",
				id, nom, prenom, num_rue, rue, compl_rue, codepost, ville, pays, localisation, portable, email,
				nationalite, num_ss, age, garde, diplomes, competences, observations, specialisation);
	}

}

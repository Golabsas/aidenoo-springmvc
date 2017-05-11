package com.aidenoo.data.model;

import java.sql.Time;
import java.sql.Date;

public class Contacts {
	private String id;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private Date dtrdv;
	private Time heure;
	private String services;
	private String competences;
	private String diplome;
	private Integer age;
	private String num_rue;
	private String rue;
	private String compl_rue;
	private String codepost;
	private String ville;
	private String observations;

	public Contacts(String id, String nom, String prenom, String tel, String email, Date dtrdv, Time heure,
			String services, String competences, String diplome, Integer age, String num_rue, String rue,
			String compl_rue, String codepost, String ville, String observations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.dtrdv = dtrdv;
		this.heure = heure;
		this.services = services;
		this.competences = competences;
		this.diplome = diplome;
		this.age = age;
		this.num_rue = num_rue;
		this.rue = rue;
		this.compl_rue = compl_rue;
		this.codepost = codepost;
		this.ville = ville;
		this.observations = observations;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtrdv() {
		return dtrdv;
	}

	public void setDtrdv(Date dtrdv) {
		this.dtrdv = dtrdv;
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
		Contacts other = (Contacts) obj;
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
				"Contacts [id=%s, nom=%s, prenom=%s, tel=%s, email=%s, dtrdv=%s, heure=%s, services=%s, competences=%s, diplome=%s, age=%s, num_rue=%s, rue=%s, compl_rue=%s, codepost=%s, ville=%s, observations=%s]",
				id, nom, prenom, tel, email, dtrdv, heure, services, competences, diplome, age, num_rue, rue, compl_rue,
				codepost, ville, observations);
	}

}

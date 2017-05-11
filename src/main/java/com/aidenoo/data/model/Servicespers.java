package com.aidenoo.data.model;

public class Servicespers {
	private String idpers;
	private String typeserv;

	public Servicespers(String idpers, String typeserv) {
		super();
		this.idpers = idpers;
		this.typeserv = typeserv;
	}

	public String getIdpers() {
		return idpers;
	}

	public void setIdpers(String idpers) {
		this.idpers = idpers;
	}

	public String getTypeserv() {
		return typeserv;
	}

	public void setTypeserv(String typeserv) {
		this.typeserv = typeserv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpers == null) ? 0 : idpers.hashCode());
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
		Servicespers other = (Servicespers) obj;
		if (idpers == null) {
			if (other.idpers != null)
				return false;
		} else if (!idpers.equals(other.idpers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Servicespers [idpers=%s, typeserv=%s]", idpers, typeserv);
	}

}

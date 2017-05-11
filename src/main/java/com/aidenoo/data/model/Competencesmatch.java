package com.aidenoo.data.model;

public class Competencesmatch {
	private String sdif;
	private String service;

	public Competencesmatch(String sdif, String service) {
		super();
		this.sdif = sdif;
		this.service = service;
	}

	public String getSdif() {
		return sdif;
	}

	public void setSdif(String sdif) {
		this.sdif = sdif;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sdif == null) ? 0 : sdif.hashCode());
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
		Competencesmatch other = (Competencesmatch) obj;
		if (sdif == null) {
			if (other.sdif != null)
				return false;
		} else if (!sdif.equals(other.sdif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Competencesmatch [sdif=%s, service=%s]", sdif, service);
	}
}

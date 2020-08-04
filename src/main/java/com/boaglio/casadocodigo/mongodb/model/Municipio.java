package com.boaglio.casadocodigo.mongodb.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "municipios")
public class Municipio implements Serializable {
 
	private static final long serialVersionUID = -1353243463602337706L;

	@Id
	private String id;

	private String nome;

	private String uf;

	private String estado;
	
	private String capital;
	 
	private Loc loc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Loc getLoc() {
		return loc;
	}

	public void setLoc(Loc loc) {
		this.loc = loc;
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
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Municipios [id=" + id + ", nome=" + nome + ", uf=" + uf + ", estado=" + estado + ", capital=" + capital
				+ ", loc=" + loc + "]";
	}
 
}

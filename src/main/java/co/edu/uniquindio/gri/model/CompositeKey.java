package co.edu.uniquindio.gri.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * 
 */
@Embeddable
public class CompositeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "grupos_id") 
	private long grupos;

	@Column(name = "investigadores_id")
	private long investigadores;

	public CompositeKey(long grupos_id, long investigadores_id) {
		this.grupos = grupos_id;
		this.investigadores = investigadores_id;
	}

	public CompositeKey() {
		
	}
	
	public long getGrupo() {
		return grupos;
	}

	public void setGrupo(long grupo) {
		this.grupos = grupo;
	}

	public long getInvestigador() {
		return investigadores;
	}

	public void setInvestigador(long investigador) {
		this.investigadores = investigador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (grupos ^ (grupos >>> 32));
		result = prime * result + (int) (investigadores ^ (investigadores >>> 32));
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
		CompositeKey other = (CompositeKey) obj;
		if (grupos != other.grupos)
			return false;
		if (investigadores != other.investigadores)
			return false;
		return true;
	}
}

package co.edu.uniquindio.gri.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "RECONOCIMIENTOS_INVES")
@Table(name = "RECONOCIMIENTOS_INVES", schema = "gri")
public class ReconocimientosInvestigador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "anio")
	private long anio;

	@Column(name = "reconocimiento")
	private String reconocimiento;

	@Column(name = "entidad")
	private String entidad;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INVESTIGADORES_ID")
	private Investigador investigador;

	public ReconocimientosInvestigador(long id, long anio, String reconocimiento, String entidad,
			Investigador investigador) {

		this.id = id;
		this.anio = anio;
		this.reconocimiento = reconocimiento;
		this.entidad = entidad;
		this.investigador = investigador;

	}

	public ReconocimientosInvestigador() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAnio() {
		return anio;
	}

	public void setAnio(long anio) {
		this.anio = anio;
	}

	public String getReconocimiento() {
		return reconocimiento;
	}

	public void setReconocimiento(String reconocimiento) {
		this.reconocimiento = reconocimiento;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	@Override
	public String toString() {
		return "ReconocimientosInvestigador [id=" + id + ", anio=" + anio + ", reconocimiento=" + reconocimiento
				+ ", entidad=" + entidad + ", investigador=" + investigador + "]";
	}
	
	

}

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
import jakarta.persistence.Transient;

@Entity(name = "PRODUCCIONBIBLIOGRAFICA")
@Table(name = "BIBLIOGRAFICAS", schema = "gri")
public class ProduccionB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "IDENTIFICADOR", length = 400)
	private String identificador;

	@Column(name = "AUTORES", length = 2000)
	private String autores;

	@Column(name = "ANIO", length = 10)
	private String anio;

	@Column(name = "REFERENCIA", length = 4000)
	private String referencia;

	@Column(name = "REPETIDO", length = 20)
	private String repetido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TIPO_ID")
	private Tipo tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INVESTIGADORES_ID")
	private Investigador investigador;
	
	@Transient
	public boolean debeEliminarse;

	public ProduccionB(long id, String identificador, String autores, String anio, String referencia,
			Tipo tipo, String repetido, Investigador investigador) {
		this.id = id;
		this.identificador = identificador;
		this.autores = autores;
		this.anio = anio;
		this.referencia = referencia;
		this.tipo = tipo;
		this.repetido = repetido;
		this.investigador = investigador;
		this.debeEliminarse = false;
	}

	public ProduccionB() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getRepetido() {
		return repetido;
	}

	public void setRepetido(String repetido) {
		this.repetido = repetido;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public boolean debeEliminarse() {
		return debeEliminarse;
	}

	public void setDebeEliminarse(boolean debeEliminarse) {
		this.debeEliminarse = debeEliminarse;
	}

	@Override
	public String toString() {
		return "ProduccionB [id=" + id + ", identificador=" + identificador + ", autores=" + autores + ", anio=" + anio
				+ ", referencia=" + referencia + ", repetido=" + repetido + ", tipo=" + tipo + ", investigador="
				+ investigador + ", debeEliminarse=" + debeEliminarse + "]";
	}

	

}

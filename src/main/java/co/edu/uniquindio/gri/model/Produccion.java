package co.edu.uniquindio.gri.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity(name = "PRODUCCIONES")
@Table(name = "PRODUCCIONES", schema = "gri")
public class Produccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

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

	public Produccion(long id, String autores, String anio, String referencia, Tipo tipo, String repetido,
			 Investigador investigador) {
		this.id = id;
		this.autores = autores;
		this.anio = anio;
		this.referencia = referencia;
		this.tipo = tipo;
		this.investigador = investigador;
		this.debeEliminarse = false;
	}

	public Produccion() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Produccion [id=" + id + ", autores=" + autores + ", anio=" + anio + ", referencia=" + referencia
				+ ", repetido=" + repetido + ", tipo=" + tipo + ", investigador=" + investigador + ", debeEliminarse="
				+ debeEliminarse + "]";
	}

	

}

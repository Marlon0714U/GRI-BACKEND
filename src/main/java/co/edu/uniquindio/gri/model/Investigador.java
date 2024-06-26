package co.edu.uniquindio.gri.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

@Entity(name = "INVESTIGADORES")
@Table(name = "INVESTIGADORES", schema = "gri")
@ToString(exclude = {"pertenencia","idiomas","lineasInvestigacion", "producciones", "produccionesBibliograficas", "grupos"})
public class Investigador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "NOMBRE", length = 200)
	private String nombre;

	@Column(name = "CATEGORIA", length = 200)
	private String categoria;

	@Column(name = "SEXO", length = 50)
	private String sexo;

	@Column(name = "NIVELACADEMICO", length = 200)
	private String nivelAcademico;

	@Column(name = "PERTENENCIA", length = 50)
	private String pertenencia;

	@Column(name = "ORCID", length = 1200000)
	private String orcid;

	@OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Idiomas> idiomas = new ArrayList<Idiomas>();

	@OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ReconocimientosInvestigador> reconocimientos = new ArrayList<ReconocimientosInvestigador>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "INVEST_LINEAS", joinColumns = { @JoinColumn(name = "INVESTIGADORES_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "LINEASINVESTIGACION_ID") }, schema = "gri")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LineasInvestigacion> lineasInvestigacion = new ArrayList<LineasInvestigacion>();

	@OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Produccion> producciones = new ArrayList<Produccion>();

	@OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProduccionB> produccionesBibliograficas = new ArrayList<ProduccionB>();

	@OneToMany(mappedBy = "investigadores", cascade = CascadeType.ALL)
	private List<GruposInves> grupos = new ArrayList<GruposInves>();

	@Transient
	public String nombreInvestigadorAux;

	public Investigador(long id, String nombre, String categoria, String sexo, String nivelAcademico,
						String pertenencia, List<Idiomas> idiomas, List<ReconocimientosInvestigador> reconocimientos,
						List<LineasInvestigacion> lineasInvestigacion, List<Produccion> producciones,
						List<ProduccionB> produccionesBibliograficas, List<GruposInves> grupos) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.nivelAcademico = nivelAcademico;
		this.pertenencia = pertenencia;
		this.idiomas = idiomas;
		this.reconocimientos = reconocimientos;
		this.sexo = sexo;
		this.lineasInvestigacion = lineasInvestigacion;
		this.produccionesBibliograficas = produccionesBibliograficas;
		this.grupos = grupos;

	}



	@Override
	public String toString() {
		return "Investigador [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", sexo=" + sexo
				+ ", nivelAcademico=" + nivelAcademico + ", pertenencia=" + pertenencia + ", orcid=" + orcid
				+ ", idiomas=" + idiomas + ", reconocimientos=" + reconocimientos + ", lineasInvestigacion="
				+ lineasInvestigacion + ", producciones=" + producciones + ", produccionesBibliograficas="
				+ produccionesBibliograficas + ", grupos=" + grupos + ", nombreInvestigadorAux=" + nombreInvestigadorAux
				+ "]";
	}



	public Investigador() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<ReconocimientosInvestigador> getReconocimientos() {
		return reconocimientos;
	}

	public void setReconocimientos(List<ReconocimientosInvestigador> reconocimientos) {
		this.reconocimientos = reconocimientos;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String getPertenencia() {
		return pertenencia;
	}

	public void setPertenencia(String pertenencia) {
		this.pertenencia = pertenencia;
	}

	public List<Idiomas> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idiomas> idiomas) {
		this.idiomas = idiomas;
	}

	public List<Produccion> getProducciones() {
		return producciones;
	}

	public void setProducciones(List<Produccion> producciones) {
		this.producciones = producciones;
	}

	public List<ProduccionB> getProduccionesBibliograficas() {
		return produccionesBibliograficas;
	}

	public void setProduccionesBibliograficas(List<ProduccionB> produccionesBibliograficas) {
		this.produccionesBibliograficas = produccionesBibliograficas;
	}

	public List<LineasInvestigacion> getLineasInvestigacion() {
		return lineasInvestigacion;
	}

	public void setLineasInvestigacion(List<LineasInvestigacion> lineasInvestigacion) {
		this.lineasInvestigacion = lineasInvestigacion;
	}

	public List<GruposInves> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GruposInves> grupos) {
		this.grupos = grupos;
	}

	public String getNombreInvestigadorAux() {
		return nombreInvestigadorAux;
	}

	public void setNombreInvestigadorAux(String nombreInvestigadorAux) {
		this.nombreInvestigadorAux = nombreInvestigadorAux;
	}

	public void removeLineasInvestigacion(LineasInvestigacion lineas) {
		lineasInvestigacion.remove(lineas);
		lineas.getInvestigadores().remove(this);
	}

	public String getOrcid() {
		return orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}



}

package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type_site")
//@org.hibernate.annotations.DiscriminatorOptions(force=true)
public class Site implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSite;
	
	private String nomSite;
	
	private String type_site;
	
	@OneToMany(mappedBy="site")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Secteur> secteurs;
	
	@OneToMany(mappedBy="site", fetch=FetchType.EAGER)
	private List<Facteur> facteursLibres;
	
	@ManyToOne
	private Region region;
	
	
	public Site() {
		super();
	}

	public Site(List<Secteur> secteurs, Region region) {
		super();
		this.secteurs = secteurs;
		this.region = region;
	}

	public int getIdSite() {
		return idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	
	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getType_site() {
		return type_site;
	}

	public void setType_site(String type_site) {
		this.type_site = type_site;
	}
	
	public List<Facteur> getFacteursLibres() {
		return facteursLibres;
	}

	public void setFacteursLibres(List<Facteur> facteursLibres) {
		this.facteursLibres = facteursLibres;
	}

	@Override
	public String toString() {
		return "Site [idSite=" + idSite + ", nomSite=" + nomSite + ", secteurs=" + secteurs + ", region=" + region
				+ "]";
	}
	
}

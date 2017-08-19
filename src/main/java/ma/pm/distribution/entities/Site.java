package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_site")
abstract public class Site implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSite;
	
	private String nomSite;
	
	@OneToMany(mappedBy="site")
	private List<Secteur> secteurs;
	
	
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
}

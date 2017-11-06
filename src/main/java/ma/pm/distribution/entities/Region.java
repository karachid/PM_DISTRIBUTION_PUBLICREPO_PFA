package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Region implements Serializable{
			
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idR;
	
	private String nomRegion;
	
	@OneToMany(mappedBy="region")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Site> sites;
	
	@ManyToOne
	private DRAP drap;

	public Region() {
		super();
	}

	public Region(String nomRegion, List<Site> sites, DRAP drap) {
		super();
		this.nomRegion = nomRegion;
		this.sites = sites;
		this.drap = drap;
	}

	public int getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public DRAP getDrap() {
		return drap;
	}

	public void setDrap(DRAP drap) {
		this.drap = drap;
	}

	@Override
	public String toString() {
		return "Region [idR=" + idR + ", nomRegion=" + nomRegion + "]";
	}
	
}

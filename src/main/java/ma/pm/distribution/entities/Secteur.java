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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Secteur implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idS;
	
	@OneToMany(mappedBy="secteur", fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Tournee> tournees;
	
	@ManyToOne
	private Site site;
	
	private String codePostal;
	
	public Secteur() {
		super();
	}

	public Secteur(List<Tournee> tournees, Site site, String codePostal) {
		super();
		this.tournees = tournees;
		this.site = site;
		this.codePostal = codePostal;
	}

	public int getIdS() {
		return idS;
	}

	public void setIdS(int idS) {
		this.idS = idS;
	}

	public List<Tournee> getTournees() {
		return tournees;
	}

	public void setTournees(List<Tournee> tournees) {
		this.tournees = tournees;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Secteur [idS=" + idS + ", codePostal=" + codePostal + "]";
	}
	
}

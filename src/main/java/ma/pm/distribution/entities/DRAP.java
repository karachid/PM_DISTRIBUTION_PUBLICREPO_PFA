package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class DRAP implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDrap;
	
	private String drap;
	
	@OneToMany(mappedBy="drap")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Region> regions;
	
	public DRAP() {
		super();
	}

	public DRAP(String drap, List<Region> regions) {
		super();
		this.drap = drap;
		this.regions = regions;
	}

	public int getIdDrap() {
		return idDrap;
	}

	public void setIdDrap(int idDrap) {
		this.idDrap = idDrap;
	}

	public String getDrap() {
		return drap;
	}

	public void setDrap(String drap) {
		this.drap = drap;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "DRAP [idDrap=" + idDrap + ", drap=" + drap + ", regions=" + regions + "]";
	}
	
}

package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Affectation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idF;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnore
	private Facteur facteur;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnore
	private Tournee tournee;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateAffectation;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFinAffectation;
	
	private String observationAff;
	
	
	public Affectation() {}
	
	public Affectation(Tournee t, Facteur f) {
		this.tournee=t;
		this.facteur=f;
	}

	public Long getIdF() {
		return idF;
	}

	public void setIdF(Long idF) {
		this.idF = idF;
	}

	public Facteur getFacteur() {
		return facteur;
	}

	public void setFacteur(Facteur facteur) {
		this.facteur = facteur;
	}

	public Tournee getTournee() {
		return tournee;
	}

	public void setTournee(Tournee tournee) {
		this.tournee = tournee;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public Date getDateFinAffectation() {
		return dateFinAffectation;
	}

	public void setDateFinAffectation(Date dateFinAffectation) {
		this.dateFinAffectation = dateFinAffectation;
	}
	
	public String getObservationAff() {
		return observationAff;
	}

	public void setObservationAff(String observationAff) {
		this.observationAff = observationAff;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		 
        if (obj == null || getClass() != obj.getClass())
            return false;
 
        Affectation that = (Affectation) obj;
        return Objects.equals(facteur, that.facteur) &&
               Objects.equals(tournee, that.tournee);
	}
	
	
}

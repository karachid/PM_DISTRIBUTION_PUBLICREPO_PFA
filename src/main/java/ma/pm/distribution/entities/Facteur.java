package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class Facteur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idF;
	
	private int matricule;
	
	private String prenom;
	
	private String nom;
	
	private String sexe;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Temporal(TemporalType.DATE)
	private Date dateRecrutement;
	
	private String observationFacteur;
	
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JsonManagedReference
	private Tenue tenue;
	
	@OneToMany(mappedBy = "facteur")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Affectation> tournees;
	
	@ManyToOne
	@JsonIgnore
	private Site site;
	
	@OneToOne
	private MoyenLocomotion moyenLocomotion;
	
	public Facteur() {
		super();
	}

	public Facteur(int matricule, String prenom, String nom, String sexe, Date dateNaissance, Date dateRecrutement,
			String observationFacteur, Tenue tenue, List<Affectation> tournees) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.dateRecrutement = dateRecrutement;
		this.observationFacteur = observationFacteur;
		this.tenue = tenue;
		this.tournees = tournees;
	}

	public Long getIdF() {
		return idF;
	}

	public void setIdF(Long idF) {
		this.idF = idF;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}


	public Tenue getTenue() {
		return tenue;
	}

	public void setTenue(Tenue tenue) {
		this.tenue = tenue;
	}
	
	public MoyenLocomotion getMoyenLocomotionObj() {
		return moyenLocomotion;
	}

	public void setMoyenLocomotionObj(MoyenLocomotion moyenLocomotion) {
		this.moyenLocomotion = moyenLocomotion;
	}
	
	public List<Affectation> getTournees() {
		return tournees;
	}

	public void setTournees(List<Affectation> tournees) {
        this.tournees = tournees;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public MoyenLocomotion getMoyenLocomotion() {
		return moyenLocomotion;
	}

	public void setMoyenLocomotion(MoyenLocomotion moyenLocomotion) {
		this.moyenLocomotion = moyenLocomotion;
	}
	
	
	public String getObservationFacteur() {
		return observationFacteur;
	}

	public void setObservationFacteur(String observationFacteur) {
		this.observationFacteur = observationFacteur;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Facteur facteur = (Facteur) obj;
        return Objects.equals(idF, facteur.getIdF());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(idF);
    }

	@Override
	public String toString() {
		return "Facteur [idF=" + idF + ", matricule=" + matricule + ", prenom=" + prenom + ", nom=" + nom + ", sexe="
				+ sexe + ", dateNaissance=" + dateNaissance + ", dateRecrutement=" + dateRecrutement
				+ ", observationFacteur=" + observationFacteur + "]";
	}
	
}

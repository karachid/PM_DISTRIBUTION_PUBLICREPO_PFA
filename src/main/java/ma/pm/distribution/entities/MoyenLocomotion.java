package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_moyenlocomotion")
public abstract class MoyenLocomotion implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMl;
	
	private String numChassis;
	
	private String numMoteur;
	
	private String numImmatriculation;
	
	private Date dateCarteGrise;
	
	private Date datePremiereUtilisation;
	
	private int annee;
	
	private String statutCyclo;
	
	private String causeSiNonOperationnel;
	
	private String assure;
	
	private String couvertureProvisiore;
	
	private String refPoliceAssurance;
	
	private Date dateAffectation;
	
	private String observation;
	
	@OneToOne(mappedBy="moyenLocomotion")
	private Tournee tournee;
	
	@ManyToOne
	private Marque marque;
	
	@ManyToOne
	private Marque modele;

	public MoyenLocomotion() {
		super();
	}

	public MoyenLocomotion(int idMl, String numChassis, String numMoteur, String numImmatriculation,
			Date dateCarteGrise, Date datePremiereUtilisation, int annee, String statutCyclo,
			String causeSiNonOperationnel, String assure, String couvertureProvisiore, String refPoliceAssurance,
			Date dateAffectation, String observation, Tournee tournee, Marque marque, Marque modele) {
		super();
		this.idMl = idMl;
		this.numChassis = numChassis;
		this.numMoteur = numMoteur;
		this.numImmatriculation = numImmatriculation;
		this.dateCarteGrise = dateCarteGrise;
		this.datePremiereUtilisation = datePremiereUtilisation;
		this.annee = annee;
		this.statutCyclo = statutCyclo;
		this.causeSiNonOperationnel = causeSiNonOperationnel;
		this.assure = assure;
		this.couvertureProvisiore = couvertureProvisiore;
		this.refPoliceAssurance = refPoliceAssurance;
		this.dateAffectation = dateAffectation;
		this.observation = observation;
		this.tournee = tournee;
		this.marque = marque;
		this.modele = modele;
	}

	public int getIdMl() {
		return idMl;
	}

	public void setIdMl(int idMl) {
		this.idMl = idMl;
	}

	public String getNumChassis() {
		return numChassis;
	}

	public void setNumChassis(String numChassis) {
		this.numChassis = numChassis;
	}

	public String getNumMoteur() {
		return numMoteur;
	}

	public void setNumMoteur(String numMoteur) {
		this.numMoteur = numMoteur;
	}

	public String getNumImmatriculation() {
		return numImmatriculation;
	}

	public void setNumImmatriculation(String numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public Date getDateCarteGrise() {
		return dateCarteGrise;
	}

	public void setDateCarteGrise(Date dateCarteGrise) {
		this.dateCarteGrise = dateCarteGrise;
	}

	public Date getDatePremiereUtilisation() {
		return datePremiereUtilisation;
	}

	public void setDatePremiereUtilisation(Date datePremiereUtilisation) {
		this.datePremiereUtilisation = datePremiereUtilisation;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getStatutCyclo() {
		return statutCyclo;
	}

	public void setStatutCyclo(String statutCyclo) {
		this.statutCyclo = statutCyclo;
	}

	public String getCauseSiNonOperationnel() {
		return causeSiNonOperationnel;
	}

	public void setCauseSiNonOperationnel(String causeSiNonOperationnel) {
		this.causeSiNonOperationnel = causeSiNonOperationnel;
	}

	public String getAssure() {
		return assure;
	}

	public void setAssure(String assure) {
		this.assure = assure;
	}

	public String getCouvertureProvisiore() {
		return couvertureProvisiore;
	}

	public void setCouvertureProvisiore(String couvertureProvisiore) {
		this.couvertureProvisiore = couvertureProvisiore;
	}

	public String getRefPoliceAssurance() {
		return refPoliceAssurance;
	}

	public void setRefPoliceAssurance(String refPoliceAssurance) {
		this.refPoliceAssurance = refPoliceAssurance;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Tournee getTournee() {
		return tournee;
	}

	public void setTournee(Tournee tournee) {
		this.tournee = tournee;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Marque getModele() {
		return modele;
	}

	public void setModele(Marque modele) {
		this.modele = modele;
	}
	
}

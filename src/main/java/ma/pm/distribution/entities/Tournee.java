package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tournee implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idT;
	
	private String typeZone;
	
	private int numTournee;
	
	private Date dateCreationTournee;
	
	private String typeTournee;
	
	private String typeMoyenLocomotion;
	
	private int trajetTotal;
	
	private int montantMensuelIndemniteKm;
	
	private int frequenceDistributionHebdomadaire;
	
	private int frequenceDistributionJour;
	
	private String natureTournee;
	
	private String typeHabitatDominant;
	
	private String statutTournee;
	
	private int capaciteDistributionPIC;
	
	private int capaciteDistributionHorsPIC;
	
	private Date dateMaj;
	
	private String observation;
	
	@ManyToMany(mappedBy="tournees")
	private List<Facteur> facteurs;
	
	@ManyToOne
	private Secteur secteur;
	
	@OneToOne
	private MoyenLocomotion moyenLocomotion;

	public Tournee() {
		super();
	}

	public Tournee(String typeZone, int numTournee, Date dateCreationTournee, String typeTournee,
			String typeMoyenLocomotion, int trajetTotal, int montantMensuelIndemniteKm,
			int frequenceDistributionHebdomadaire, int frequenceDistributionJour, String natureTournee,
			String typeHabitatDominant, String statutTournee, int capaciteDistributionPIC,
			int capaciteDistributionHorsPIC, Date dateMaj, String observation, List<Facteur> facteurs,
			Secteur secteur) {
		super();
		this.typeZone = typeZone;
		this.numTournee = numTournee;
		this.dateCreationTournee = dateCreationTournee;
		this.typeTournee = typeTournee;
		this.typeMoyenLocomotion = typeMoyenLocomotion;
		this.trajetTotal = trajetTotal;
		this.montantMensuelIndemniteKm = montantMensuelIndemniteKm;
		this.frequenceDistributionHebdomadaire = frequenceDistributionHebdomadaire;
		this.frequenceDistributionJour = frequenceDistributionJour;
		this.natureTournee = natureTournee;
		this.typeHabitatDominant = typeHabitatDominant;
		this.statutTournee = statutTournee;
		this.capaciteDistributionPIC = capaciteDistributionPIC;
		this.capaciteDistributionHorsPIC = capaciteDistributionHorsPIC;
		this.dateMaj = dateMaj;
		this.observation = observation;
		this.facteurs = facteurs;
		this.secteur = secteur;
	}

	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}

	public String getTypeZone() {
		return typeZone;
	}

	public void setTypeZone(String typeZone) {
		this.typeZone = typeZone;
	}

	public int getNumTournee() {
		return numTournee;
	}

	public void setNumTournee(int numTournee) {
		this.numTournee = numTournee;
	}

	public Date getDateCreationTournee() {
		return dateCreationTournee;
	}

	public void setDateCreationTournee(Date dateCreationTournee) {
		this.dateCreationTournee = dateCreationTournee;
	}

	public String getTypeTournee() {
		return typeTournee;
	}

	public void setTypeTournee(String typeTournee) {
		this.typeTournee = typeTournee;
	}

	public String getMoyenLocomotion() {
		return typeMoyenLocomotion;
	}

	public void setMoyenLocomotion(String typeMoyenLocomotion) {
		this.typeMoyenLocomotion = typeMoyenLocomotion;
	}

	public int getTrajetTotal() {
		return trajetTotal;
	}

	public void setTrajetTotal(int trajetTotal) {
		this.trajetTotal = trajetTotal;
	}

	public int getMontantMensuelIndemniteKm() {
		return montantMensuelIndemniteKm;
	}

	public void setMontantMensuelIndemniteKm(int montantMensuelIndemniteKm) {
		this.montantMensuelIndemniteKm = montantMensuelIndemniteKm;
	}

	public int getFrequenceDistributionHebdomadaire() {
		return frequenceDistributionHebdomadaire;
	}

	public void setFrequenceDistributionHebdomadaire(int frequenceDistributionHebdomadaire) {
		this.frequenceDistributionHebdomadaire = frequenceDistributionHebdomadaire;
	}

	public int getFrequenceDistributionJour() {
		return frequenceDistributionJour;
	}

	public void setFrequenceDistributionJour(int frequenceDistributionJour) {
		this.frequenceDistributionJour = frequenceDistributionJour;
	}

	public String getNatureTournee() {
		return natureTournee;
	}

	public void setNatureTournee(String natureTournee) {
		this.natureTournee = natureTournee;
	}

	public String getTypeHabitatDominant() {
		return typeHabitatDominant;
	}

	public void setTypeHabitatDominant(String typeHabitatDominant) {
		this.typeHabitatDominant = typeHabitatDominant;
	}

	public String getStatutTournee() {
		return statutTournee;
	}

	public void setStatutTournee(String statutTournee) {
		this.statutTournee = statutTournee;
	}

	public int getCapaciteDistributionPIC() {
		return capaciteDistributionPIC;
	}

	public void setCapaciteDistributionPIC(int capaciteDistributionPIC) {
		this.capaciteDistributionPIC = capaciteDistributionPIC;
	}

	public int getCapaciteDistributionHorsPIC() {
		return capaciteDistributionHorsPIC;
	}

	public void setCapaciteDistributionHorsPIC(int capaciteDistributionHorsPIC) {
		this.capaciteDistributionHorsPIC = capaciteDistributionHorsPIC;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public List<Facteur> getFacteurs() {
		return facteurs;
	}

	public void setFacteurs(List<Facteur> facteurs) {
		this.facteurs = facteurs;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public MoyenLocomotion getMoyenLocomotionObj() {
		return moyenLocomotion;
	}

	public void setMoyenLocomotionObj(MoyenLocomotion moyenLocomotion) {
		this.moyenLocomotion = moyenLocomotion;
	}
	
}

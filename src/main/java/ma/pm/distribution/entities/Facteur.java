package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Facteur implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idF;
	
	private int matricule;
	
	private String prenom;
	
	private String nom;
	
	private String sexe;
	
	private Date dateNaissance;
	
	private Date dateRecrutement;
	
	private String observation;
	
	@OneToOne
	private Tenue tenue;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Affectation",joinColumns=@JoinColumn(name="IdF"), inverseJoinColumns=@JoinColumn(name="idT"))
	private List<Tournee> tournees;
	
	public Facteur() {
		super();
	}

	public Facteur(int matricule, String prenom, String nom, String sexe, Date dateNaissance, Date dateRecrutement,
			String observation, Tenue tenue, List<Tournee> tournees) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.dateRecrutement = dateRecrutement;
		this.observation = observation;
		this.tenue = tenue;
		this.tournees = tournees;
	}

	public int getIdF() {
		return idF;
	}

	public void setIdF(int idF) {
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

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Tenue getTenue() {
		return tenue;
	}

	public void setTenue(Tenue tenue) {
		this.tenue = tenue;
	}
/*
	public MoyenLocomotion getMoyenLocomotion() {
		return moyenLocomotion;
	}

	public void setMoyenLocomotion(MoyenLocomotion moyenLocomotion) {
		this.moyenLocomotion = moyenLocomotion;
	}
*/
	public List<Tournee> getTournees() {
		return tournees;
	}

	public void setTournees(List<Tournee> tournees) {
		this.tournees = tournees;
	}
	
}

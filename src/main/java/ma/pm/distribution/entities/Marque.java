package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Marque implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMrq;
	
	private String nomMarque;
	
	public Marque() {
		super();
	}

	public Marque(String nomMarque, List<MoyenLocomotion> moyensLocomotion) {
		super();
		this.nomMarque = nomMarque;
		this.moyensLocomotion = moyensLocomotion;
	}

	@OneToMany(mappedBy="marque")
	private List<MoyenLocomotion> moyensLocomotion;

	public int getIdMrq() {
		return idMrq;
	}

	public void setIdMrq(int idMrq) {
		this.idMrq = idMrq;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public List<MoyenLocomotion> getMoyensLocomotion() {
		return moyensLocomotion;
	}

	public void setMoyensLocomotion(List<MoyenLocomotion> moyensLocomotion) {
		this.moyensLocomotion = moyensLocomotion;
	}
	
}

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
public class Modele implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMdl;
	
	private String nomModele;
	
	@OneToMany(mappedBy="modele")
	private List<MoyenLocomotion> moyensLocomotion;
	
	public Modele() {
		super();
	}

	public Modele(String nomModele, List<MoyenLocomotion> moyensLocomotion) {
		super();
		this.nomModele = nomModele;
		this.moyensLocomotion = moyensLocomotion;
	}



	public int getIdMdl() {
		return idMdl;
	}

	public void setIdMdl(int idMdl) {
		this.idMdl = idMdl;
	}

	public String getNomModele() {
		return nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}

	public List<MoyenLocomotion> getMoyensLocomotion() {
		return moyensLocomotion;
	}

	public void setMoyensLocomotion(List<MoyenLocomotion> moyensLocomotion) {
		this.moyensLocomotion = moyensLocomotion;
	}
	
}

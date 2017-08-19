package ma.pm.distribution.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tenue implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idT;
	
	private String typeTenue;
	
	private int tailleVeste;
	
	private int taillePantalon;
	
	private int tailleChemiseML;
	
	private int tailleChemiseMC;
	
	private int tailleGilet;
	
	private int tailleParka;
	
	private int tailleCardigan;
	
	private int taillePullOver;
	
	private int tailleCasquette;
	
	private String observation;
	
	@OneToOne(mappedBy="tenue")
	private Facteur facteur;
	
	public Tenue() {
		super(); 
	}

	public Tenue(String typeTenue, int tailleVeste, int taillePantalon, int tailleChemiseML,
			int tailleChemiseMC, int tailleGilet, int tailleParka, int tailleCardigan, int taillePullOver,
			int tailleCasquette, String observation, Facteur facteur) {
		super();
		this.typeTenue = typeTenue;
		this.tailleVeste = tailleVeste;
		this.taillePantalon = taillePantalon;
		this.tailleChemiseML = tailleChemiseML;
		this.tailleChemiseMC = tailleChemiseMC;
		this.tailleGilet = tailleGilet;
		this.tailleParka = tailleParka;
		this.tailleCardigan = tailleCardigan;
		this.taillePullOver = taillePullOver;
		this.tailleCasquette = tailleCasquette;
		this.observation = observation;
		this.facteur = facteur;
	}

	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}

	public String getTypeTenue() {
		return typeTenue;
	}

	public void setTypeTenue(String typeTenue) {
		this.typeTenue = typeTenue;
	}

	public int getTailleVeste() {
		return tailleVeste;
	}

	public void setTailleVeste(int tailleVeste) {
		this.tailleVeste = tailleVeste;
	}

	public int getTaillePantalon() {
		return taillePantalon;
	}

	public void setTaillePantalon(int taillePantalon) {
		this.taillePantalon = taillePantalon;
	}

	public int getTailleChemiseML() {
		return tailleChemiseML;
	}

	public void setTailleChemiseML(int tailleChemiseML) {
		this.tailleChemiseML = tailleChemiseML;
	}

	public int getTailleChemiseMC() {
		return tailleChemiseMC;
	}

	public void setTailleChemiseMC(int tailleChemiseMC) {
		this.tailleChemiseMC = tailleChemiseMC;
	}

	public int getTailleGilet() {
		return tailleGilet;
	}

	public void setTailleGilet(int tailleGilet) {
		this.tailleGilet = tailleGilet;
	}

	public int getTailleParka() {
		return tailleParka;
	}

	public void setTailleParka(int tailleParka) {
		this.tailleParka = tailleParka;
	}

	public int getTailleCardigan() {
		return tailleCardigan;
	}

	public void setTailleCardigan(int tailleCardigan) {
		this.tailleCardigan = tailleCardigan;
	}

	public int getTaillePullOver() {
		return taillePullOver;
	}

	public void setTaillePullOver(int taillePullOver) {
		this.taillePullOver = taillePullOver;
	}

	public int getTailleCasquette() {
		return tailleCasquette;
	}

	public void setTailleCasquette(int tailleCasquette) {
		this.tailleCasquette = tailleCasquette;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Facteur getFacteur() {
		return facteur;
	}

	public void setFacteur(Facteur facteur) {
		this.facteur = facteur;
	}
	
}

package ma.pm.distribution.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Tenue implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idT;
	
	private String typeTenue;
	
	private int tailleVeste;
	
	private int taillePantalon;
	
	private int tailleChemiseML;
	
	private int tailleChemiseMC;
	
	private String tailleGilet;
	
	private String tailleParka;
	
	private String tailleCardigan;
	
	private String taillePullOver;
	
	private int tailleCasquette;
	
	private String observationTenue;
	
	
	@OneToOne(mappedBy="tenue")
	@JsonBackReference
	private Facteur facteur;
	
	
	public Tenue() {
		super(); 
	}

	public Tenue(String typeTenue, int tailleVeste, int taillePantalon, int tailleChemiseML,
			int tailleChemiseMC, String tailleGilet, String tailleParka, String tailleCardigan, String taillePullOver,
			int tailleCasquette, String observationTenue, Facteur facteur) {
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
		this.observationTenue = observationTenue;
		this.facteur = facteur;
	}

	public Long getIdT() {
		return idT;
	}

	public void setIdT(Long idT) {
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

	public String getTailleGilet() {
		return tailleGilet;
	}

	public void setTailleGilet(String tailleGilet) {
		this.tailleGilet = tailleGilet;
	}

	public String getTailleParka() {
		return tailleParka;
	}

	public void setTailleParka(String tailleParka) {
		this.tailleParka = tailleParka;
	}

	public String getTailleCardigan() {
		return tailleCardigan;
	}

	public void setTailleCardigan(String tailleCardigan) {
		this.tailleCardigan = tailleCardigan;
	}

	public String getTaillePullOver() {
		return taillePullOver;
	}

	public void setTaillePullOver(String taillePullOver) {
		this.taillePullOver = taillePullOver;
	}

	public int getTailleCasquette() {
		return tailleCasquette;
	}

	public void setTailleCasquette(int tailleCasquette) {
		this.tailleCasquette = tailleCasquette;
	}
	

	public String getObservationTenue() {
		return observationTenue;
	}

	public void setObservationTenue(String observationTenue) {
		this.observationTenue = observationTenue;
	}

	public Facteur getFacteur() {
		return facteur;
	}

	public void setFacteur(Facteur facteur) {
		this.facteur = facteur;
	}

	@Override
	public String toString() {
		return "Tenue [idT=" + idT + ", typeTenue=" + typeTenue + ", tailleVeste=" + tailleVeste + ", taillePantalon="
				+ taillePantalon + ", tailleChemiseML=" + tailleChemiseML + ", tailleChemiseMC=" + tailleChemiseMC
				+ ", tailleGilet=" + tailleGilet + ", tailleParka=" + tailleParka + ", tailleCardigan=" + tailleCardigan
				+ ", taillePullOver=" + taillePullOver + ", tailleCasquette=" + tailleCasquette + ", observationTenue="
				+ observationTenue + "]";
	}
	
}

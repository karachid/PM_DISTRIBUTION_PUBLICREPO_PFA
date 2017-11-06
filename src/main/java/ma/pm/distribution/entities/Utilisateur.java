package ma.pm.distribution.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type_utilisateur")
public class Utilisateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUser;
	
	private String login;
	
	private String password;
	
	private String nomDrap;
	
	private String nomRegion;
	
	private String nomSite;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String password, String nomDrap, String nomRegion, String nomSite) {
		super();
		this.login = login;
		this.password = password;
		this.nomDrap = nomDrap;
		this.nomRegion = nomRegion;
		this.nomSite = nomSite;
	}

	public String getNomDrap() {
		return nomDrap;
	}

	public void setNomDrap(String nomDrap) {
		this.nomDrap = nomDrap;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", login=" + login + ", password=" + password + ", nomDrap=" + nomDrap
				+ ", nomRegion=" + nomRegion + ", nomSite=" + nomSite + "]";
	}
	
}

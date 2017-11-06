package ma.pm.distribution.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AffectationId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="facteurId")
	private Long facteurId;
	
	@Column(name="tourneeId")
	private Long tourneeId;
	
	private AffectationId() {
	}
	
	public AffectationId(Long facteurId, Long tourneeId) {
		this.facteurId=facteurId;
		this.tourneeId=tourneeId;
	}

	public Long getFacteurId() {
		return facteurId;
	}

	public void setFacteurId(Long facteurId) {
		this.facteurId = facteurId;
	}

	public Long getTourneeId() {
		return tourneeId;
	}

	public void setTourneeId(Long tourneeId) {
		this.tourneeId = tourneeId;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if (this == obj) return true;
		 
	        if (obj == null || getClass() != obj.getClass()) 
	            return false;
	 
	        AffectationId that = (AffectationId) obj;
	        return Objects.equals(facteurId, that.facteurId) && Objects.equals(tourneeId, that.tourneeId);
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(facteurId, tourneeId);
    }
	
}

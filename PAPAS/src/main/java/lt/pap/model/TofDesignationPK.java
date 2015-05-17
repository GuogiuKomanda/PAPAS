package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tof_designations database table.
 * 
 */
@Embeddable
public class TofDesignationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DES_ID")
	private int desId;

	@Column(name="DES_LNG_ID")
	private short desLngId;

	public TofDesignationPK() {
	}
	public int getDesId() {
		return this.desId;
	}
	public void setDesId(int desId) {
		this.desId = desId;
	}
	public short getDesLngId() {
		return this.desLngId;
	}
	public void setDesLngId(short desLngId) {
		this.desLngId = desLngId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TofDesignationPK)) {
			return false;
		}
		TofDesignationPK castOther = (TofDesignationPK)other;
		return 
			(this.desId == castOther.desId)
			&& (this.desLngId == castOther.desLngId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.desId;
		hash = hash * prime + ((int) this.desLngId);
		
		return hash;
	}
}
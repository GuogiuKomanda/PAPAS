package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tof_country_designations database table.
 * 
 */
@Embeddable
public class TofCountryDesignationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CDS_ID")
	private int cdsId;

	@Column(name="CDS_CTM")
	private String cdsCtm;

	@Column(name="CDS_LNG_ID")
	private short cdsLngId;

	public TofCountryDesignationPK() {
	}
	public int getCdsId() {
		return this.cdsId;
	}
	public void setCdsId(int cdsId) {
		this.cdsId = cdsId;
	}
	public String getCdsCtm() {
		return this.cdsCtm;
	}
	public void setCdsCtm(String cdsCtm) {
		this.cdsCtm = cdsCtm;
	}
	public short getCdsLngId() {
		return this.cdsLngId;
	}
	public void setCdsLngId(short cdsLngId) {
		this.cdsLngId = cdsLngId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TofCountryDesignationPK)) {
			return false;
		}
		TofCountryDesignationPK castOther = (TofCountryDesignationPK)other;
		return 
			(this.cdsId == castOther.cdsId)
			&& this.cdsCtm.equals(castOther.cdsCtm)
			&& (this.cdsLngId == castOther.cdsLngId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdsId;
		hash = hash * prime + this.cdsCtm.hashCode();
		hash = hash * prime + ((int) this.cdsLngId);
		
		return hash;
	}
}
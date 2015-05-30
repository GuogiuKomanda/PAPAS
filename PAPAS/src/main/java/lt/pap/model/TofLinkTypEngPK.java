package lt.pap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the tof_link_typ_eng database table.
 * 
 */
@Embeddable
public class TofLinkTypEngPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="LTE_TYP_ID")
	private int lteTypId;

	@Column(name="LTE_NR")
	private short lteNr;

	@Column(name="LTE_ENG_ID")
	private int lteEngId;

	public TofLinkTypEngPK() {
	}
	public int getLteTypId() {
		return this.lteTypId;
	}
	public void setLteTypId(int lteTypId) {
		this.lteTypId = lteTypId;
	}
	public short getLteNr() {
		return this.lteNr;
	}
	public void setLteNr(short lteNr) {
		this.lteNr = lteNr;
	}
	public int getLteEngId() {
		return this.lteEngId;
	}
	public void setLteEngId(int lteEngId) {
		this.lteEngId = lteEngId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TofLinkTypEngPK)) {
			return false;
		}
		TofLinkTypEngPK castOther = (TofLinkTypEngPK)other;
		return 
			(this.lteTypId == castOther.lteTypId)
			&& (this.lteNr == castOther.lteNr)
			&& (this.lteEngId == castOther.lteEngId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.lteTypId;
		hash = hash * prime + ((int) this.lteNr);
		hash = hash * prime + this.lteEngId;
		
		return hash;
	}
}
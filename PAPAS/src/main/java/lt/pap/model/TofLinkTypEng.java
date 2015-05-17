package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tof_link_typ_eng database table.
 * 
 */
@Entity
@Table(name="tof_link_typ_eng")
@NamedQuery(name="TofLinkTypEng.findAll", query="SELECT t FROM TofLinkTypEng t")
public class TofLinkTypEng implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TofLinkTypEngPK id;

	@Column(name="LTE_CTM")
	private byte[] lteCtm;

	@Column(name="LTE_PCON_END")
	private int ltePconEnd;

	@Column(name="LTE_PCON_START")
	private int ltePconStart;

	public TofLinkTypEng() {
	}

	public TofLinkTypEngPK getId() {
		return this.id;
	}

	public void setId(TofLinkTypEngPK id) {
		this.id = id;
	}

	public byte[] getLteCtm() {
		return this.lteCtm;
	}

	public void setLteCtm(byte[] lteCtm) {
		this.lteCtm = lteCtm;
	}

	public int getLtePconEnd() {
		return this.ltePconEnd;
	}

	public void setLtePconEnd(int ltePconEnd) {
		this.ltePconEnd = ltePconEnd;
	}

	public int getLtePconStart() {
		return this.ltePconStart;
	}

	public void setLtePconStart(int ltePconStart) {
		this.ltePconStart = ltePconStart;
	}

}
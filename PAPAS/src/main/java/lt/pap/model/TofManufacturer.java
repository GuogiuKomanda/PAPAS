package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tof_manufacturers database table.
 * 
 */
@Entity
@Table(name="tof_manufacturers")
@NamedQuery(name="TofManufacturer.findAll", query="SELECT t FROM TofManufacturer t")
public class TofManufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MFA_ID")
	private short mfaId;

	@Column(name="MFA_AXL_MFC")
	private short mfaAxlMfc;

	@Column(name="MFA_BRAND")
	private String mfaBrand;

	@Column(name="MFA_CV_CTM")
	private byte[] mfaCvCtm;

	@Column(name="MFA_CV_MFC")
	private short mfaCvMfc;

	@Column(name="MFA_ENG_MFC")
	private short mfaEngMfc;

	@Column(name="MFA_ENG_TYP")
	private short mfaEngTyp;

	@Column(name="MFA_MF_NR")
	private int mfaMfNr;

	@Column(name="MFA_MFC_CODE")
	private String mfaMfcCode;

	@Column(name="MFA_PC_CTM")
	private byte[] mfaPcCtm;

	@Column(name="MFA_PC_MFC")
	private short mfaPcMfc;

	//bi-directional many-to-one association to TofModel
	@OneToMany(mappedBy="tofManufacturer")
	private List<TofModel> tofModels;

	public TofManufacturer() {
	}

	public short getMfaId() {
		return this.mfaId;
	}

	public void setMfaId(short mfaId) {
		this.mfaId = mfaId;
	}

	public short getMfaAxlMfc() {
		return this.mfaAxlMfc;
	}

	public void setMfaAxlMfc(short mfaAxlMfc) {
		this.mfaAxlMfc = mfaAxlMfc;
	}

	public String getMfaBrand() {
		return this.mfaBrand;
	}

	public void setMfaBrand(String mfaBrand) {
		this.mfaBrand = mfaBrand;
	}

	public byte[] getMfaCvCtm() {
		return this.mfaCvCtm;
	}

	public void setMfaCvCtm(byte[] mfaCvCtm) {
		this.mfaCvCtm = mfaCvCtm;
	}

	public short getMfaCvMfc() {
		return this.mfaCvMfc;
	}

	public void setMfaCvMfc(short mfaCvMfc) {
		this.mfaCvMfc = mfaCvMfc;
	}

	public short getMfaEngMfc() {
		return this.mfaEngMfc;
	}

	public void setMfaEngMfc(short mfaEngMfc) {
		this.mfaEngMfc = mfaEngMfc;
	}

	public short getMfaEngTyp() {
		return this.mfaEngTyp;
	}

	public void setMfaEngTyp(short mfaEngTyp) {
		this.mfaEngTyp = mfaEngTyp;
	}

	public int getMfaMfNr() {
		return this.mfaMfNr;
	}

	public void setMfaMfNr(int mfaMfNr) {
		this.mfaMfNr = mfaMfNr;
	}

	public String getMfaMfcCode() {
		return this.mfaMfcCode;
	}

	public void setMfaMfcCode(String mfaMfcCode) {
		this.mfaMfcCode = mfaMfcCode;
	}

	public byte[] getMfaPcCtm() {
		return this.mfaPcCtm;
	}

	public void setMfaPcCtm(byte[] mfaPcCtm) {
		this.mfaPcCtm = mfaPcCtm;
	}

	public short getMfaPcMfc() {
		return this.mfaPcMfc;
	}

	public void setMfaPcMfc(short mfaPcMfc) {
		this.mfaPcMfc = mfaPcMfc;
	}

	public List<TofModel> getTofModels() {
		return this.tofModels;
	}

	public void setTofModels(List<TofModel> tofModels) {
		this.tofModels = tofModels;
	}

	public TofModel addTofModel(TofModel tofModel) {
		getTofModels().add(tofModel);
		tofModel.setTofManufacturer(this);

		return tofModel;
	}

	public TofModel removeTofModel(TofModel tofModel) {
		getTofModels().remove(tofModel);
		tofModel.setTofManufacturer(null);

		return tofModel;
	}

}
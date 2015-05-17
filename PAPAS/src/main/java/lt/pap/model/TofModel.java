package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tof_models database table.
 * 
 */
@Entity
@Table(name="tof_models")
@NamedQuery(name="TofModel.findAll", query="SELECT t FROM TofModel t")
public class TofModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MOD_ID")
	private int modId;

	@Column(name="MOD_AXL")
	private short modAxl;

	@Column(name="MOD_CV")
	private short modCv;

	@Column(name="MOD_CV_CTM")
	private byte[] modCvCtm;

	@Column(name="MOD_PC")
	private short modPc;

	@Column(name="MOD_PC_CTM")
	private byte[] modPcCtm;

	@Column(name="MOD_PCON_END")
	private int modPconEnd;

	@Column(name="MOD_PCON_START")
	private int modPconStart;

	//bi-directional many-to-one association to TofCountryDesignation
	@OneToMany(mappedBy="tofModel")
	private List<TofCountryDesignation> tofCountryDesignations;

	//bi-directional many-to-one association to TofManufacturer
	@ManyToOne
	@JoinColumn(name="MOD_MFA_ID")
	private TofManufacturer tofManufacturer;

	//bi-directional many-to-one association to TofType
	@OneToMany(mappedBy="tofModel")
	private List<TofType> tofTypes;

	public TofModel() {
	}

	public int getModId() {
		return this.modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public short getModAxl() {
		return this.modAxl;
	}

	public void setModAxl(short modAxl) {
		this.modAxl = modAxl;
	}

	public short getModCv() {
		return this.modCv;
	}

	public void setModCv(short modCv) {
		this.modCv = modCv;
	}

	public byte[] getModCvCtm() {
		return this.modCvCtm;
	}

	public void setModCvCtm(byte[] modCvCtm) {
		this.modCvCtm = modCvCtm;
	}

	public short getModPc() {
		return this.modPc;
	}

	public void setModPc(short modPc) {
		this.modPc = modPc;
	}

	public byte[] getModPcCtm() {
		return this.modPcCtm;
	}

	public void setModPcCtm(byte[] modPcCtm) {
		this.modPcCtm = modPcCtm;
	}

	public int getModPconEnd() {
		return this.modPconEnd;
	}

	public void setModPconEnd(int modPconEnd) {
		this.modPconEnd = modPconEnd;
	}

	public int getModPconStart() {
		return this.modPconStart;
	}

	public void setModPconStart(int modPconStart) {
		this.modPconStart = modPconStart;
	}

	public List<TofCountryDesignation> getTofCountryDesignations() {
		return this.tofCountryDesignations;
	}

	public void setTofCountryDesignations(List<TofCountryDesignation> tofCountryDesignations) {
		this.tofCountryDesignations = tofCountryDesignations;
	}

	public TofCountryDesignation addTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
		getTofCountryDesignations().add(tofCountryDesignation);
		tofCountryDesignation.setTofModel(this);

		return tofCountryDesignation;
	}

	public TofCountryDesignation removeTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
		getTofCountryDesignations().remove(tofCountryDesignation);
		tofCountryDesignation.setTofModel(null);

		return tofCountryDesignation;
	}

	public TofManufacturer getTofManufacturer() {
		return this.tofManufacturer;
	}

	public void setTofManufacturer(TofManufacturer tofManufacturer) {
		this.tofManufacturer = tofManufacturer;
	}

	public List<TofType> getTofTypes() {
		return this.tofTypes;
	}

	public void setTofTypes(List<TofType> tofTypes) {
		this.tofTypes = tofTypes;
	}

	public TofType addTofType(TofType tofType) {
		getTofTypes().add(tofType);
		tofType.setTofModel(this);

		return tofType;
	}

	public TofType removeTofType(TofType tofType) {
		getTofTypes().remove(tofType);
		tofType.setTofModel(null);

		return tofType;
	}

}
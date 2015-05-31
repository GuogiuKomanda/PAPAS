package lt.pap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;


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
	private Integer modId;

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
	private Integer modPconEnd;

	@Column(name="MOD_PCON_START")
	private Integer modPconStart;
	
	@Column(name="MOD_CDS_ID") //va su situo
    private Integer ModCdsId;

    //TODO visiems des_id laukams sukuriam papildoma String lauka
    @Transient
    private transient String ModString;
    
	@ManyToOne
	@JoinColumn(name="MOD_MFA_ID")
	private TofManufacturer tofManufacturer;

	//bi-directional many-to-one association to TofType
	@OneToMany(mappedBy="tofModel")
	private List<TofType> tofTypes;

	public TofModel() {
	}

	public Integer getModId() {
		return this.modId;
	}

	public void setModId(Integer modId) {
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

	public Integer getModPconEnd() {
		return this.modPconEnd;
	}

	public void setModPconEnd(Integer modPconEnd) {
		this.modPconEnd = modPconEnd;
	}

	public Integer getModPconStart() {
		return this.modPconStart;
	}

	public void setModPconStart(Integer modPconStart) {
		this.modPconStart = modPconStart;
	}
//
//	public List<TofCountryDesignation> getTofCountryDesignations() {
//		return this.tofCountryDesignations;
//	}
//
//	public void setTofCountryDesignations(List<TofCountryDesignation> tofCountryDesignations) {
//		this.tofCountryDesignations = tofCountryDesignations;
//	}

//	public TofCountryDesignation addTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
//		getTofCountryDesignations().add(tofCountryDesignation);
//		tofCountryDesignation.setTofModel(this);
//
//		return tofCountryDesignation;
//	}
//
//	public TofCountryDesignation removeTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
//		getTofCountryDesignations().remove(tofCountryDesignation);
//		tofCountryDesignation.setTofModel(null);
//
//		return tofCountryDesignation;
//	}

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

    public Integer getModCdsId()
    {
        return ModCdsId;
    }

    public void setModCdsId(Integer modCdsId)
    {
        ModCdsId = modCdsId;
    }

    public String getModString()
    {
        return ModString;
    }

    public void setModString(String modString)
    {
        ModString = modString;
    }

}
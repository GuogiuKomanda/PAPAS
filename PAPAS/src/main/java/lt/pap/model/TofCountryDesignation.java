package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tof_country_designations database table.
 * 
 */
@Entity
@Table(name="tof_country_designations")
@NamedQuery(name="TofCountryDesignation.findAll", query="SELECT t FROM TofCountryDesignation t")
public class TofCountryDesignation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TofCountryDesignationPK id;

	//bi-directional many-to-one association to TofDesText
	@ManyToOne
	@JoinColumn(name="CDS_TEX_ID")
	private TofDesText tofDesText;

	//bi-directional many-to-one association to TofLanguage
	@ManyToOne
	@JoinColumn(name="CDS_LNG_ID", insertable=false, updatable=false)
	private TofLanguage tofLanguage;

//	//bi-directional many-to-one association to TofModel
//	@ManyToOne
//	@JoinColumn(name="CDS_ID", referencedColumnName="MOD_CDS_ID")
//	private TofModel tofModel;
//
//	//bi-directional many-to-one association to TofType
//	@ManyToOne
//	@JoinColumn(name="CDS_ID", referencedColumnName="TYP_MMT_CDS_ID")
//	private TofType tofType1;
//
//	//bi-directional many-to-one association to TofType
//	@ManyToOne
//	@JoinColumn(name="CDS_ID", referencedColumnName="TYP_CDS_ID")
//	private TofType tofType2;

	public TofCountryDesignation() {
	}

	public TofCountryDesignationPK getId() {
		return this.id;
	}

	public void setId(TofCountryDesignationPK id) {
		this.id = id;
	}

	public TofDesText getTofDesText() {
		return this.tofDesText;
	}

	public void setTofDesText(TofDesText tofDesText) {
		this.tofDesText = tofDesText;
	}

	public TofLanguage getTofLanguage() {
		return this.tofLanguage;
	}

	public void setTofLanguage(TofLanguage tofLanguage) {
		this.tofLanguage = tofLanguage;
	}
//
//	public TofModel getTofModel() {
//		return this.tofModel;
//	}
//
//	public void setTofModel(TofModel tofModel) {
//		this.tofModel = tofModel;
//	}
//
//	public TofType getTofType1() {
//		return this.tofType1;
//	}
//
//	public void setTofType1(TofType tofType1) {
//		this.tofType1 = tofType1;
//	}
//
//	public TofType getTofType2() {
//		return this.tofType2;
//	}
//
//	public void setTofType2(TofType tofType2) {
//		this.tofType2 = tofType2;
//	}

}
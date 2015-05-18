package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tof_languages database table.
 * 
 */
@Entity
@Table(name="tof_languages")
@NamedQuery(name="TofLanguage.findAll", query="SELECT t FROM TofLanguage t")
public class TofLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LNG_ID")
	private short lngId;

	@Column(name="LNG_CODEPAGE")
	private String lngCodepage;

	@Column(name="LNG_DES_ID")
	private int lngDesId;

	@Column(name="LNG_ISO2")
	private String lngIso2;

	//bi-directional many-to-one association to TofCountryDesignation
	@OneToMany(mappedBy="tofLanguage")
	private List<TofCountryDesignation> tofCountryDesignations;

//	//bi-directional many-to-one association to TofDesignation
//	@OneToMany(mappedBy="tofLanguage")
//	private List<TofDesignation> tofDesignations;

	public TofLanguage() {
	}

	public short getLngId() {
		return this.lngId;
	}

	public void setLngId(short lngId) {
		this.lngId = lngId;
	}

	public String getLngCodepage() {
		return this.lngCodepage;
	}

	public void setLngCodepage(String lngCodepage) {
		this.lngCodepage = lngCodepage;
	}

	public int getLngDesId() {
		return this.lngDesId;
	}

	public void setLngDesId(int lngDesId) {
		this.lngDesId = lngDesId;
	}

	public String getLngIso2() {
		return this.lngIso2;
	}

	public void setLngIso2(String lngIso2) {
		this.lngIso2 = lngIso2;
	}

	public List<TofCountryDesignation> getTofCountryDesignations() {
		return this.tofCountryDesignations;
	}

	public void setTofCountryDesignations(List<TofCountryDesignation> tofCountryDesignations) {
		this.tofCountryDesignations = tofCountryDesignations;
	}

	public TofCountryDesignation addTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
		getTofCountryDesignations().add(tofCountryDesignation);
		tofCountryDesignation.setTofLanguage(this);

		return tofCountryDesignation;
	}

	public TofCountryDesignation removeTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
		getTofCountryDesignations().remove(tofCountryDesignation);
		tofCountryDesignation.setTofLanguage(null);

		return tofCountryDesignation;
	}
//
//	public List<TofDesignation> getTofDesignations() {
//		return this.tofDesignations;
//	}
//
//	public void setTofDesignations(List<TofDesignation> tofDesignations) {
//		this.tofDesignations = tofDesignations;
//	}
//
//	public TofDesignation addTofDesignation(TofDesignation tofDesignation) {
//		getTofDesignations().add(tofDesignation);
//		tofDesignation.setTofLanguage(this);
//
//		return tofDesignation;
//	}
//
//	public TofDesignation removeTofDesignation(TofDesignation tofDesignation) {
//		getTofDesignations().remove(tofDesignation);
//		tofDesignation.setTofLanguage(null);
//
//		return tofDesignation;
//	}

}
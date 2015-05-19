package lt.pap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the tof_designations database table.
 * 
 */
@Entity
@Table(name="tof_designations")
@NamedQuery(name="TofDesignation.findAll", query="SELECT t FROM TofDesignation t")
public class TofDesignation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TofDesignationPK id;

	//bi-directional many-to-one association to TofDesText
	@Column(name="DES_TEX_ID")
	private Integer desTextId;

	@OneToOne
	@JoinColumn(name="DES_TEX_ID",  insertable=false, updatable=false, nullable=true)
	private TofDesText tofDesText;

//	//bi-directional many-to-one association to TofEngine
//	@ManyToOne
//	@JoinColumn(name="id.desId", referencedColumnName="ENG_KV_ENGINE_DES_ID", nullable=true)
//	private TofEngine kvEngine;
//
//	//bi-directional many-to-one association to TofEngine
//	@ManyToOne
//	@JoinColumn(name="DES_ID", referencedColumnName="ENG_KV_FUEL_TYPE_DES_ID")
//	private TofEngine tofEngine2;
//
//	//bi-directional many-to-one association to TofLanguage
//	@ManyToOne
//	@JoinColumn(name="DES_LNG_ID")
//	private TofLanguage tofLanguage;
//
//	//bi-directional many-to-one association to TofType
//	@ManyToOne
//	@JoinColumn(name="DES_ID", referencedColumnName="TYP_KV_BODY_DES_ID")
//	private TofType tofType1;
//
//	//bi-directional many-to-one association to TofType
//	@ManyToOne
//	@JoinColumn(name="DES_ID", referencedColumnName="TYP_KV_ENGINE_DES_ID")
//	private TofType tofType2;
//
//	//bi-directional many-to-one association to TofType
//	@ManyToOne
//	@JoinColumn(name="DES_ID", referencedColumnName="TYP_KV_FUEL_DES_ID")
//	private TofType tofType3;

	public TofDesignation() {
		super();
	}

	public TofDesignationPK getId() {
		return this.id;
	}

	public void setId(TofDesignationPK id) {
		this.id = id;
	}

	public Integer getDesTextId() {
		return desTextId;
	}

	public void setDesTextId(Integer desTextId) {
		this.desTextId = desTextId;
	}
	
	public TofDesText getTofDesText() {
		return this.tofDesText;
	}

	public void setTofDesText(TofDesText tofDesText) {
		this.tofDesText = tofDesText;
	}
//
//	public TofEngine getTofEngine1() {
//		return this.tofEngine1;
//	}
//
//	public void setTofEngine1(TofEngine tofEngine1) {
//		this.tofEngine1 = tofEngine1;
//	}
//
//	public TofEngine getTofEngine2() {
//		return this.tofEngine2;
//	}
//
//	public void setTofEngine2(TofEngine tofEngine2) {
//		this.tofEngine2 = tofEngine2;
//	}
//
//	public TofLanguage getTofLanguage() {
//		return this.tofLanguage;
//	}
//
//	public void setTofLanguage(TofLanguage tofLanguage) {
//		this.tofLanguage = tofLanguage;
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
//
//	public TofType getTofType3() {
//		return this.tofType3;
//	}
//
//	public void setTofType3(TofType tofType3) {
//		this.tofType3 = tofType3;
//	}

}
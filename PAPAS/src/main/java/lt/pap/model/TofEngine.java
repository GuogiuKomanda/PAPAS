package lt.pap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * The persistent class for the tof_engines database table.
 * 
 */
@Entity
@Table(name="tof_engines")
@NamedQuery(name="TofEngine.findAll", query="SELECT t FROM TofEngine t")
public class TofEngine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ENG_ID")
	private Integer engId;

	@Column(name="ENG_CCM_FROM")
	private Integer engCcmFrom;

	@Column(name="ENG_CODE")
	private String engCode;

	@Column(name="ENG_COMPRESSION_UPTO")
	private BigDecimal engCompressionUpto;

	@Column(name="ENG_CYLINDERS")
	private short engCylinders;

	@Column(name="ENG_DESCRIPTION")
	private String engDescription;

	@Column(name="ENG_HP_FROM")
	private Integer engHpFrom;

	@Column(name="ENG_HP_UPTO")
	private Integer engHpUpto;

	@Column(name="ENG_KW_FROM")
	private Integer engKwFrom;

	@Column(name="ENG_KW_UPTO")
	private Integer engKwUpto;

	@Column(name="ENG_LITRES_FROM")
	private BigDecimal engLitresFrom;

	@Column(name="ENG_MFA_ID")
	private short engMfaId;

	@Column(name="ENG_PCON_END")
	private Integer engPconEnd;

	@Column(name="ENG_PCON_START")
	private Integer engPconStart;
	
	
	//IMPORTAN STUFF
	@Column(name="ENG_KV_ENGINE_DES_ID") //va su situo
	private Integer kvEngineDesId;

	public Integer getKvEngineDesId() {
		return kvEngineDesId;
	}

	public void setKvEngineDesId(Integer kvEngineDesId) {
		this.kvEngineDesId = kvEngineDesId;
	}

	@OneToMany  //NOTE: ENG_KV_ENGINE_DES_ID sutampa su property virsuj
	@JoinColumn(name="DES_ID", referencedColumnName="ENG_KV_ENGINE_DES_ID",  insertable=false, updatable=false, nullable=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<TofDesignation> kvEngineTranslations;
	
	
	public List<TofDesignation> getKvEngineTranslations() {
		return kvEngineTranslations;
	}

	public void setKvEngineTranslations(List<TofDesignation> kvEngineTranslations) {
		this.kvEngineTranslations = kvEngineTranslations;
	}
	//IMPORTAN STUFF ENDS
	
	public TofEngine() {
	}

	public Integer getEngId() {
		return this.engId;
	}

	public void setEngId(Integer engId) {
		this.engId = engId;
	}

	public Integer getEngCcmFrom() {
		return this.engCcmFrom;
	}

	public void setEngCcmFrom(Integer engCcmFrom) {
		this.engCcmFrom = engCcmFrom;
	}

	public String getEngCode() {
		return this.engCode;
	}

	public void setEngCode(String engCode) {
		this.engCode = engCode;
	}

	public BigDecimal getEngCompressionUpto() {
		return this.engCompressionUpto;
	}

	public void setEngCompressionUpto(BigDecimal engCompressionUpto) {
		this.engCompressionUpto = engCompressionUpto;
	}

	public short getEngCylinders() {
		return this.engCylinders;
	}

	public void setEngCylinders(short engCylinders) {
		this.engCylinders = engCylinders;
	}

	public String getEngDescription() {
		return this.engDescription;
	}

	public void setEngDescription(String engDescription) {
		this.engDescription = engDescription;
	}

	public Integer getEngHpFrom() {
		return this.engHpFrom;
	}

	public void setEngHpFrom(Integer engHpFrom) {
		this.engHpFrom = engHpFrom;
	}

	public Integer getEngHpUpto() {
		return this.engHpUpto;
	}

	public void setEngHpUpto(Integer engHpUpto) {
		this.engHpUpto = engHpUpto;
	}

	public Integer getEngKwFrom() {
		return this.engKwFrom;
	}

	public void setEngKwFrom(Integer engKwFrom) {
		this.engKwFrom = engKwFrom;
	}

	public Integer getEngKwUpto() {
		return this.engKwUpto;
	}

	public void setEngKwUpto(Integer engKwUpto) {
		this.engKwUpto = engKwUpto;
	}

	public BigDecimal getEngLitresFrom() {
		return this.engLitresFrom;
	}

	public void setEngLitresFrom(BigDecimal engLitresFrom) {
		this.engLitresFrom = engLitresFrom;
	}

	public short getEngMfaId() {
		return this.engMfaId;
	}

	public void setEngMfaId(short engMfaId) {
		this.engMfaId = engMfaId;
	}

	public Integer getEngPconEnd() {
		return this.engPconEnd;
	}

	public void setEngPconEnd(Integer engPconEnd) {
		this.engPconEnd = engPconEnd;
	}

	public Integer getEngPconStart() {
		return this.engPconStart;
	}

	public void setEngPconStart(Integer engPconStart) {
		this.engPconStart = engPconStart;
	}
//
//	public List<TofDesignation> getTofDesignations1() {
//		return this.tofDesignations1;
//	}
//
//	public void setTofDesignations1(List<TofDesignation> tofDesignations1) {
//		this.tofDesignations1 = tofDesignations1;
//	}
//
//	public TofDesignation addTofDesignations1(TofDesignation tofDesignations1) {
//		getTofDesignations1().add(tofDesignations1);
//		tofDesignations1.setTofEngine1(this);
//
//		return tofDesignations1;
//	}
//
//	public TofDesignation removeTofDesignations1(TofDesignation tofDesignations1) {
//		getTofDesignations1().remove(tofDesignations1);
//		tofDesignations1.setTofEngine1(null);
//
//		return tofDesignations1;
//	}
//
//	public List<TofDesignation> getTofDesignations2() {
//		return this.tofDesignations2;
//	}
//
//	public void setTofDesignations2(List<TofDesignation> tofDesignations2) {
//		this.tofDesignations2 = tofDesignations2;
//	}
//
//	public TofDesignation addTofDesignations2(TofDesignation tofDesignations2) {
//		getTofDesignations2().add(tofDesignations2);
//		tofDesignations2.setTofEngine2(this);
//
//		return tofDesignations2;
//	}
//
//	public TofDesignation removeTofDesignations2(TofDesignation tofDesignations2) {
//		getTofDesignations2().remove(tofDesignations2);
//		tofDesignations2.setTofEngine2(null);
//
//		return tofDesignations2;
//	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 17;
	}

}
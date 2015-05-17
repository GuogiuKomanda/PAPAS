package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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
	private int engId;

	@Column(name="ENG_CCM_FROM")
	private int engCcmFrom;

	@Column(name="ENG_CODE")
	private String engCode;

	@Column(name="ENG_COMPRESSION_UPTO")
	private BigDecimal engCompressionUpto;

	@Column(name="ENG_CYLINDERS")
	private short engCylinders;

	@Column(name="ENG_DESCRIPTION")
	private String engDescription;

	@Column(name="ENG_HP_FROM")
	private int engHpFrom;

	@Column(name="ENG_HP_UPTO")
	private int engHpUpto;

	@Column(name="ENG_KW_FROM")
	private int engKwFrom;

	@Column(name="ENG_KW_UPTO")
	private int engKwUpto;

	@Column(name="ENG_LITRES_FROM")
	private BigDecimal engLitresFrom;

	@Column(name="ENG_MFA_ID")
	private short engMfaId;

	@Column(name="ENG_PCON_END")
	private int engPconEnd;

	@Column(name="ENG_PCON_START")
	private int engPconStart;

	//bi-directional many-to-one association to TofDesignation
	@OneToMany(mappedBy="tofEngine1")
	private List<TofDesignation> tofDesignations1;

	//bi-directional many-to-one association to TofDesignation
	@OneToMany(mappedBy="tofEngine2")
	private List<TofDesignation> tofDesignations2;

	public TofEngine() {
	}

	public int getEngId() {
		return this.engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	public int getEngCcmFrom() {
		return this.engCcmFrom;
	}

	public void setEngCcmFrom(int engCcmFrom) {
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

	public int getEngHpFrom() {
		return this.engHpFrom;
	}

	public void setEngHpFrom(int engHpFrom) {
		this.engHpFrom = engHpFrom;
	}

	public int getEngHpUpto() {
		return this.engHpUpto;
	}

	public void setEngHpUpto(int engHpUpto) {
		this.engHpUpto = engHpUpto;
	}

	public int getEngKwFrom() {
		return this.engKwFrom;
	}

	public void setEngKwFrom(int engKwFrom) {
		this.engKwFrom = engKwFrom;
	}

	public int getEngKwUpto() {
		return this.engKwUpto;
	}

	public void setEngKwUpto(int engKwUpto) {
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

	public int getEngPconEnd() {
		return this.engPconEnd;
	}

	public void setEngPconEnd(int engPconEnd) {
		this.engPconEnd = engPconEnd;
	}

	public int getEngPconStart() {
		return this.engPconStart;
	}

	public void setEngPconStart(int engPconStart) {
		this.engPconStart = engPconStart;
	}

	public List<TofDesignation> getTofDesignations1() {
		return this.tofDesignations1;
	}

	public void setTofDesignations1(List<TofDesignation> tofDesignations1) {
		this.tofDesignations1 = tofDesignations1;
	}

	public TofDesignation addTofDesignations1(TofDesignation tofDesignations1) {
		getTofDesignations1().add(tofDesignations1);
		tofDesignations1.setTofEngine1(this);

		return tofDesignations1;
	}

	public TofDesignation removeTofDesignations1(TofDesignation tofDesignations1) {
		getTofDesignations1().remove(tofDesignations1);
		tofDesignations1.setTofEngine1(null);

		return tofDesignations1;
	}

	public List<TofDesignation> getTofDesignations2() {
		return this.tofDesignations2;
	}

	public void setTofDesignations2(List<TofDesignation> tofDesignations2) {
		this.tofDesignations2 = tofDesignations2;
	}

	public TofDesignation addTofDesignations2(TofDesignation tofDesignations2) {
		getTofDesignations2().add(tofDesignations2);
		tofDesignations2.setTofEngine2(this);

		return tofDesignations2;
	}

	public TofDesignation removeTofDesignations2(TofDesignation tofDesignations2) {
		getTofDesignations2().remove(tofDesignations2);
		tofDesignations2.setTofEngine2(null);

		return tofDesignations2;
	}

}
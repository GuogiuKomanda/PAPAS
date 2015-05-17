package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tof_types database table.
 * 
 */
@Entity
@Table(name="tof_types")
@NamedQuery(name="TofType.findAll", query="SELECT t FROM TofType t")
public class TofType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TYP_ID")
	private int typId;

	@Column(name="TYP_CCM")
	private int typCcm;

	@Column(name="TYP_CTM")
	private byte[] typCtm;

	@Column(name="TYP_CYLINDERS")
	private short typCylinders;

	@Column(name="TYP_DOORS")
	private short typDoors;

	@Column(name="TYP_HP_FROM")
	private int typHpFrom;

	@Column(name="TYP_HP_UPTO")
	private int typHpUpto;

	@Column(name="TYP_KV_ABS_DES_ID")
	private int typKvAbsDesId;

	@Column(name="TYP_KV_ASR_DES_ID")
	private int typKvAsrDesId;

	@Column(name="TYP_KV_AXLE_DES_ID")
	private int typKvAxleDesId;

	@Column(name="TYP_KV_DRIVE_DES_ID")
	private int typKvDriveDesId;

	@Column(name="TYP_KV_FUEL_SUPPLY_DES_ID")
	private int typKvFuelSupplyDesId;

	@Column(name="TYP_KV_MODEL_DES_ID")
	private int typKvModelDesId;

	@Column(name="TYP_KV_TRANS_DES_ID")
	private int typKvTransDesId;

	@Column(name="TYP_KW_FROM")
	private int typKwFrom;

	@Column(name="TYP_KW_UPTO")
	private int typKwUpto;

	@Column(name="TYP_LITRES")
	private BigDecimal typLitres;

	@Column(name="TYP_MAX_WEIGHT")
	private BigDecimal typMaxWeight;

	@Column(name="TYP_PCON_END")
	private int typPconEnd;

	@Column(name="TYP_PCON_START")
	private int typPconStart;

	@Column(name="TYP_RT_EXISTS")
	private short typRtExists;

	@Column(name="TYP_SORT")
	private int typSort;

	@Column(name="TYP_TANK")
	private short typTank;

	@Column(name="TYP_VALVES")
	private short typValves;

	//bi-directional many-to-one association to TofCountryDesignation
	@OneToMany(mappedBy="tofType1")
	private List<TofCountryDesignation> tofCountryDesignations1;

	//bi-directional many-to-one association to TofCountryDesignation
	@OneToMany(mappedBy="tofType2")
	private List<TofCountryDesignation> tofCountryDesignations2;

	//bi-directional many-to-one association to TofDesignation
	@OneToMany(mappedBy="tofType1")
	private List<TofDesignation> tofDesignations1;

	//bi-directional many-to-one association to TofDesignation
	@OneToMany(mappedBy="tofType2")
	private List<TofDesignation> tofDesignations2;

	//bi-directional many-to-one association to TofDesignation
	@OneToMany(mappedBy="tofType3")
	private List<TofDesignation> tofDesignations3;

	//bi-directional many-to-one association to TofModel
	@ManyToOne
	@JoinColumn(name="TYP_MOD_ID")
	private TofModel tofModel;

	public TofType() {
	}

	public int getTypId() {
		return this.typId;
	}

	public void setTypId(int typId) {
		this.typId = typId;
	}

	public int getTypCcm() {
		return this.typCcm;
	}

	public void setTypCcm(int typCcm) {
		this.typCcm = typCcm;
	}

	public byte[] getTypCtm() {
		return this.typCtm;
	}

	public void setTypCtm(byte[] typCtm) {
		this.typCtm = typCtm;
	}

	public short getTypCylinders() {
		return this.typCylinders;
	}

	public void setTypCylinders(short typCylinders) {
		this.typCylinders = typCylinders;
	}

	public short getTypDoors() {
		return this.typDoors;
	}

	public void setTypDoors(short typDoors) {
		this.typDoors = typDoors;
	}

	public int getTypHpFrom() {
		return this.typHpFrom;
	}

	public void setTypHpFrom(int typHpFrom) {
		this.typHpFrom = typHpFrom;
	}

	public int getTypHpUpto() {
		return this.typHpUpto;
	}

	public void setTypHpUpto(int typHpUpto) {
		this.typHpUpto = typHpUpto;
	}

	public int getTypKvAbsDesId() {
		return this.typKvAbsDesId;
	}

	public void setTypKvAbsDesId(int typKvAbsDesId) {
		this.typKvAbsDesId = typKvAbsDesId;
	}

	public int getTypKvAsrDesId() {
		return this.typKvAsrDesId;
	}

	public void setTypKvAsrDesId(int typKvAsrDesId) {
		this.typKvAsrDesId = typKvAsrDesId;
	}

	public int getTypKvAxleDesId() {
		return this.typKvAxleDesId;
	}

	public void setTypKvAxleDesId(int typKvAxleDesId) {
		this.typKvAxleDesId = typKvAxleDesId;
	}

	public int getTypKvDriveDesId() {
		return this.typKvDriveDesId;
	}

	public void setTypKvDriveDesId(int typKvDriveDesId) {
		this.typKvDriveDesId = typKvDriveDesId;
	}

	public int getTypKvFuelSupplyDesId() {
		return this.typKvFuelSupplyDesId;
	}

	public void setTypKvFuelSupplyDesId(int typKvFuelSupplyDesId) {
		this.typKvFuelSupplyDesId = typKvFuelSupplyDesId;
	}

	public int getTypKvModelDesId() {
		return this.typKvModelDesId;
	}

	public void setTypKvModelDesId(int typKvModelDesId) {
		this.typKvModelDesId = typKvModelDesId;
	}

	public int getTypKvTransDesId() {
		return this.typKvTransDesId;
	}

	public void setTypKvTransDesId(int typKvTransDesId) {
		this.typKvTransDesId = typKvTransDesId;
	}

	public int getTypKwFrom() {
		return this.typKwFrom;
	}

	public void setTypKwFrom(int typKwFrom) {
		this.typKwFrom = typKwFrom;
	}

	public int getTypKwUpto() {
		return this.typKwUpto;
	}

	public void setTypKwUpto(int typKwUpto) {
		this.typKwUpto = typKwUpto;
	}

	public BigDecimal getTypLitres() {
		return this.typLitres;
	}

	public void setTypLitres(BigDecimal typLitres) {
		this.typLitres = typLitres;
	}

	public BigDecimal getTypMaxWeight() {
		return this.typMaxWeight;
	}

	public void setTypMaxWeight(BigDecimal typMaxWeight) {
		this.typMaxWeight = typMaxWeight;
	}

	public int getTypPconEnd() {
		return this.typPconEnd;
	}

	public void setTypPconEnd(int typPconEnd) {
		this.typPconEnd = typPconEnd;
	}

	public int getTypPconStart() {
		return this.typPconStart;
	}

	public void setTypPconStart(int typPconStart) {
		this.typPconStart = typPconStart;
	}

	public short getTypRtExists() {
		return this.typRtExists;
	}

	public void setTypRtExists(short typRtExists) {
		this.typRtExists = typRtExists;
	}

	public int getTypSort() {
		return this.typSort;
	}

	public void setTypSort(int typSort) {
		this.typSort = typSort;
	}

	public short getTypTank() {
		return this.typTank;
	}

	public void setTypTank(short typTank) {
		this.typTank = typTank;
	}

	public short getTypValves() {
		return this.typValves;
	}

	public void setTypValves(short typValves) {
		this.typValves = typValves;
	}

	public List<TofCountryDesignation> getTofCountryDesignations1() {
		return this.tofCountryDesignations1;
	}

	public void setTofCountryDesignations1(List<TofCountryDesignation> tofCountryDesignations1) {
		this.tofCountryDesignations1 = tofCountryDesignations1;
	}

	public TofCountryDesignation addTofCountryDesignations1(TofCountryDesignation tofCountryDesignations1) {
		getTofCountryDesignations1().add(tofCountryDesignations1);
		tofCountryDesignations1.setTofType1(this);

		return tofCountryDesignations1;
	}

	public TofCountryDesignation removeTofCountryDesignations1(TofCountryDesignation tofCountryDesignations1) {
		getTofCountryDesignations1().remove(tofCountryDesignations1);
		tofCountryDesignations1.setTofType1(null);

		return tofCountryDesignations1;
	}

	public List<TofCountryDesignation> getTofCountryDesignations2() {
		return this.tofCountryDesignations2;
	}

	public void setTofCountryDesignations2(List<TofCountryDesignation> tofCountryDesignations2) {
		this.tofCountryDesignations2 = tofCountryDesignations2;
	}

	public TofCountryDesignation addTofCountryDesignations2(TofCountryDesignation tofCountryDesignations2) {
		getTofCountryDesignations2().add(tofCountryDesignations2);
		tofCountryDesignations2.setTofType2(this);

		return tofCountryDesignations2;
	}

	public TofCountryDesignation removeTofCountryDesignations2(TofCountryDesignation tofCountryDesignations2) {
		getTofCountryDesignations2().remove(tofCountryDesignations2);
		tofCountryDesignations2.setTofType2(null);

		return tofCountryDesignations2;
	}

	public List<TofDesignation> getTofDesignations1() {
		return this.tofDesignations1;
	}

	public void setTofDesignations1(List<TofDesignation> tofDesignations1) {
		this.tofDesignations1 = tofDesignations1;
	}

	public TofDesignation addTofDesignations1(TofDesignation tofDesignations1) {
		getTofDesignations1().add(tofDesignations1);
		tofDesignations1.setTofType1(this);

		return tofDesignations1;
	}

	public TofDesignation removeTofDesignations1(TofDesignation tofDesignations1) {
		getTofDesignations1().remove(tofDesignations1);
		tofDesignations1.setTofType1(null);

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
		tofDesignations2.setTofType2(this);

		return tofDesignations2;
	}

	public TofDesignation removeTofDesignations2(TofDesignation tofDesignations2) {
		getTofDesignations2().remove(tofDesignations2);
		tofDesignations2.setTofType2(null);

		return tofDesignations2;
	}

	public List<TofDesignation> getTofDesignations3() {
		return this.tofDesignations3;
	}

	public void setTofDesignations3(List<TofDesignation> tofDesignations3) {
		this.tofDesignations3 = tofDesignations3;
	}

	public TofDesignation addTofDesignations3(TofDesignation tofDesignations3) {
		getTofDesignations3().add(tofDesignations3);
		tofDesignations3.setTofType3(this);

		return tofDesignations3;
	}

	public TofDesignation removeTofDesignations3(TofDesignation tofDesignations3) {
		getTofDesignations3().remove(tofDesignations3);
		tofDesignations3.setTofType3(null);

		return tofDesignations3;
	}

	public TofModel getTofModel() {
		return this.tofModel;
	}

	public void setTofModel(TofModel tofModel) {
		this.tofModel = tofModel;
	}

}
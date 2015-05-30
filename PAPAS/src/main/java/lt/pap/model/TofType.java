package lt.pap.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;


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
	
	@Column(name="TYP_CDS_ID")
    private Integer typCdsId;

    

    //TODO visiems des_id laukams sukuriam papildoma String lauka
    @Transient
    private transient String typString;
    @Column(name="TYP_MMT_CDS_ID")
    private Integer typMmtCdsId;

    

    //TODO visiems des_id laukams sukuriam papildoma String lauka
    @Transient
    private transient String typMmtString;
    

	@Column(name="TYP_CCM")
	private int typCcm;

	@Column(name="TYP_CTM")
	private byte[] typCtm;

	@Column(name="TYP_CYLINDERS")
	private short typCylinders;

	
	@Column(name="TYP_HP_FROM")
	private int typHpFrom;



	@Column(name="TYP_KV_FUEL_DES_ID")
	private Integer typKvFuelDesId;

	

    //TODO visiems des_id laukams sukuriam papildoma String lauka
    @Transient
    private transient String typKvFuelString;
    
    @Column(name="TYP_KV_BODY_DES_ID")
    private Integer typKvBodyDesId;

    

    //TODO visiems des_id laukams sukuriam papildoma String lauka
    @Transient
    private transient String typKvBodyString;
	
	@Column(name="TYP_KW_FROM")
	private int typKwFrom;


	@Column(name="TYP_LITRES")
	private BigDecimal typLitres;


	@Column(name="TYP_PCON_END")
	private int typPconEnd;

	@Column(name="TYP_PCON_START")
	private int typPconStart;




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

	

	public int getTypHpFrom() {
		return this.typHpFrom;
	}

	public void setTypHpFrom(int typHpFrom) {
		this.typHpFrom = typHpFrom;
	}

	

	public int getTypKwFrom() {
		return this.typKwFrom;
	}

	public void setTypKwFrom(int typKwFrom) {
		this.typKwFrom = typKwFrom;
	}

	

	public BigDecimal getTypLitres() {
		return this.typLitres;
	}

	public void setTypLitres(BigDecimal typLitres) {
		this.typLitres = typLitres;
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


	public TofModel getTofModel() {
		return this.tofModel;
	}

	public void setTofModel(TofModel tofModel) {
		this.tofModel = tofModel;
	}

}
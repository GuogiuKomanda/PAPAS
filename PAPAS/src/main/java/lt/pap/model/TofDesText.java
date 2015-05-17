package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tof_des_texts database table.
 * 
 */
@Entity
@Table(name="tof_des_texts")
@NamedQuery(name="TofDesText.findAll", query="SELECT t FROM TofDesText t")
public class TofDesText implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEX_ID")
	private int texId;

	@Column(name="TEX_TEXT")
	private String texText;

	//bi-directional many-to-one association to TofCountryDesignation
	@OneToMany(mappedBy="tofDesText")
	private List<TofCountryDesignation> tofCountryDesignations;

	//bi-directional many-to-one association to TofDesignation
	@OneToMany(mappedBy="tofDesText")
	private List<TofDesignation> tofDesignations;

	public TofDesText() {
	}

	public int getTexId() {
		return this.texId;
	}

	public void setTexId(int texId) {
		this.texId = texId;
	}

	public String getTexText() {
		return this.texText;
	}

	public void setTexText(String texText) {
		this.texText = texText;
	}

	public List<TofCountryDesignation> getTofCountryDesignations() {
		return this.tofCountryDesignations;
	}

	public void setTofCountryDesignations(List<TofCountryDesignation> tofCountryDesignations) {
		this.tofCountryDesignations = tofCountryDesignations;
	}

	public TofCountryDesignation addTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
		getTofCountryDesignations().add(tofCountryDesignation);
		tofCountryDesignation.setTofDesText(this);

		return tofCountryDesignation;
	}

	public TofCountryDesignation removeTofCountryDesignation(TofCountryDesignation tofCountryDesignation) {
		getTofCountryDesignations().remove(tofCountryDesignation);
		tofCountryDesignation.setTofDesText(null);

		return tofCountryDesignation;
	}

	public List<TofDesignation> getTofDesignations() {
		return this.tofDesignations;
	}

	public void setTofDesignations(List<TofDesignation> tofDesignations) {
		this.tofDesignations = tofDesignations;
	}

	public TofDesignation addTofDesignation(TofDesignation tofDesignation) {
		getTofDesignations().add(tofDesignation);
		tofDesignation.setTofDesText(this);

		return tofDesignation;
	}

	public TofDesignation removeTofDesignation(TofDesignation tofDesignation) {
		getTofDesignations().remove(tofDesignation);
		tofDesignation.setTofDesText(null);

		return tofDesignation;
	}

}
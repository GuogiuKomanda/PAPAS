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
}
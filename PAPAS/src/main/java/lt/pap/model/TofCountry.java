package lt.pap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tof_countries database table.
 * 
 */
@Entity
@Table(name="tof_countries")
@NamedQuery(name="TofCountry.findAll", query="SELECT t FROM TofCountry t")
public class TofCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COU_ID")
	private short couId;

	@Column(name="COU_CC")
	private String couCc;

	@Column(name="COU_DES_ID")
	private int couDesId;

	@Column(name="COU_IS_GROUP")
	private short couIsGroup;

	public TofCountry() {
	}

	public short getCouId() {
		return this.couId;
	}

	public void setCouId(short couId) {
		this.couId = couId;
	}

	public String getCouCc() {
		return this.couCc;
	}

	public void setCouCc(String couCc) {
		this.couCc = couCc;
	}

	public int getCouDesId() {
		return this.couDesId;
	}

	public void setCouDesId(int couDesId) {
		this.couDesId = couDesId;
	}

	public short getCouIsGroup() {
		return this.couIsGroup;
	}

	public void setCouIsGroup(short couIsGroup) {
		this.couIsGroup = couIsGroup;
	}

}
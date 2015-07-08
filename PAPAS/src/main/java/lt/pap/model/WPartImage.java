package lt.pap.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WPartImage {
	
	@Column(name="IMAGE_PATH")
	private String path;

	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;

	public WPartImage() {
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return path.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WPartImage)) {
			return false;
		}
		WPartImage castOther = (WPartImage)other;
		return this.path.equals(castOther.path);
	}
	
}

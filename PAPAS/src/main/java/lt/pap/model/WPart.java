package lt.pap.model;

import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lt.pap.converter.YearConverter;



@Entity
@Table(name = "wpart")
public class WPart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="WPART_ID")
    private Integer wpartid;

    @Column(name="TREE_ID")
    private Integer treeid;
    
    @Column(name="BRAND_ID")
    private Integer brandid;
    
    @Column(name = "BRANDCODE",  length = 20)
    private String brandcode;
    
    @Column(name = "CODE",  length = 20)
    private String code;
    
    @Column(name = "CODE2",  length = 20)
    private String code2;
    
    @Column(name = "CODE3",  length = 20)
    private String code3;
    
    @Column(name = "LOCATION",  length = 50)
    private String location;
    
    @Column(name = "PRICE1")
    private Float price1;
    
    @Column(name = "PRICE2")
    private Float price2;
    
    @Column(name = "year")
    @Convert(converter = YearConverter.class)
    private Year year;

    @Column(name = "FULLCODE",  length = 50)
    private String fullCode;

    @Column(name = "DEFECT")
    private Boolean defect;
    
    @Column(name = "DSTATUS",  length = 50)
   private String dstatus;
    
    @Column(name = "PHOTO_PATH",  length = 150)
    private String photoPath;
    
    @Column(name = "TIME_STAMP")
    private Date timeStamp;
    
    @Column(name="PART_STATUS")
    private Integer partStatus;

//    @Column(name="TYP_ID")
  //  private Integer type;
    
    public Integer getTreeid() {
		return treeid;
	}

	public void setTreeid(Integer treeid) {
		this.treeid = treeid;
	}

	public Integer getBrandid() {
		return brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getBrandcode() {
		return brandcode;
	}

	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	public Boolean getdefect() {
		return defect;
	}

	public void setdefect(Boolean defect) {
		this.defect = defect;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getPartStatus() {
		return partStatus;
	}

	public void setPartStatus(Integer partStatus) {
		this.partStatus = partStatus;
	}

	@ManyToOne
    @JoinColumn(name="TYP_ID")
    private TofType tofType;

    @ManyToOne
    @JoinColumn(name="ENG_ID")
    private TofEngine tofEngine;
    
    

    public Integer getWpartid()
    {
        return wpartid;
    }
//
//    public void setWpartid(Integer wpartid)
//    {
//        this.wpartid = wpartid;
//    }

    public Year getYear()
    {
        return year;
    }

    public void setYear(Year year)
    {
        this.year = year;
    }

    public String getFullCode()
    {
        return fullCode;
    }

    public void setFullCode(String fullCode)
    {
        this.fullCode = fullCode;
    }

   
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Float getPrice1()
    {
        return price1;
    }

    public void setPrice1(Float price1)
    {
        this.price1 = price1;
    }

    public Float getPrice2()
    {
        return price2;
    }

    public void setPrice2(Float price2)
    {
        this.price2 = price2;
    }
    
	public TofEngine getEngine() {
		return tofEngine;
	}

	public void setEngine(TofEngine engine) {
		this.tofEngine = engine;
	}

 

    public void setWpartid(Integer wpartid)
    {
        this.wpartid = wpartid;
    }

    public String getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(String dstatus)
    {
        this.dstatus = dstatus;
    }

    public TofType getTofType()
    {
        return tofType;
    }

    public void setTofType(TofType tofType)
    {
        this.tofType = tofType;
    }

    /**
     * @return the tofEngine
     */
    public TofEngine getTofEngine()
    {
        return tofEngine;
    }

    /**
     * @param tofEngine the tofEngine to set
     */
    public void setTofEngine(TofEngine tofEngine)
    {
        this.tofEngine = tofEngine;
    }

//    public String getDstatus()
//    {
//        return dstatus;
//    }
//
//    public void setDstatus(String dstatus)
//    {
//        this.dstatus = dstatus;
//    }

//    public TofType getTofType()
//    {
//        return tofType;
//    }
//
//    public void setTofType(TofType tofType)
//    {
//        this.tofType = tofType;
//    }
//
//    public TofEngine getTofEngine()
//    {
//        return tofEngine;
//    }
//
//    public void setTofEngine(TofEngine tofEngine)
//    {
//        this.tofEngine = tofEngine;
//    }
    
   

   
}

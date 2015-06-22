package lt.pap.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lt.pap.converter.YearConverter;



@Entity
@Table(name = "wpart")
public class WPart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="WPART_ID")
    private Integer wpartid;


    @Column(name = "LOCATION", nullable = false, length = 50)
    private String location;
    
    @Column(name = "PRICE1", nullable =false)
    private Float price1;
    
    @Column(name = "PRICE2", nullable =false)
    private Float price2;
    
    @Column(name = "year", nullable = false)
    @Convert(converter = YearConverter.class)
    private Year year;

    @Column(name = "fullcode", nullable = false, length = 50)
    private String fullCode;

   
   
    @Column(name = "DSTATUS", nullable = false, length = 50)
   private String dstatus;

    @Column(name="TYP_ID")
    private Integer type;
    
    @Column(name="ENG_ID")
    private Integer engine;
    
    

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getEngine() {
		return engine;
	}

	public void setEngine(Integer engine) {
		this.engine = engine;
	}

 

    public void setWpartid(Integer wpartid)
    {
        this.wpartid = wpartid;
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

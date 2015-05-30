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
@Table(name = "WPart")
public class WPart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="WPART_ID")
    private Integer wpartid;


    
    @Column(name = "year", nullable = false)
    @Convert(converter = YearConverter.class)
    private Year year;

    @Column(name = "fullcode", nullable = false, length = 40)
    private String fullCode;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    public Integer getWpartid()
    {
        return wpartid;
    }

    public void setWpartid(Integer wpartid)
    {
        this.wpartid = wpartid;
    }

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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
   

   
}

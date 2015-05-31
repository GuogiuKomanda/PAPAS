package lt.pap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "fuel")
public class Fuel 
{

  
    @Id
    @Column(name="DES_ID")
    private Integer desId;

    @Column(name="FORDER")
    private Integer order;
    
    @Column(name="FSTATUS")
    private boolean status;

    public Integer getDesId()
    {
        return desId;
    }

    public void setDesId(Integer desId)
    {
        this.desId = desId;
    }

    public Integer getOrder()
    {
        return order;
    }

    public void setOrder(Integer order)
    {
        this.order = order;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }
   
    
}

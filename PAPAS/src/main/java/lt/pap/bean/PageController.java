package lt.pap.bean;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class PageController implements Serializable {
 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5945802686480441328L;

	public String moveToMain(){
		return "index";
	}
	
	public String moveToEngineList(){
		return "enginelist";
	}
	
	public String moveToEngineEdit(){
		return "engineedit";
	}
	
	public String moveToEngineSearch(){
		return "enginelist";
	}
}
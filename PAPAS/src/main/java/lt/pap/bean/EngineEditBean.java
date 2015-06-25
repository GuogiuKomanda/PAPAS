package lt.pap.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;

import lt.pap.model.TofEngine;
import lt.pap.model.TofType;
import lt.pap.model.WPart;
import lt.pap.model.utils.Functions;
import lt.pap.service.WPartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("engineEditBean")
@Scope("session")
public class EngineEditBean {
	
	@Autowired
	private SessionBean session;
	
	@Autowired
	private WPartService wpartService;

	private Short manufacturer;
	
	private Integer model;
	private Integer  engineId;
	private TofEngine engine;
	
	private TofType type;
	
	private String engineCodeFull;
	
	private String year;
	
	private String comment;
	
	private String price1;
	
	private String price2;
	

	public void updateModelList() {
		model = null;
		updateCodeList();
	}

	public void updateCodeList() {
		engine = null;
		updateTypeList();
	}
	
	public void updateTypeList() {
		type = null;
	}
	
	public void doSave() {
		
		WPart part = new WPart();
		part.setEngine(engine);
		part.setFullCode(engineCodeFull);
		part.setTofType(type);
		part.setLocation("xxx");
		//part.setDstatus("dstatus");
//		part.setYear(year);
		wpartService.save(part);
		// selectedModelList, selectedFuelTypeList);
	}

	public List<SelectItem> getAvailableManufacturerList() {
		return session.getAvailableManufacturers();
	}

	public List<SelectItem> getAvailableModelList() {
		if (manufacturer != null) {
			return session.getAvailableModels(manufacturer);
		} else {
			return new ArrayList<SelectItem>();
		}
	}
	
	public List<SelectItem> getAvailableEngineCodesList() {
		if (model != null) {
			return session.getAvailableEngineCodes(model);
		} else {
			return new ArrayList<SelectItem>();
		}
	}
	
	public List<SelectItem> getAvailableTypesList() {
		if (model != null && engine != null) {
			return session.getAvailableTypes(model, engine.getEngId());
		} else {
			return new ArrayList<SelectItem>();
		}
	}

	public List<SelectItem> getAvailableYearsList() {
		return Functions.yearsAsSelectItems(1999, Year.now().getValue());
	}

	public Short getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Short manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public Integer getEngineId() {
		return engineId;
	}

	public void setEngineId(Integer engineId) {
		this.engineId = engineId;
	}

	public TofType getType() {
		return type;
	}

	public void setTofType(TofType type) {
		this.type = type;
	}

	public String getEngineCodeFull() {
		return engineCodeFull;
	}

	public void setEngineCodeFull(String engineCodeFull) {
		this.engineCodeFull = engineCodeFull;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

    private List<String> pathList = new ArrayList<String>();
   
    public List<String> getPathList() {
		return pathList;
	}

	public void setPathList(List<String> pathList) {
		this.pathList = pathList;
	}

	private static final Logger logger = Logger.getLogger(EngineEditBean.class.getName());
    private List<Part> files;
    private String trash = "{items: []}";
    
    private static String FOLDER = "D:\\uploads";
    


    public void upload(ActionEvent event) {               

        if (files != null) {

            int countFiles = 0;
            String trashFiles = trash.substring(trash.indexOf(":"), trash.length() - 1);
            byte maxFilesNumber = Byte.parseByte((String) event.getComponent().getAttributes().get("maxFilesNumber"));
            int maxFileSize = Integer.parseInt((String) event.getComponent().getAttributes().get("maxFileSize"));
            String fileTypes = (String) event.getComponent().getAttributes().get("fileTypes");
            
            logger.log(Level.INFO, "Files trash:{0}", trash);

            logger.info("Files Details:");
            for (Part file : files) {

                // validate the file name
                String fileName = file.getSubmittedFileName().trim();
                if (!fileName.isEmpty()) {
                    
                    String fileNameToDisplay = (fileName.length() > 20) ? fileName.substring(0, 17)+" ..." : fileName;

                    // check if this is trash file
                    if (!trashFiles.contains("\"name\":\"" + fileName + "\"")) {

                        //validate content type
                        if (file.getContentType().startsWith(fileTypes)) {

                            // validate file size                                
                            if (file.getSize() <= maxFileSize) {

                                // validate maximum number of files
                                if (countFiles < maxFilesNumber) {

                                    logger.log(Level.INFO, "File component id:{0}", file.getName());
                                    logger.log(Level.INFO, "Content type:{0}", file.getContentType());
                                    logger.log(Level.INFO, "Submitted file name:{0}", file.getSubmittedFileName());
                                    logger.log(Level.INFO, "File size:{0}", file.getSize());

                                    String path = FOLDER + File.separator + file.getSubmittedFileName();
                                    try (InputStream inputStream = file.getInputStream(); FileOutputStream outputStream = new FileOutputStream(path)) {

                                        int bytesRead = 0;
                                        final byte[] chunck = new byte[1024];
                                        while ((bytesRead = inputStream.read(chunck)) != -1) {
                                            outputStream.write(chunck, 0, bytesRead);
                                        }
                                        
                                        pathList.add(path);

                                        countFiles++;

                                        FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload successfully ended: " + fileNameToDisplay, ""));
                                    } catch (IOException ex) {
                                        FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload " + fileNameToDisplay + " failed !", ""));
                                    }
                                } else {
                                    FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "You can upload maxim 5 images !", ""));
                                    break;
                                }
                            } else {
                                FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File: " + fileNameToDisplay + " has more than 2 MB !", ""));
                            }
                        } else {
                            FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File " + fileNameToDisplay + " is not an accepted image !", ""));
                        }
                    }
                }
            }
            if (countFiles == 0) {
                FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "There are no files to upload !", ""));
            }
        }
    }

    public String getTrash() {
        return trash;
    }

    public void setTrash(String trash) {
        this.trash = trash;
    }

    public List<Part> getFiles() {
        return files;
    }

    public void setFiles(List<Part> files) {
        this.files = files;
    }
   
  
}

package lt.pap.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
import lt.pap.model.WPartImage;
import lt.pap.model.utils.Functions;
import lt.pap.service.TofEngineService;
import lt.pap.service.TofTypeService;
import lt.pap.service.WPartService;
import lt.pap.servlet.ImageServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("engineEditBean")
@Scope("session")
public class EngineEditBean {
	
	private String UNIQUE_FOLDER = UUID.randomUUID().toString();
	
	@Autowired
	private SessionBean session;
	
	@Autowired
	private WPartService wpartService;
	
	@Autowired
	private TofEngineService engineService;
	
	@Autowired
	private TofTypeService typeService;

	private Short manufacturerId;
	
	private Integer modelId;
	private Integer  engineId;
//	private TofEngine engine;
	
	private Integer typeId;
	
	private String engineCodeFull;
	
	private int year;
	
	private String comment;
	
	private String price1;
	
	private String price2;
	
	private String location;
	
	//temporal
	private Integer wpartId;
	
	public Integer getWpartId() {
		return wpartId;
	}

	public void setWpartId(Integer wpartId) {
		this.wpartId = wpartId;
	}

	private WPart part = new WPart();
	
	public void init() {
		if(wpartId != null) {
			part = wpartService.findOne(wpartId);
			pathList = part.getPathList();
			
			 //manufacturerId = part.getBrandId().shortValue();
			 engineCodeFull = part.getFullCode();
			//TODO others?

		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void updateModelList() {
		modelId = null;
		updateCodeList();
	}

	public void updateCodeList() {
		engineId = null;
		updateTypeList();
	}
	
	public void updateTypeList() {
		typeId = null;
	}
	
	public void doSave() {
		
		TofEngine engine = engineService.findOne(engineId, session.getLocaleId());
		TofType type = typeService.findOne(typeId);
		
		part.setEngine(engine);
		part.setFullCode(engineCodeFull);
		part.setTofType(type);
		
		part.setPrice1(Float.parseFloat(price1));
		part.setPrice2(Float.parseFloat(price2));
		
		part.setLocation(location);
		part.setYear(Year.of(year));
		part.setTreeid(1);
		part.setBrandcode(null);
		part.setBrandid(null);
		part.setCode(null);
		part.setCode2(null);
		part.setCode3(null);
		part.setdefect(false);
		part.setPartStatus(1);
		part.setDstatus(null);
		part.setPhotoPath(null);
		part.setTimeStamp(null);
		
		part.setPathList(pathList);
		
		wpartService.save(part);
		
	}

	public List<SelectItem> getAvailableManufacturerList() {
		return session.getAvailableManufacturers();
	}

	public List<SelectItem> getAvailableModelList() {
		if (manufacturerId != null) {
			return session.getAvailableModels(manufacturerId);
		} else {
			return new ArrayList<SelectItem>();
		}
	}
	
	public List<SelectItem> getAvailableEngineCodesList() {
		if (modelId != null) {
			return session.getAvailableEngineCodes(modelId);
		} else {
			return new ArrayList<SelectItem>();
		}
	}
	
	public List<SelectItem> getAvailableTypesList() {
		if (modelId != null && engineId != null) {
			return session.getAvailableTypes(modelId, engineId);
		} else {
			return new ArrayList<SelectItem>();
		}
	}

	public List<SelectItem> getAvailableYearsList() {
		return Functions.yearsAsSelectItems(1999, Year.now().getValue());
	}

	public Short getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Short manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getEngineId() {
		return engineId;
	}

	public void setEngineId(Integer engineId) {
		this.engineId = engineId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getEngineCodeFull() {
		return engineCodeFull;
	}

	public void setEngineCodeFull(String engineCodeFull) {
		this.engineCodeFull = engineCodeFull;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
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

    private List<WPartImage> pathList = new ArrayList<WPartImage>();
   
    public List<WPartImage> getPathList() {
		return pathList;
	}

	public void setPathList(List<WPartImage> pathList) {
		this.pathList = pathList;
	}

	private static final Logger logger = Logger.getLogger(EngineEditBean.class.getName());
    private List<Part> files;
    private String trash = "{items: []}";
    
    
   public void  deleteImage(Integer index) {
	   WPartImage img =  pathList.get(index);
	   
	   File imgFile = new File (ImageServlet.FOLDER + File.separator + img.getPath());
	   imgFile.delete();
	  // pathList.remove(img);
	   
	   if(part.getPathList().remove(img)) {
		   wpartService.save(part);
	   }
   }


    public void upload(ActionEvent event) {               

        if (files != null) {
        	
//        	pathList.clear();

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

                                    String path = ImageServlet.FOLDER + File.separator + UNIQUE_FOLDER;
                                    new File(path).mkdirs();//init dirs
                                    path +=  File.separator+ file.getSubmittedFileName();
                                    try (InputStream inputStream = file.getInputStream(); FileOutputStream outputStream = new FileOutputStream(path)) {

                                        int bytesRead = 0;
                                        final byte[] chunck = new byte[1024];
                                        while ((bytesRead = inputStream.read(chunck)) != -1) {
                                            outputStream.write(chunck, 0, bytesRead);
                                        }
                                        WPartImage img = new WPartImage();
                                        img.setPath(path.substring(path.indexOf(UNIQUE_FOLDER)));
                                        img.setName(file.getSubmittedFileName());
                                        img.setDescription(""+file.getSize());
                                        pathList.add(img);

                                        countFiles++;

                                        FacesContext.getCurrentInstance().addMessage("mainForm:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload successfully ended: " + fileNameToDisplay, ""));
                                    } catch (IOException ex) {
                                        FacesContext.getCurrentInstance().addMessage("mainForm:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload " + fileNameToDisplay + " failed !", ""));
                                    }
                                } else {
                                    FacesContext.getCurrentInstance().addMessage("mainForm:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "You can upload maxim 5 images !", ""));
                                    break;
                                }
                            } else {
                                FacesContext.getCurrentInstance().addMessage("mainForm:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File: " + fileNameToDisplay + " has more than 2 MB !", ""));
                            }
                        } else {
                            FacesContext.getCurrentInstance().addMessage("mainForm:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File " + fileNameToDisplay + " is not an accepted image !", ""));
                        }
                    }
                }
            }
            if (countFiles == 0) {
                FacesContext.getCurrentInstance().addMessage("mainForm:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "There are no files to upload !", ""));
            }
        }
        
//        doSave();
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

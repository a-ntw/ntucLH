package carDate.pict;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

    private Long id;
    
    private Long entityId;
    
    private MultipartFile file;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
     
    public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public MultipartFile getFile() {
        return file;
    }
 
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

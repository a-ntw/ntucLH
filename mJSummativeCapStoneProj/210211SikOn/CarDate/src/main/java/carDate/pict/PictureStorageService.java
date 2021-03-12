package carDate.pict;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureStorageService {

	  @Autowired
	  private PictureRepo pictureRepo;

	  @Autowired
	  private PictureDao pictureDao;

	  private static String UPLOAD_DIR = "CarPhotos";  // pictures are saved to this folder in file system
	  
	public Picture store(MultipartFile file, long pictId, boolean inDB) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Picture oldPict = new Picture();
		if (pictId>0) {
			oldPict = pictureDao.getPictureByPictId(pictId);
			pictId = oldPict==null?0:oldPict.getPictId();
		}

		if (pictId==0) { // this is a new picture
			Picture newPict = new Picture("", file.getContentType(), null);
			if (inDB) {  // to be stored to the database
				newPict.setData(file.getBytes());
				newPict = pictureRepo.save(newPict);
			} else {           // to be stored in file system
				newPict = pictureRepo.save(newPict);
			    fileName = "" + newPict.getPictId() + fileName.substring(fileName.lastIndexOf('.'));
			    newPict.setName(fileName);
		        // Make sure directory exists!
		        File uploadDir = new File(UPLOAD_DIR);
		        uploadDir.mkdirs();
		        String uploadFilePath = UPLOAD_DIR + "/" + fileName;
		        byte[] bytes = file.getBytes();
		        Path path = Paths.get(uploadFilePath);
		        Files.write(path, bytes);
		        newPict.setName(uploadFilePath);
			}
		    return newPict;
		} else { // this is to replace existing picture
			if ((oldPict.getName()==null) || oldPict.getName().isEmpty()) { // blank file name means store pict in DB
				oldPict.setData(file.getBytes());
				oldPict.setType(file.getContentType());
			} else {  // otherwise store in file system
		        String uploadFilePath = oldPict.getName();
		        Path path = Paths.get(uploadFilePath);
				Files.delete(path);
		        Files.write(path, file.getBytes());
			}
		    return oldPict;
		}
	  }

	  public Picture getPicture(long pictId) {
	    return pictureDao.getPictureByPictId(pictId);
	  }

	  public void delPicture(long pictId) {
		  
		    Picture pict = pictureDao.getPictureByPictId(pictId);
		    String fileName = pict.getName();
		    
	        try {
				pictureDao.deletePictureByPictId(pictId);
			} catch (Exception e1) {
				// if cannot delete, means this picture is associated with some other entity,
				// then do not delete the physical file
				fileName = null;
				e1.printStackTrace();
			}

		    if ((fileName!=null) && !fileName.isEmpty()) {
		    	Path path = Paths.get(fileName);
		        try {
					Files.delete(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
	  }
//	  
//	  public Stream<Picture> getAllPictures() {
//	    return pictureRepo.findAll().stream();
//	  }
	}

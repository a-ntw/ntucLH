package carDate.pict;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureDaoImpl implements PictureDao{

	@Autowired
	private PictureRepo pictureRepo;
	
//	@Override
//	public List<Picture> getAllPictures() {
//		return pictureRepo.findAll();
//	}
//
//	@Override
//	public Picture savePicture(Picture picture) {
//		return pictureRepo.save(picture);
//	}

	@Override
	public Picture getPictureByPictId(long pictId) {
		Optional <Picture> optional = pictureRepo.findById(pictId);
		Picture myPict = null;
		if (optional.isPresent()) myPict = optional.get();
		return myPict;
	}

	@Override
	public void deletePictureByPictId(long pictId) {
		pictureRepo.deleteById(pictId);
		
	}
//
//	@Override
//	public Picture getPictureByName(String name) {
//		Picture picture = pictureDao.getPictureByName(name);
//		return picture;
//	}

}


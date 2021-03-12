package carDate.pict;

//import java.util.List;

public interface PictureDao {

//	public List<Picture> getAllPictures();
//	public Picture savePicture(Picture picture);
	public Picture getPictureByPictId(long pictId);
//	public Picture getPictureByName(String name);
	public void deletePictureByPictId(long pictId);

}

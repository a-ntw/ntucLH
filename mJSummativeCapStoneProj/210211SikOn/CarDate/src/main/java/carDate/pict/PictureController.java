package carDate.pict;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

import carDate.Home;

@Api(value = "PictureController", description = "Picture controllers")
@Controller
@ControllerAdvice
public class PictureController {

	@Autowired
	private Home home;
	
	@Autowired
	private PictureStorageService storageService;
	
	@GetMapping("/pictGet/{pictId}")
	@ResponseBody
	void pictGetPict(@PathVariable("pictId") Long pictId, HttpServletResponse response)
			throws ServletException, IOException {

		if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {
			response.getOutputStream().close();
		} else {
			Picture myPict = storageService.getPicture(pictId);
		    String fileName = myPict.getName();
			response.setContentType(myPict.getType());
			if ((fileName==null) || fileName.isEmpty()) {
				response.getOutputStream().write(myPict.getData());
			} else {
		    	Path path = Paths.get(fileName);
		        try {
					response.getOutputStream().write(Files.readAllBytes(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			response.getOutputStream().close();
		}
	}

}

package carDate.veh;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import carDate.Home;
import carDate.cust.Customer;
import carDate.cust.CustomerDao;
import carDate.pict.Picture;
import carDate.pict.PictureStorageService;
import carDate.pict.UploadForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@Api(value = "VehicleController", description = "Vehicle maintenance")
	@Controller
	public class VehicleController {

		@Autowired
		private Home home;

		@Autowired
		private CustomerDao customerDao;

		@Autowired
		private VehicleDao vehicleDao;

		@Autowired
		private VehStatusRepo vehStatusRepo;

		@Autowired
		private PictureStorageService storageService;

		String currFunc;
		int currPage;
		int totalPages;
		int pageSize;
		int nextPageSize;
		String sortField;
		String sortDirection;
		long pinCustId;
		long pinVehId;
		long pictsVehId;
		
		private boolean loadSessionAttributes(HttpSession session) {
			currFunc = (session.getAttribute("currFunc")==null)?"":(String) session.getAttribute("currFunc");
			if (!currFunc.equals("veh")) {
				currFunc = "veh";
				session.setAttribute("currFunc", currFunc);
			}
			
			currPage = (session.getAttribute("vehCurrPage")==null)?1:(int) session.getAttribute("vehCurrPage");
			session.setAttribute("vehCurrPage", currPage);
			
			totalPages = (session.getAttribute("vehTotalPages"))==null?1:(int) session.getAttribute("vehTotalPages");
			session.setAttribute("vehTotalPages", totalPages);

			pageSize = (session.getAttribute("vehPageSize")==null)?5:(int) session.getAttribute("vehPageSize");
			session.setAttribute("vehPageSize", pageSize);

			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("vehNextPageSize", nextPageSize);

			sortField = (session.getAttribute("vehSortField")==null)?"vehId":(String) session.getAttribute("vehSortField");
			session.setAttribute("vehSortField", sortField);
			
			sortDirection = (session.getAttribute("vehSortDirection")==null)?"ASC":(String) session.getAttribute("vehSortDirection");
			session.setAttribute("vehSortDirection", sortDirection);

			pinCustId = (session.getAttribute("pinCustId")==null)?0:(long) session.getAttribute("pinCustId");
			session.setAttribute("pinCustId", pinCustId);

			pinVehId = (session.getAttribute("pictsVehId")==null)?0:(long) session.getAttribute("pictsVehId");
			session.setAttribute("pictsVehId", pictsVehId);

			pinVehId = (session.getAttribute("pinVehId")==null)?0:(long) session.getAttribute("pinVehId");
			session.setAttribute("pinVehId", pinVehId);

			return true;
		}

		
		@GetMapping("/vehPage/{pageMvnt}")
		public String vehPaginated(@PathVariable(value="pageMvnt") int pageMvnt,
				Model model, 
				HttpSession session) {
			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			switch (pageMvnt) {
			    case -9: currPage = 1; break;                            // go to first page
			    case -1: currPage = currPage > 1? currPage - 1:1; break; // go to prev page  
			    case  0: break;                                          // stay at curr page
			    case  1: currPage = currPage < totalPages? currPage + 1:totalPages; break;  // go to next page
			    case  9: currPage = totalPages; break;                   // go to last page
			    default: currPage = 1;
			}

			Customer pinCust = new Customer();
			if (pinCustId>0) {
				pinCust = customerDao.getCustomerById(pinCustId);
			}
			pinCustId = pinCust.getCustId();
			model.addAttribute("pinCust", pinCust);
			model.addAttribute("pinCustId", pinCustId);
			
			Vehicle pinVeh = new Vehicle();
			if (pinVehId>0) {
				pinVeh = vehicleDao.getVehicleById(pinVehId);
			}
			pinVehId = pinVeh.getVehId();
			model.addAttribute("pinVeh", pinVeh);
			model.addAttribute("pinVehId", pinVehId);


			Vehicle pictsVeh = new Vehicle();
			if (pictsVehId>0) {
				pictsVeh = vehicleDao.getVehicleById(pictsVehId);
			}
			pictsVehId = pictsVeh.getVehId();
			session.setAttribute("pictsVehId", pictsVehId);
			model.addAttribute("pictsVeh", pictsVeh);
			List<Picture> listVehPicts = null;
			
			if (pictsVehId>0) {listVehPicts = List.copyOf(pictsVeh.getPictures());}
			model.addAttribute("listVehPicts", listVehPicts);

			
			List<VehStatus> listVehStatus = vehStatusRepo.findAll();
			model.addAttribute("listVehStatus", listVehStatus);

			Vehicle newVeh = (Vehicle)model.getAttribute("newVeh");
			if (newVeh==null) {
				newVeh = new Vehicle();
				newVeh.setVehStatus(vehStatusRepo.findByName("FREE"));
				model.addAttribute("newVeh", newVeh);
			}
			
			session.setAttribute("vehCurrPage", currPage);
			System.out.println("currPage:" + currPage + " pageSize:" + pageSize + " sortField:" + sortField + " sortDirection:"+ sortDirection);

			Page <Vehicle> page = vehicleDao.vehPaginated(currPage, pageSize, sortField, sortDirection);
			session.setAttribute("vehTotalPages", page.getTotalPages());
			if ((currPage > 1) && (currPage > page.getTotalPages())) {return vehPaginated(9, model, session);}
			List <Vehicle> listVehs = page.getContent();
			model.addAttribute("listVehs", listVehs);
			session.setAttribute("vehTotalItems", page.getTotalElements());
			session.setAttribute("empName", home.getEmpName());
			return "Vehicles";
		}
		

		@GetMapping("/vehSort/{sortField}")
		//change sortField, if same sortField given, change the sort direction
		public String vehSort(@PathVariable(value="sortField") String newSortField, 
				Model model, 
				HttpSession session) {
			
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			if (newSortField.equals(sortField)) {
				// if sortDirection reversed, mirror the page number so records currently on screen continue to be visible
				currPage = (totalPages==0)?1:totalPages - currPage + 1;
				sortDirection = sortDirection.equalsIgnoreCase("ASC")?"DESC":"ASC";
			} else {  
				// if sortField is changed: go to page 1 and change sort order to  Asc
				sortField = newSortField;
				currPage = 1;
				sortDirection = "ASC";
			}
			
			session.setAttribute("vehCurrPage", currPage);
			session.setAttribute("vehSortField", sortField);
			session.setAttribute("vehSortDirection", sortDirection);
			return vehPaginated(0, model, session);
		}


		@GetMapping("/vehPageSize/{newPageSize}")
		public String vehPageSize(@PathVariable(value="newPageSize") int newPageSize,
				Model model, 
				HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}
			// when page size is changed, current page is adjusted so that most of the 
			// records currently visible continue to appear in the new page.
			currPage = (((currPage - 1) * pageSize + 1) / newPageSize) + (((((currPage - 1) * pageSize + 1) % newPageSize)==0)?0:1);
			pageSize = newPageSize; 
			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("vehCurrPage", currPage);
			session.setAttribute("vehPageSize", pageSize);
			session.setAttribute("vehNextPageSize", nextPageSize);
			return vehPaginated(0, model, session);
		}

		
		@GetMapping("/vehPin/{theVehId}")
		public String vehPin(@PathVariable(value = "theVehId") long theVehId, 
	            Model model, HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}

			if (theVehId >= 0) {
				// when theVehId is 0, unpin the pinned vehicle
				// when theVehId is >0, make it the pinned vehicle
				pinVehId = theVehId;
				Vehicle pinVeh = new Vehicle();
				if (pinVehId > 0) {
					pinVeh = vehicleDao.getVehicleById(pinVehId);
				} else {
					pinVehId = 0;
				}
				pinVehId = pinVeh.getVehId();
				model.addAttribute("pinVeh", pinVeh);
				session.setAttribute("pinVehId", pinVehId);
			} 
			return vehPaginated(0, model, session);
		}

		
		@GetMapping("/vehPicts/{theVehId}")
		// this method is to store a vehId of nominated Vehicle, so that its pictures will be retrieved
		// to be loaded onto Vehicles.html.
		// Once on Vehicles.html, the pictures can be presented in slideshow style on a modal
		// and user can selectively replace, delete, or add more pictures.
		public String vehPicts(@PathVariable(value = "theVehId") long theVehId, 
	            Model model, HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}

			pictsVehId = theVehId;
			session.setAttribute("pictsVehId", pictsVehId);
			
			return vehPaginated(0, model, session);
		}

		
		@GetMapping("/vehPinCust/{theCustId}")
		public String vehPinCust(@PathVariable(value = "theCustId") long theCustId, 
	            Model model, HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Customer pinCust = new Customer();
			if (theCustId == 0) {
				// when theCustId is 0, unpin the pinned Customer
				pinCustId = 0;
				model.addAttribute("pinCust", pinCust);
				session.setAttribute("pinCustId", pinCustId);
			} else {
				if (theCustId > 0) {   // otherwise, pin theCustId instead
					pinCust = customerDao.getCustomerById(theCustId);
					pinCustId = pinCust.getCustId();
					model.addAttribute("pinCust", pinCust);
					session.setAttribute("pinCustId", pinCustId);
				}
			}
			return vehPaginated(0, model, session);
		}

		
		@ApiOperation(value="Brings high-lighted vehicle record to editing area for edit", response=Iterable.class, tags="home")
		@GetMapping("/vehUpdaOts/{vehId}")
		public String vehUpdaOts(@PathVariable(value = "vehId") long vehId, 
				Model model, 
				HttpSession session) {

			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// Get vehicle from the Service
			Vehicle newVeh = new Vehicle();
			
			if (vehId == 0) {
				// this method is not expected to be invoked with vehId=0
			} else {
				if (vehId > 0) {  // bring details of existing vehicle into input area for editing
					Vehicle veh = vehicleDao.getVehicleById(vehId);
					newVeh.setVehId(veh.getVehId());
					newVeh.setVehModel(veh.getVehModel());
					newVeh.setVehBrand(veh.getVehBrand());
					newVeh.setEngCap(veh.getEngCap());
					newVeh.setBhp(veh.getBhp());
					newVeh.setTopSpeed(veh.getTopSpeed());
					newVeh.setVehLicPlate(veh.getVehLicPlate());
					newVeh.setCurrHire(veh.getCurrHire());
					newVeh.setVehStatus(veh.getVehStatus());
					newVeh.setDailyRate(veh.getDailyRate());
					newVeh.setHires(veh.getHires());
					model.addAttribute("optMsg", "Modify vehicle record and then click <Save>.");
				} else { // copy details of an existing user into input area for editing into a new Vehicle
					Vehicle veh = vehicleDao.getVehicleById(-vehId);
					newVeh.setVehModel(veh.getVehModel());
					newVeh.setVehBrand(veh.getVehBrand());
					newVeh.setEngCap(veh.getEngCap());
					newVeh.setBhp(veh.getBhp());
					newVeh.setTopSpeed(veh.getTopSpeed());
					newVeh.setVehStatus(vehStatusRepo.findByName("FREE"));
					newVeh.setDailyRate(veh.getDailyRate());
					model.addAttribute("optMsg", "Enter required details and then click <Save>.");
				}
			}
			model.addAttribute("newVeh", newVeh);
			return vehPaginated(0, model, session);
		}

		
		@PostMapping("/vehSaveOts")	
		public String vehSaveOts(@Valid @ModelAttribute("newVeh")Vehicle newVeh, BindingResult bindingResult, 
				Model model, 
				HttpSession session) {

			if (!home.hasRole("MANAGER")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}
			
			if (bindingResult.hasErrors()) {
				model.addAttribute("optMsg", "Please correct the validation errors.");
				return vehPaginated(0, model, session);
			}

			if (newVeh.getVehId()==0) {
				if ((!newVeh.getVehStatus().equals(vehStatusRepo.findByName("FREE"))) && !newVeh.getVehStatus().equals(vehStatusRepo.findByName("SUSPENDED"))) {
					model.addAttribute("optMsg", "New vehicles can only be added with status FREE or SUSPENDED.");
					return vehPaginated(0, model, session);
				}
			} else {
				Vehicle oldVeh = vehicleDao.getVehicleById(newVeh.getVehId());
				if (oldVeh.getVehStatus().equals(vehStatusRepo.findByName("HIRED"))) {
					if (newVeh.getVehStatus()!=oldVeh.getVehStatus()) {
						model.addAttribute("optMsg", "Status of hired Vehicle cannot be changed.");
						return vehPaginated(0, model, session);
					}
				} else {
					if (!(newVeh.getVehStatus().equals(vehStatusRepo.findByName("FREE"))) && !(newVeh.getVehStatus().equals(vehStatusRepo.findByName("SUSPENDED")))) {
						model.addAttribute("optMsg", "Vehicls not Hired cannot only toggle status between FREE and SUSPENDED.");
						return vehPaginated(0, model, session);
					}
				}
			}
			
			Vehicle saveVeh = new Vehicle();
			if (newVeh.getVehId()>0) {
				saveVeh = vehicleDao.getVehicleById(newVeh.getVehId());
			}
			saveVeh.setBhp(newVeh.getBhp());
			saveVeh.setDailyRate(newVeh.getDailyRate());
			saveVeh.setEngCap(newVeh.getEngCap());
			saveVeh.setTopSpeed(newVeh.getTopSpeed());
			saveVeh.setVehBrand(newVeh.getVehBrand());
			saveVeh.setVehLicPlate(newVeh.getVehLicPlate());
			saveVeh.setVehModel(newVeh.getVehModel());
			saveVeh.setVehStatus(newVeh.getVehStatus());
			try {
				vehicleDao.saveVehicle (saveVeh);
			} catch(DataIntegrityViolationException e) {
				e.printStackTrace();
				model.addAttribute("optMsg", "There is another Vehicle with the same license plate, or other problems, please correct the data and retry.");
				model.addAttribute("newVeh", newVeh);
				return vehPaginated(0, model, session);
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("optMsg", e.getMessage());
				model.addAttribute("newVeh", newVeh);
				return vehPaginated(0, model, session);
			}

			newVeh = new Vehicle();
			model.addAttribute("newVeh", null);
			return vehPaginated(0, model, session); 
		}



		@PostMapping("/vehAddPictJs")	
		// add a picture to set of pictures of vehicle
		public ResponseEntity<?> vehAddPictJs(@ModelAttribute UploadForm form) {

			long vehId = form.getEntityId();

			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {
				return new ResponseEntity<>("You are not authorised to upload pictures.", HttpStatus.UNAUTHORIZED);
			}

			if ((form.getFile()==null) || (form.getFile().getOriginalFilename().isEmpty())) {
			    return new ResponseEntity<>("No file selected.", HttpStatus.BAD_REQUEST);
			}

			if (form.getFile().getSize()==0) {
			    return new ResponseEntity<>("Uploaded file has no data.", HttpStatus.BAD_REQUEST);
			}

			Vehicle myVeh = vehicleDao.getVehicleById(vehId);
			if (myVeh==null) {
			    return new ResponseEntity<>("Vehicle " + vehId + " does not exist.", HttpStatus.BAD_REQUEST);
			}

			Picture newPict = new Picture();
			
			try {
				newPict = storageService.store(form.getFile(),0,false);
		    } catch (Exception e) {
				e.printStackTrace();
			    return new ResponseEntity<>("Could not upload the file: " + form.getFile().getOriginalFilename() + "!", HttpStatus.BAD_REQUEST);
		    }

			myVeh.getPictures().add(newPict);

			return new ResponseEntity<String>("" + newPict.getPictId(), HttpStatus.OK);

		}
		


		@PostMapping("/vehReplPictJs")	
		// add a picture to set of pictures of vehicle
		public ResponseEntity<?> vehReplPictJs(@ModelAttribute UploadForm form) {
			
			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {
				return new ResponseEntity<>("You are not authorised to upload pictures.", HttpStatus.UNAUTHORIZED);
			}

			long pictId = form.getId();
			long vehId = form.getEntityId();

			if ((form.getFile()==null) || (form.getFile().getOriginalFilename()==null) || (form.getFile().getOriginalFilename().isEmpty())) {
			    return new ResponseEntity<>("No file selected.", HttpStatus.BAD_REQUEST);
			}

			if (form.getFile().getSize()==0) {
			    return new ResponseEntity<>("Uploaded file has no data.", HttpStatus.BAD_REQUEST);
			}

			Vehicle myVeh = vehicleDao.getVehicleById(vehId);
			if (myVeh==null) {
			    return new ResponseEntity<>("Vehicle " + vehId + " does not exist.", HttpStatus.BAD_REQUEST);
			}

			Picture newPict = new Picture();
			
			try {
				newPict = storageService.store(form.getFile(),pictId,false);
		    } catch (Exception e) {
				e.printStackTrace();
			    return new ResponseEntity<>("Could not upload the file: " + form.getFile().getOriginalFilename() + "!", HttpStatus.BAD_REQUEST);
		    }

			return new ResponseEntity<String>("Picture by id " + newPict.getPictId() + " replaced.", HttpStatus.OK);

		}

		

		@GetMapping("/vehProfPictJs/{pictId}")	
		// add a picture to set of pictures of vehicle
		public ResponseEntity<?> vehProfPict(@PathVariable(value="pictId") long pictId,
					HttpSession session) {
			
			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {
				return new ResponseEntity<>("You are not authorised to change profile pictures.", HttpStatus.UNAUTHORIZED);
			}
			
			if (!loadSessionAttributes(session)) {
			    return new ResponseEntity<>("System problem.", HttpStatus.BAD_REQUEST);
			}

			pictsVehId = (long) session.getAttribute("pictsVehId");

			Vehicle myVeh = vehicleDao.getVehicleById(pictsVehId);
			if (myVeh==null) {
			    return new ResponseEntity<>("Vehicle " + pictsVehId + " does not exist.", HttpStatus.BAD_REQUEST);
			}

			Picture newPict = storageService.getPicture(pictId);
			if (newPict==null) {
			    return new ResponseEntity<>("Picture " + newPict.getPictId() + " does not exist.", HttpStatus.BAD_REQUEST);
			}

			long oldPictId;
			Picture oldPict = myVeh.getPicture();
			if (oldPict==null) {
				oldPictId = 0;
			} else {
				oldPictId = oldPict.getPictId();
				if (oldPictId==pictId) {
				    return new ResponseEntity<>("Vehicle " + pictsVehId + " already has picture " + pictId + " as profile picture.", HttpStatus.BAD_REQUEST);
				}
			}
			
			myVeh.setPicture(newPict);
			vehicleDao.saveVehicle(myVeh);

		    return new ResponseEntity<>("" + oldPictId, HttpStatus.OK);

		}

		
		@GetMapping("/vehRmvPictJs/{pictId}")
		public ResponseEntity<?> vehRmvPictJs(@PathVariable long pictId,
				HttpSession session) {

			pictsVehId = (long) session.getAttribute("pictsVehId");
			
			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {
				return new ResponseEntity<>("You are not authorised to delete pictures.", HttpStatus.UNAUTHORIZED);
			}

			Vehicle myVeh = vehicleDao.getVehicleById(pictsVehId);
			if (myVeh==null) {
			    return new ResponseEntity<>("Vehicle " + pictsVehId + " does not exist.", HttpStatus.BAD_REQUEST);
			}
			Picture myPict = myVeh.getPicture();
			if (myPict!=null && myPict.getPictId()==pictId) {
				myVeh.setPicture(null);
			}

			Set<Picture> myPictures = myVeh.getPictures();
			for (Iterator<Picture> iterator = myPictures.iterator(); iterator.hasNext();) {
			    Picture onePict =  iterator.next();
			    if (onePict.getPictId() == pictId) {
			        iterator.remove();
			    }
			}
			
			myVeh.setPictures(myPictures);
			storageService.delPicture(pictId);
		    return new ResponseEntity<>("Vehicle " + pictsVehId + " has picture " + pictId + " deleted.", HttpStatus.OK);
		}

		
		@GetMapping("/vehDeleOts/{vehId}")
		public String vehDeleOts(@PathVariable(value = "vehId") long vehId,
				Model model, 
				HttpSession session) {
			if (!home.hasRole("MANAGER")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Vehicle myVeh = vehicleDao.getVehicleById(vehId);
			if (myVeh==null) {
				model.addAttribute("optMsg", "Vehicle by id [" + vehId + "] does not exist.");
				return vehPaginated(0, model, session);
			}
			if (myVeh.getCurrHire()!=null) {
				model.addAttribute("optMsg", "Vehicle is currently on Hire, record cannot be deleted.");
				return vehPaginated(0, model, session);
			}
			if (myVeh.getHires().size()>0) {
				model.addAttribute("optMsg", "Vehicle has associated Hire history, they must be removed before the Vehicle can be deleted.");
				return vehPaginated(0, model, session);
			}
			if (myVeh.getPicture()!=null) {
				model.addAttribute("optMsg", "Vehicle has associated profile picture, it must be removed before the Vehicle can be deleted.");
				return vehPaginated(0, model, session);
			}
			if (myVeh.getPictures().size()>0) {
				model.addAttribute("optMsg", "Vehicle has associated pictures, they must be removed before the Vehicle can be deleted.");
				return vehPaginated(0, model, session);
			}
			// call delete vehicle method 
			try {
				vehicleDao.deleteVehicleById(vehId);
			} catch(DataIntegrityViolationException e) {
				e.printStackTrace();
				model.addAttribute("optMsg", "Encounter some technical problem, please report to IT.  This Vehicle cannot be deleted.");
				return vehPaginated(0, model, session);
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("optMsg", e.getMessage());
				return vehPaginated(0, model, session);
			}
			return vehPaginated(0, model, session);
		}

	
}

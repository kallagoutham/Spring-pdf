package spring.file.Controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import spring.file.Model.User;
import spring.file.Service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "/users/upload")
	public String uploadUserDetails(@ModelAttribute User user,@RequestParam(name = "cv")MultipartFile cv) throws IOException {
		return userService.uploadDetails(user,cv);
	}
	
	@GetMapping(value = "/users/get/cv")
	public ResponseEntity<?> getResumeFile(@RequestParam(name = "id")Long id){
		return userService.getCv(id);		
	}
	
	@GetMapping(value = "/users/download/cv")
	public ResponseEntity<?> downloadCv(@RequestParam(name = "id")Long id){
		return userService.downloadCv(id);
	}
}

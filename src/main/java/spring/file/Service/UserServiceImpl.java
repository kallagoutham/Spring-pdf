package spring.file.Service;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spring.file.Model.User;
import spring.file.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository; 
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public String uploadDetails(User user,MultipartFile cv) throws IOException {
		user.setMyCv(cv.getBytes());
		if(userRepository.save(user)!=null) {
			return "User Details uploaded successfully";
		}
		return "Failed to save User Details";
	}

	@Override
	public ResponseEntity<?> getCv(Long id) {
		User user = userRepository.findById(id).orElse(null);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		return new ResponseEntity<>(user.getMyCv(),headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> downloadCv(Long id){
		User user = userRepository.findById(id).orElse(null);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
				.contentType(MediaType.APPLICATION_PDF)
				.contentLength(user.getMyCv().length)
				.body(user.getMyCv());
	}
}

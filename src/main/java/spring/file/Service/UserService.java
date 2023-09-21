package spring.file.Service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import spring.file.Model.User;

public interface UserService {

	String uploadDetails(User user, MultipartFile cv) throws IOException;
	ResponseEntity<?> getCv(Long id);
	ResponseEntity<?> downloadCv(Long id);

}

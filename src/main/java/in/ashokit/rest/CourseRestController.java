package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Course;
import in.ashokit.service.CourseService;

@RestController
public class CourseRestController {
	@Autowired
	private CourseService cservice;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course){
		String status = cservice.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourseById(@PathVariable Integer cid){
		Course course = cservice.getById(cid);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> courses = cservice.getAll();
		return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course){
		String status = cservice.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/course")
	public ResponseEntity<String> deleteById(@RequestParam("cid") Integer cid){
		String status = cservice.deleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}

}

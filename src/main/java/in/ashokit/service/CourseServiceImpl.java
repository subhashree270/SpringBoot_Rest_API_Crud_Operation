package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Course;
import in.ashokit.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepo crepo;
	
	@Override
	public String upsert(Course course) {
	crepo.save(course);
		return "Success";
	}
	
	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = crepo.findById(cid);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	@Override
	public List<Course> getAll() {
		return crepo.findAll();
		
	}
	@Override
	public String deleteById(Integer cid) {
		if(crepo.existsById(cid)) {
			crepo.deleteById(cid);
			return "Delete Success";
		}
		else {
		return "No record found";
		}
	}

}

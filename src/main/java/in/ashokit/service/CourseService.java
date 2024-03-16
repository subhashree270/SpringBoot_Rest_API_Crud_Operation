package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Course;

public interface CourseService {
	
	public String upsert (Course course);
	public Course getById(Integer cid);
	public List<Course> getAll();
	public String deleteById(Integer cid);

}

package edu.cjc.sma.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.cjc.sma.app.model.Student;
import edu.cjc.sma.app.repository.StudentRepository;

@Service
public class StudentService implements StudentserviceInt {

	@Autowired
	StudentRepository sr;
	
	@Override
	public void saveData(Student s) {
		sr.save(s);	
		
	}

	@Override
	public List<Student> getAllStudent() {
		
		return sr.findAll();
	}

	@Override
	public void removeStudent(int studentId) {
		sr.deleteById(studentId);
		
	}

	@Override
	public List<Student> getStudentsByBatch(String batchNumber) {
		
		return sr.findAllByBatchNumber(batchNumber);
	}

	@Override
	public List<Student> paging(int pageNo, int size) {
		List<Student> l =sr.findAll(PageRequest.of(pageNo, size)).getContent();
		
		return l;
	}

	@Override
	public Student getSingleStudent(int studentId) {
		
		return sr.findById(studentId).get();
	}

	@Override
	public void updateStudentFees(int studentId, double ammount) {
		Student s =sr.findById(studentId).get();
		s.setFeesPaid(s.getFeesPaid() +ammount);
		sr.save(s);
		
		
	}

	@Override
	public Student shiftingBatch(int studentId) {
	
		return sr.findById(studentId).get();
	}

	@Override
	public void saveBatch(int studentId, String batchNumber) {
		 Student s = sr.findById(studentId).get();
		s.setBatchNumber(batchNumber);
		sr.save(s);
		
	}

}

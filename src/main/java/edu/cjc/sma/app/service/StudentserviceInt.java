package edu.cjc.sma.app.service;

import java.util.List;

import edu.cjc.sma.app.model.Student;

public interface StudentserviceInt {

	public void saveData(Student s);
	public List<Student>getAllStudent();
	public void removeStudent(int studentId);
	public List<Student> getStudentsByBatch(String batchNumber);
	public List<Student> paging(int pageNo, int size);
	public Student getSingleStudent(int studentId);
	public void updateStudentFees(int studentId, double ammount);
	public Student shiftingBatch(int studentId);
	public void saveBatch(int studentId,String batchNumber);

}

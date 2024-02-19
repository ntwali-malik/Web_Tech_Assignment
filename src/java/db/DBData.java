/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.List;
import model.StudentModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author N.Maliki
 */
public class DBData {
    public List<StudentModel> getAllStudentModels() {

		List<StudentModel> studentModels = new ArrayList<>();

		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();

		Query query = session.createQuery("from StudentModel stud");
		studentModels = query.list();

		return studentModels;

	}

	public void saveStudent(StudentModel stud) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.save(stud);
		t.commit();
		System.out.println("inserted.......");
	}

	public void updateStudent(StudentModel stud) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.update(stud);
		t.commit();
		System.out.println("updated....");
	}

	public void deleteStudent(StudentModel stud) {
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.delete(stud);
		t.commit();
		System.out.println("deleted....");
	}
	
	public StudentModel getStudentById(int id){
		
		String query = "from StudentModel stud where stud.studentId="+id;
		
		FactoryConnection fac = new FactoryConnection();
		Session session = fac.getSessionFactory().openSession();
		
		Query query2 = session.createQuery(query);
		
		StudentModel stud = (StudentModel) query2.list().get(0);
		
		return stud;
	}
}


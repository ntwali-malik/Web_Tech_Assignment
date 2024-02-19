/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.DBData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentModel;

/**
 *
 * @author N.Maliki
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		System.out.println("***************************");
		System.out.println("*    Welcome to Servlet   *");
		System.out.println("***************************");
		
		RequestDispatcher rd = null;
		DBData db = new DBData();
		
		if(req.getParameter("action") != null){
			
			if(req.getParameter("action").toString().equals("new")){
				
				StudentModel stud = new StudentModel();
				req.setAttribute("student", stud);
				req.setAttribute("action", "new");
				rd = req.getRequestDispatcher("/register.jsp");
		
			}else if(req.getParameter("action").toString().equals("update")){
				
				int id = Integer.parseInt(req.getParameter("id").toString());
				System.out.println("ID:: "+id);
				
				StudentModel stud= db.getStudentById(id);
				req.setAttribute("student", stud);
				req.setAttribute("action", "update");
				rd = req.getRequestDispatcher("/register.jsp");
				
			}else if(req.getParameter("action").toString().equals("delete")){
				
				int id = Integer.parseInt(req.getParameter("id").toString());
				System.out.println("ID:: "+id);
				StudentModel stud = new StudentModel();
				stud.setStudentId(id);
				
				db.deleteStudent(stud);
				System.out.println("succefully deletd...");
				
				List<StudentModel> getStudentModels = db.getAllStudentModels();
				req.setAttribute("students", getStudentModels);
				rd = req.getRequestDispatcher("/index.jsp");
			}
			
		}else{
			
			List<StudentModel> getStudentModels = db.getAllStudentModels();
			req.setAttribute("students", getStudentModels);
			rd = req.getRequestDispatcher("/index.jsp");
		}
		
		

		rd.forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String action = req.getParameter("action").toString();
		RequestDispatcher rd = null;
		if(action.equals("new")){
			
			StudentModel stud = new StudentModel();
			stud.setName(req.getParameter("name").toString());
			stud.setEmail(req.getParameter("email").toString());
			stud.setFaculty(req.getParameter("faculty").toString());
			stud.setDepartment(req.getParameter("department").toString());
			
			DBData db = new DBData();
			db.saveStudent(stud);
			
			List<StudentModel> getStudentModels = db.getAllStudentModels();
			req.setAttribute("students", getStudentModels);
			rd = req.getRequestDispatcher("/index.jsp");
		}else if(action.equals("update")){
			
			StudentModel stud = new StudentModel();
			stud.setName(req.getParameter("name").toString());
			stud.setEmail(req.getParameter("email").toString());
			stud.setFaculty(req.getParameter("faculty").toString());
			stud.setDepartment(req.getParameter("department").toString());
			
			stud.setStudentId(Integer.parseInt(req.getParameter("studentId").toString()));
			
			DBData db = new DBData();
			db.updateStudent(stud);
			
			List<StudentModel> getStudentModels = db.getAllStudentModels();
			req.setAttribute("students", getStudentModels);
			rd = req.getRequestDispatcher("/index.jsp");
			
		}
		
		rd.forward(req, resp);
	}
}

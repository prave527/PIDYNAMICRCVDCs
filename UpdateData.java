package com.demo.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dbtables.TmpReceiver;
import com.google.gson.Gson;



/**
 * Servlet implementation class UpdateData
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceUnit (unitName = "LocalDevelopment~detrcvr~demo.sap.com")
	private EntityManagerFactory emf;	

	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		
		Map <String, Object> map = new HashMap<String,Object>();	
		
		boolean isValid = false;
		String filename = request.getParameter("filename");
		String receiver = request.getParameter("receiver");
		
		if (filename != null && filename.trim().length() != 0
		&& receiver != null && receiver.trim().length() != 0 ){
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		TmpReceiver data = new TmpReceiver();

		
		data.setFilename(filename);
		data.setReceiver(receiver);
		em.persist(data);
		em.flush();
		em.getTransaction().commit();
		
		isValid = true;
		map.put("isValid",isValid);
	}
		write(response, map);		

		
		
	}
	
	private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
		}
	

}

package com.demo.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class RetrieveData
 */
public class RetrieveData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceUnit (unitName = "LocalDevelopment~detrcvr~demo.sap.com")
private EntityManagerFactory emf;	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = emf.createEntityManager();	 	
		List<TmpReceiver> allData = em.createQuery("SELECT e FROM TmpReceiver e").getResultList();

    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(new Gson().toJson(allData));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

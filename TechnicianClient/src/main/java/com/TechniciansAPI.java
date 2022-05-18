package com;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class ItemsAPI
 */
@WebServlet("/TechniciansAPI")
public class TechniciansAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Technician techObj = new Technician();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TechniciansAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = techObj.insertTechnician(request.getParameter("name"),
				request.getParameter("address"),
				request.getParameter("email"),
				request.getParameter("phone"),
				request.getParameter("type"),
				request.getParameter("salary"),
				request.getParameter("hourlywage"));
		
		response.getWriter().write(output);
	}
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = techObj.updateTechnician(paras.get("hidItemIDSave").toString(),
		paras.get("name").toString(),
		paras.get("address").toString(),
		paras.get("email").toString(),
		paras.get("phone").toString(),
		paras.get("type").toString(),
		paras.get("salary").toString(),
		paras.get("hourlywage").toString());
		response.getWriter().write(output);
	}
	

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = techObj.deleteTechnician(paras.get("TechnicianID").toString());
		response.getWriter().write(output);
	}
	
	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params)
			{
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
			}
		catch (Exception e)
		{
			
		}
		return map;
	}


}

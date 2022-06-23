package com.m2m.onousc.web.referentiel.mbean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DynamicImageServlet
 */
public class DynamicImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DynamicImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{

		try {

			// Get image file.
			BufferedInputStream in ;
			String file = request.getParameter("file");
			File image = new File("/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + file);
			if (image.exists())
			      in = new BufferedInputStream(new FileInputStream("/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + file));
			else
				in = new BufferedInputStream(new FileInputStream("/opt/Carte_UCAD/Photos_Porteurs/Etudiants/" + "user_form.png"));
			// Get image contents.
			byte[] bytes = new byte[in.available()];

			in.read(bytes);
			in.close();

			// Write image contents to response.
			response.getOutputStream().write(bytes);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

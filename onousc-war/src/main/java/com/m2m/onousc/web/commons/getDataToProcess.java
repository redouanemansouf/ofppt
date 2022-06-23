package com.m2m.onousc.web.commons;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2m.technicalservices.web.SpecificParams;
import com.m2m.technicalservices.web.UserSession;

@WebServlet("/getDataToProcess")
public class getDataToProcess extends HttpServlet{
	
	private static final long serialVersionUID = 6437505667181514125L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String data = "";

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		UserSession userSessionHelper = (UserSession) request.getSession()
				.getAttribute(SpecificParams.USER_SESSION);

		while (userSessionHelper.getSpecificParams().get(SpecificParams.READY) == null 
				||  !(Boolean)userSessionHelper.getSpecificParams().get(SpecificParams.READY)) {
			try {
				TimeUnit.MILLISECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("doPost error :" + e); 
			}
		}
		
		if ((request.getParameter("typeRequest") != null)
				&& (Boolean.valueOf(request.getParameter("typeRequest")))) {
			try {
				data = (String) userSessionHelper.getSpecificParams().get(
						SpecificParams.DATA_TO_SEND);
			} catch (Exception e) {
				System.out.println("ATTRIBUTE NOT FOUND" + e);
				return;
			}
			response.getOutputStream().write(data.getBytes());
		} else {
			if (((String) request.getParameter("State")).equals("FINISHED")) {
				
				
				if(request.getParameter("error") != null){
					userSessionHelper.getSpecificParams().put(
							SpecificParams.ERROR_MESSAGE, (String) request.getParameter("error"));
				}
				
				// pour la lecture de la carte
				if(request.getParameter("operation") != null){
					getDataCard(request,userSessionHelper);
				}
				
				// recupération de l'identifiant de la carte pour la personalisation
				if(request.getParameter("cardUid") != null){
					
					userSessionHelper.getSpecificParams().put(
							SpecificParams.CARD_UID, (String) request.getParameter("cardUid"));
				}
				
				userSessionHelper.getSpecificParams().put(
						SpecificParams.STATE_FINISHED, true);
				
				
				
				request.getSession().setAttribute(SpecificParams.USER_SESSION,
						userSessionHelper);

			}
			 String check = String.valueOf(userSessionHelper.getSpecificParams().get(
				        "CONTINUE"));
				      response.getOutputStream().write(check.getBytes());

		}
		

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	private void getDataCard(HttpServletRequest request,UserSession userSessionHelper){
		String operation = request.getParameter("operation");
		Map<String, String> parameters = new HashMap<String, String>();
		if(operation.equals("READETUDIANT")){
			parameters.put("porteur", request.getParameter("porteur"));
			parameters.put("apogee", request.getParameter("apogee"));
			parameters.put("nom", request.getParameter("nom"));
			parameters.put("prenom", request.getParameter("prenom"));
			parameters.put("cni", request.getParameter("cni"));
			parameters.put("cne", request.getParameter("cne"));
			parameters.put("email", request.getParameter("email"));
			parameters.put("etablissement", request.getParameter("etablissement"));
			parameters.put("cdeEtablissement", request.getParameter("cdeEtablissement"));
			parameters.put("services", request.getParameter("services"));
			parameters.put("groupe", request.getParameter("groupe"));	
			parameters.put("etape", request.getParameter("etape"));
			parameters.put("diplome", request.getParameter("diplome"));
			parameters.put("solde", request.getParameter("solde"));
			parameters.put("anneeUniv", request.getParameter("anneeUniv"));
			parameters.put("dateNaissance", request.getParameter("dateNaissance"));
			parameters.put("dateExpiration", request.getParameter("dateExpiration"));
			parameters.put("anneePremiere", request.getParameter("anneePremiere"));
			
			userSessionHelper.getSpecificParams().put(
					SpecificParams.UPLOADED_DATA, parameters);
		}
	}

}

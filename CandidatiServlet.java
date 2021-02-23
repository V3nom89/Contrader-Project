package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CandidatiDTO;

import it.contrader.service.CandidatiService;
import it.contrader.service.Service;



/**
 * Servlet implementation class CandidatiServlet
 */


public class CandidatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatiServlet() {
        
        
    }
    public void updateList(HttpServletRequest request) {
		Service<CandidatiDTO> service = new CandidatiService();
		List<CandidatiDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
    
    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CandidatiDTO> service = new CandidatiService();
		String mode = request.getParameter("mode");
		CandidatiDTO dto;
		int idCandidati = 0;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CANDIDATILIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/candidati/candidatimanager.jsp").forward(request, response);
			break;

		case "READ":
			idCandidati = Integer.parseInt(request.getParameter("idCandidati"));
			dto = service.read(idCandidati);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/candidati/readcandidati.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/candidati/updatecandidati.jsp").forward(request, response);
			
			break;

		case "INSERT":
			
			int idStaff = Integer.parseInt(request.getParameter("idStaff").toString());
			String nome = request.getParameter("nome ").toString();
			String cognome = request.getParameter("cognome").toString();
			String email = request.getParameter("email").toString();
			String luogoProvenienza = request.getParameter("luogoProvenienza").toString();
			int numeroTelefono = Integer.parseInt(request.getParameter("numeroTelefono").toString());
			String titoloStudio = request.getParameter("titoloStudio").toString();
			String titoloLaurea = request.getParameter("titoloLaurea").toString();	
			String dataCandidatura = request.getParameter("dataCandidatura").toString();
			String rangeCandidatura = request.getParameter("rangeCandidatura").toString();
			boolean colloquioConoscitivo = Boolean.parseBoolean(request.getParameter("colloquioConoscitivo").toString());
			String candidatiTramite = request.getParameter("candidatiTramite").toString();
			boolean idoneita = Boolean.parseBoolean(request.getParameter("idoneita").toString());
			String codiceFiscale = request.getParameter("codiceFiscale").toString();
			String userType = request.getParameter("userType").toString();
			
			dto = new CandidatiDTO (idStaff, nome, cognome, email, luogoProvenienza, numeroTelefono, titoloStudio,
					titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo, candidatiTramite,
					idoneita, codiceFiscale, userType);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/candidati/candidatimanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			 idStaff = Integer.parseInt(request.getParameter("idStaff").toString());
			 nome = request.getParameter("nome ").toString();
			 cognome = request.getParameter("cognome").toString();
			 email = request.getParameter("email").toString();
			 luogoProvenienza = request.getParameter("luogoProvenienza").toString();
		     numeroTelefono = Integer.parseInt(request.getParameter("numeroTelefono").toString());
			 titoloStudio = request.getParameter("titoloStudio").toString();
			 titoloLaurea = request.getParameter("titoloLaurea").toString();	
			 dataCandidatura = request.getParameter("dataCandidatura").toString();
			 rangeCandidatura = request.getParameter("rangeCandidatura").toString();
			 colloquioConoscitivo = Boolean.parseBoolean(request.getParameter("colloquioConoscitivo").toString());
			 candidatiTramite = request.getParameter("candidatiTramite").toString();
			 idoneita = Boolean.parseBoolean(request.getParameter("idoneita").toString());
			 codiceFiscale = request.getParameter("codiceFiscale").toString();
			 userType = request.getParameter("userType").toString();
			
			dto = new CandidatiDTO (idCandidati, idStaff, nome, cognome, email, luogoProvenienza, numeroTelefono, titoloStudio,
					titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo, candidatiTramite,
					idoneita, codiceFiscale, userType);
		ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/candidati/candidatimanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idCandidati = Integer.parseInt(request.getParameter("idCandidati"));
			ans = service.delete(idCandidati);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/candidati/candidatimanager.jsp").forward(request, response);
			break;
		}
	}




}

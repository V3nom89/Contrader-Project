package it.contrader.controller;

import java.util.List;

import it.contrader.dao.CorsoDAO;
import it.contrader.dto.CorsoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CorsoService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class CorsoController implements Controller {

	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "corso.";
	
	private CorsoService corsoService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public CorsoController() {
		this.corsoService = new CorsoService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e puï¿½ essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalitï¿½ corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		 int idCorso=0;
		 int idCandidato;
		 int idIterSelettivo = 0;
	     String argomentoCorso;
		 int valutazioneComunicazioni;
		 int valutazioneIntuitivita;
		 int valutazioneAttitudine;
		 int valutazioneTeamWork;
		 int oreTotali;
		 int idStaff;
		 String dataInizio;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			try {
				idCorso = Integer.parseInt(request.get(CorsoDAO.CONST.ID_CORSO).toString());
				CorsoDTO corsoDto = corsoService.read(idCorso);
				request.put("corso", corsoDto);
				MainDispatcher.getInstance().callView(sub_package + "CorsoRead", request);
			} catch (Exception e) {
				System.err.println("Errore nella lettura del membro dello Corso con id <" + idCorso + ">");
				e.printStackTrace();
			}
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			try {
				idCandidato= Integer.parseInt(request.get(CorsoDAO.CONST.ID_CANDIDATO).toString());
				
				idIterSelettivo= Integer.parseInt(request.get(CorsoDAO.CONST.ID_ITERSELETTIVO).toString());
				
				argomentoCorso= request.get(CorsoDAO.CONST.ARGOMENTO_CORSO).toString();
				
				valutazioneComunicazioni= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_COMUNICAZIONI).toString());
				valutazioneIntuitivita= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_INTUITIVITA).toString());
				valutazioneAttitudine= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_ATTITUDINE).toString());
			    valutazioneTeamWork= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_TEAMWORK).toString());
				
				oreTotali= Integer.parseInt(request.get(CorsoDAO.CONST.ORETOTALI).toString());
				
				idStaff= Integer.parseInt(request.get(CorsoDAO.CONST.ID_STAFF).toString());
				
				dataInizio= request.get(CorsoDAO.CONST.DATA_INIZIO).toString();
				
				//costruisce l'oggetto user da inserire
				CorsoDTO corsotoinsert = new CorsoDTO(idCorso,idCandidato,idIterSelettivo,argomentoCorso,valutazioneComunicazioni,valutazioneIntuitivita,valutazioneAttitudine,valutazioneTeamWork,oreTotali,idStaff,dataInizio);
				//invoca il service
				corsoService.insert(corsotoinsert);
				request = new Request();
				request.put("mode", "mode");
				//Rimanda alla view con la risposta
				MainDispatcher.getInstance().callView(sub_package + "CorsoInsert", request);
			} catch (Exception e) {
				System.err.println("Errore nell'inserimento di un componente dello corso");
				e.printStackTrace();
			}
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idCorso = Integer.parseInt(request.get("idCorso").toString());
			//Qui chiama il service
			corsoService.delete(idCorso);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CorsoDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idCorso= Integer.parseInt(request.get(CorsoDAO.CONST.ID_CORSO).toString());
			
			idCandidato= Integer.parseInt(request.get(CorsoDAO.CONST.ID_CANDIDATO).toString());
			
			idIterSelettivo= Integer.parseInt(request.get(CorsoDAO.CONST.ID_ITERSELETTIVO).toString());
			argomentoCorso= request.get(CorsoDAO.CONST.ARGOMENTO_CORSO).toString();
			
			valutazioneComunicazioni= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_COMUNICAZIONI).toString());
			valutazioneIntuitivita= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_INTUITIVITA).toString());
			valutazioneAttitudine= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_ATTITUDINE).toString());
		    valutazioneTeamWork= Integer.parseInt(request.get(CorsoDAO.CONST.VALUTAZIONE_TEAMWORK).toString());
			
			oreTotali= Integer.parseInt(request.get(CorsoDAO.CONST.ORETOTALI).toString());
			
			idStaff= Integer.parseInt(request.get(CorsoDAO.CONST.ID_STAFF).toString());
			
			dataInizio= request.get(CorsoDAO.CONST.DATA_INIZIO).toString();
			
			//costruisce l'oggetto user da inserire
			CorsoDTO corsotoupdate = new CorsoDTO(idCorso,idCandidato,idIterSelettivo,argomentoCorso,valutazioneComunicazioni,valutazioneIntuitivita,valutazioneAttitudine,valutazioneTeamWork,oreTotali,idStaff,dataInizio);
			corsotoupdate.setIdCorso(idCorso);
                        corsoService.update(corsotoupdate);
                        //invoca il service
			
			

			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CorsoUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "CORSOLIST":
			try {
				List<CorsoDTO> corso = corsoService.getAll();
				//Impacchetta la request con la lista degli user
				request.put("corso", corso);
				MainDispatcher.getInstance().callView("Corso", request);
			} catch (Exception e) {
				System.err.println("Errore nella lettura della lista di membri dello Corso");
				e.printStackTrace();
			}
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CorsoRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CorsoInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CorsoUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CorsoDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}


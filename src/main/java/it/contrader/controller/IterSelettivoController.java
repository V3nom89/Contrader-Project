package it.contrader.controller;

import it.contrader.service.IterSelettivoService;

import java.util.List;

import it.contrader.dao.IterSelettivoDAO;
import it.contrader.dto.IterSelettivoDTO;
import it.contrader.main.MainDispatcher;

public class IterSelettivoController implements Controller{

	private static String sub_package = "iterSelettivo.";
	
	private IterSelettivoService iterSelettivoService;
	
	// costruisce un oggetto di tipo iterSelettivoService per poterne usare i metodi
	public IterSelettivoController() {
		this.iterSelettivoService = new IterSelettivoService();
	}
	
	/*
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int idIterSelettivo = 0;
		int idCandidato;
		int idStaff;
		int punteggioTotaleScritto;
		int punteggioLogica;
		int punteggioPhp;
		int punteggioJava;
		int punteggioHTML;
		int punteggioInglese;
		String dataTestScritto;
		String dataTestOrale;
		int valutazioneOrale;
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			try {
				idIterSelettivo = Integer.parseInt(request.get(IterSelettivoDAO.CONST.ID_ITER_SELETTIVO).toString());
				IterSelettivoDTO iterSelettivoDTO = iterSelettivoService.read(idIterSelettivo);
				request.put("iterSelettivo", iterSelettivoDTO);
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoRead", request);
			} catch (Exception e) {
				System.err.println("Errore nella lettura del'iterSelettivo con id <" + idIterSelettivo + ">");
				e.printStackTrace();
			}
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			try {
			idCandidato = Integer.parseInt(request.get(IterSelettivoDAO.CONST.ID_CANDIDATO).toString());
			idStaff = Integer.parseInt(request.get(IterSelettivoDAO.CONST.ID_STAFF).toString());
			punteggioTotaleScritto = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_TOTALE_SCRITTO).toString());
			punteggioLogica = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_LOGICA).toString());
			punteggioPhp = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_PHP).toString());
			punteggioJava = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_JAVA).toString());
			punteggioHTML = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_HTML).toString());
			punteggioInglese = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_INGLESE).toString());
			dataTestScritto = request.get(IterSelettivoDAO.CONST.DATA_TEST_SCRITTO).toString(); 
			dataTestOrale = request.get(IterSelettivoDAO.CONST.DATA_TEST_ORALE).toString();
			valutazioneOrale = Integer.parseInt(request.get(IterSelettivoDAO.CONST.VALUTAZIONE_ORALE).toString());
			
						
			//costruisce l'oggetto user da inserire
			IterSelettivoDTO iterSelettivotoinsert = new IterSelettivoDTO(idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, dataTestOrale, valutazioneOrale);
			//invoca il service
			iterSelettivoService.insert(iterSelettivotoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "IterSelettivoInsert", request);
			} catch (Exception e) {
				System.err.println("Errore nell'inserimento dell'iter selettivo");
				e.printStackTrace();
			}
			break;
			
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idIterSelettivo = Integer.parseInt(request.get("idIterSelettivo").toString());
			//Qui chiama il service
			iterSelettivoService.delete(idIterSelettivo);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "IterSelettivoDelete", request);
			break;
			
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idIterSelettivo = Integer.parseInt(request.get(IterSelettivoDAO.CONST.ID_ITER_SELETTIVO).toString());
			idCandidato = Integer.parseInt(request.get(IterSelettivoDAO.CONST.ID_CANDIDATO).toString());
			idStaff = Integer.parseInt(request.get(IterSelettivoDAO.CONST.ID_STAFF).toString());
			punteggioTotaleScritto = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_TOTALE_SCRITTO).toString());
			punteggioLogica = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_LOGICA).toString());
			punteggioPhp = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_PHP).toString());
			punteggioJava = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_JAVA).toString());
			punteggioHTML = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_HTML).toString());
			punteggioInglese = Integer.parseInt(request.get(IterSelettivoDAO.CONST.PUNTEGGIO_INGLESE).toString());
			dataTestScritto = request.get(IterSelettivoDAO.CONST.DATA_TEST_SCRITTO).toString(); 
			dataTestOrale = request.get(IterSelettivoDAO.CONST.DATA_TEST_ORALE).toString(); 
			valutazioneOrale = Integer.parseInt(request.get(IterSelettivoDAO.CONST.VALUTAZIONE_ORALE).toString());
			//costruisce l'oggetto iterselettivo da inserire				
			IterSelettivoDTO iterSelettivotoupdate = new IterSelettivoDTO(idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, dataTestOrale, valutazioneOrale);
			iterSelettivotoupdate.setIdIterSelettivo(idIterSelettivo);
			//invoca il service
			iterSelettivoService.update(iterSelettivotoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "IterSelettivoUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "ITERSELETTIVOLIST":
			try {
			List<IterSelettivoDTO> iterSelettivoListDTO = iterSelettivoService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("iterSelettivo", iterSelettivoListDTO);
			MainDispatcher.getInstance().callView("IterSelettivo", request);
			} catch(Exception e) {
				System.err.println("Errore nel recupero della lista di candidati");
				e.printStackTrace();
			}
			break;
		
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
						
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoRead", null);
				break;
					
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoInsert", null);
				break;
					
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoUpdate", null);
				break;
					
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoDelete", null);
				break;
					
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;

		//volendo si può modificre facendolo andare in homeadminview
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
//END
}

package it.contrader.controller;

//Problema con Date

import java.util.List;

import it.contrader.dto.CandidatiDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Candidati;
import it.contrader.service.CandidatiService;

public class CandidatiController implements Controller {
	private static String sub_package = "candidati.";
	private CandidatiService candidatiService;

	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public CandidatiController() {
		this.candidatiService = new CandidatiService();
	}

	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode (che riceve
	 * dalle view specifiche e pu� essere la richesta di una scelta da parte
	 * dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalit� corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {

		// Estrae dalla request mode e choice
		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		// Definisce i campi della classe (serviranno sempre, tanto vale definirli una
		// sola volta)
		int idCandidati;
		int idStaff;
		String nome;
		String cognome;
		String email;
		String luogoProvenienza;
		int numero_telefono;
		String titoloStudio;
		String titoloLaurea;
		String dataCandidatura;
		String rangeCandidatura;
		boolean colloquioConoscitivo;
		String candidatiTramite;
		boolean idoneita;
		String codiceFiscale;
		String usertype;
		switch (mode) {

		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia
		// alla UserReadView uno user da mostrare
		case "READ":
			try {
				idCandidati = Integer.parseInt(request.get("idCandidati").toString());
				CandidatiDTO candidatiDTO = candidatiService.read(idCandidati);
				request.put("candidati", candidatiDTO);
				MainDispatcher.getInstance().callView(sub_package + "CandidatiRead", request);
			} catch (Exception e) {
				System.err.println("Errore durante la lettura dei candicati");
				e.printStackTrace();
			}
			break;

		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il
		// service per inserire uno user con questi parametri
		case "INSERT":
			try {
				idStaff = Integer.parseInt(request.get(Candidati.CONST.ID_STAFF).toString());
				nome = request.get(Candidati.CONST.NOME).toString();
				cognome = request.get(Candidati.CONST.COGNOME).toString();
				email = request.get(Candidati.CONST.EMAIL).toString();
				luogoProvenienza = request.get(Candidati.CONST.PROVENIENZA).toString();
				numero_telefono = Integer.parseInt(request.get(Candidati.CONST.TELEFONO).toString());
				titoloStudio = request.get(Candidati.CONST.TITOLO_STUDIO).toString();
				titoloLaurea = request.get(Candidati.CONST.TITOLO_LAUREA).toString();
	
				dataCandidatura = request.get(Candidati.CONST.DATA_CANDIDATURA).toString();
				rangeCandidatura = request.get(Candidati.CONST.RANGE_CANDIDATURA).toString();
				colloquioConoscitivo = Boolean.parseBoolean(request.get(Candidati.CONST.COLLOQUIO_CONOSCITIVO).toString());
				candidatiTramite = request.get(Candidati.CONST.CANDIDATI_TRAMITE).toString();
				codiceFiscale = request.get(Candidati.CONST.CODICE_FISCALE).toString();
				usertype = request.get(Candidati.CONST.USER_TYPE).toString();
				idoneita = Boolean.parseBoolean(request.get(Candidati.CONST.USER_TYPE).toString());
	
				// costruisce l'oggetto user da inserire
				CandidatiDTO candidatitoinsert = new CandidatiDTO(idStaff, nome, cognome, email, luogoProvenienza,
						numero_telefono, titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura,
						colloquioConoscitivo, candidatiTramite, idoneita, codiceFiscale, usertype);
				// invoca il service
				candidatiService.insert(candidatitoinsert);
				request = new Request();
				request.put("mode", "mode");
				// Rimanda alla view con la risposta
				MainDispatcher.getInstance().callView(sub_package + "CandidatiInsert", request);
			} catch (Exception e) {
				System.err.println("Errore nell'inserimento del candidato");
				e.printStackTrace();
			}
			break;

		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo
		// passa al Service
		case "DELETE":
			try {
				idCandidati = Integer.parseInt(request.get("idCandidati").toString());
				// Qui chiama il service
				candidatiService.delete(idCandidati);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CandidatiDelete", request);
			} catch (Exception e) {
				System.err.println("Errore nell'eliminazione del candidato");
				e.printStackTrace();
			}
			break;

		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			try {
				idCandidati = Integer.parseInt(request.get("idCandidati").toString());
				idStaff = Integer.parseInt(request.get("idStaff").toString());
				nome = request.get("nome").toString();
				cognome = request.get("cognome").toString();
				email = request.get("email").toString();
				luogoProvenienza = request.get("provenienza").toString();
				numero_telefono = Integer.parseInt(request.get("telefono").toString());
				titoloStudio = request.get("titoloStudio").toString();
				titoloLaurea = request.get("titoloLaurea").toString();
				dataCandidatura = request.get("dataCandidatura").toString();
				rangeCandidatura = request.get("rangeCandidatura").toString();
				colloquioConoscitivo = Boolean.parseBoolean(request.get("colloquioConoscitivo").toString());
				candidatiTramite = request.get("candidatiTramite").toString();
				idoneita = Boolean.parseBoolean(request.get("idoneit�").toString());
				codiceFiscale = request.get("codiceFiscale").toString();
				usertype = request.get("usertype").toString();
				CandidatiDTO candidatiinsert = new CandidatiDTO(idStaff, nome, cognome, email, luogoProvenienza,
						numero_telefono, titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura,
						colloquioConoscitivo, candidatiTramite, idoneita, codiceFiscale, usertype);
				candidatiinsert.setIdCandidati(idCandidati);
				candidatiService.update(candidatiinsert);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CandidatiUpdate", request);
			} catch (Exception e) {
				System.err.println("Errore nell'aggiornamento del candidato");
				e.printStackTrace();
			}
			break;

		// Arriva qui dalla UserView Invoca il Service e invia alla UserView il
		// risultato da mostrare
		case "CANDIDATILIST":
			try {
				List<CandidatiDTO> candidatiListDTO = candidatiService.getAll();
				// Impacchetta la request con la lista degli user
				request.put("candidati", candidatiListDTO);
				MainDispatcher.getInstance().callView("Candidati", request);
			} catch(Exception e) {
				System.err.println("Errore nel recupero della lista di candidati");
				e.printStackTrace();
			}
			break;

		// Esegue uno switch sulla base del comando inserito dall'utente e reindirizza
		// tramite il Dispatcher alla View specifica per ogni operazione
		// con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":

			// toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiDelete", null);
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

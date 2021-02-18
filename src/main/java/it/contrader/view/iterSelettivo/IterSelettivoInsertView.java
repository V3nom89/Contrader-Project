package it.contrader.view.iterSelettivo;

import it.contrader.dao.IterSelettivoDAO;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class IterSelettivoInsertView extends AbstractView{
	private Request request;
	
	private int idIterSelettivo;
	private int idCandidato;
	private int idStaff;
	private int punteggioTotaleScritto;
	private int punteggioLogica;
	private int punteggioPhp;
	private int punteggioJava;
	private int punteggioHTML;
	private int punteggioInglese;
	private String dataTestScritto;
	private String dataTestOrale;
	private int valutazioneOrale;
	
	private final String mode = "INSERT";
	
	public IterSelettivoInsertView() {
		
	}
	
	/*
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("IterSelettivo", null);
		}
	}
	
	/*
	 * Chiede all'utente di inserire gli attributi dell'iter selettivo da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci l'ID dell'IterSelettivo:");
			idIterSelettivo = getInt();
			System.out.println("Inserisci l'ID del Candidato:");
			idCandidato = getInt();
			System.out.println("Inserisci l'ID del membro dello staff che ha seguito l'iter selettivo:");
			idStaff = getInt();
			System.out.println("Inserisci il punteggio totale della prova scritta dell'utente:");
			punteggioTotaleScritto = getInt();
			System.out.println("Inserisci il punteggio della parte logica della prova scritta dell'utente:");
			punteggioLogica = getInt();
			System.out.println("Inserisci il punteggio della parte php della prova scritta dell'utente:");
			punteggioPhp = getInt();
			System.out.println("Inserisci il punteggio della parte Java della prova scritta dell'utente:");
			punteggioJava = getInt();
			System.out.println("Inserisci il punteggio della parte HTML della prova scritta dell'utente:");
			punteggioHTML = getInt();
			System.out.println("Inserisci il punteggio della parte inglese della prova scritta dell'utente:");
			punteggioInglese = getInt();
			System.out.println("Inserisci la data della prova scritta dell'utente:");
			dataTestScritto = getInput();
			System.out.println("Inserisci la data del colloquio orale dell'utente:");
			dataTestOrale = getInput();
			System.out.println("Inserisci il punteggio rispettivo al colloquio orale dell'utente:");
			valutazioneOrale = getInt();
			
	}
	
	/*
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(IterSelettivoDAO.CONST.ID_ITER_SELETTIVO, idIterSelettivo);
		request.put(IterSelettivoDAO.CONST.ID_CANDIDATO, idCandidato);
		request.put(IterSelettivoDAO.CONST.ID_STAFF, idStaff);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_TOTALE_SCRITTO, punteggioTotaleScritto);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_LOGICA, punteggioLogica);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_PHP, punteggioPhp);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_JAVA, punteggioJava);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_HTML, punteggioHTML);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_INGLESE, punteggioInglese);
		request.put(IterSelettivoDAO.CONST.DATA_TEST_SCRITTO, dataTestScritto);
		request.put(IterSelettivoDAO.CONST.DATA_TEST_ORALE, dataTestOrale);
		request.put(IterSelettivoDAO.CONST.VALUTAZIONE_ORALE, valutazioneOrale);
		
		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("IterSelettivo", "doControl", request);
	}


//end
}

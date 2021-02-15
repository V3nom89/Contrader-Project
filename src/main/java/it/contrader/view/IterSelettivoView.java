package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.IterSelettivoDTO;
import it.contrader.main.MainDispatcher;

public class IterSelettivoView extends AbstractView{
	
	private Request request;
	private String choice;

	public IterSelettivoView() {
		
	}

//Mostra la lista iter selettivo
	@Override
public void showResults(Request request) {
	if (request != null) {
		System.out.println("\n------------------- Iter Selettivo ----------------");
		System.out.println("Id Iter Selettivo\tId Candidato\tId Staff\tPunteggio Totale Scritto\tPunteggio Logica\tPunteggio Php\tPunteggio Java\tPunteggio HTML\tPunteggio Inglese\tData Test Scritto\tData Test Orale\tValutazione Orale\n");
		System.out.println("----------------------------------------------------");
		
		@SuppressWarnings("unchecked")
		List<IterSelettivoDTO> iterSelettivo = (List<IterSelettivoDTO>) request.get("iterSelettivo");
		for (IterSelettivoDTO it: iterSelettivo)
			System.out.println(it);
		System.out.println();
		}
	}

 /* Chiede all'utente un input (lettera da tastiera) per la choice. 
    Mette la modalitÃ  GETCHOICE nella mode. */
	@Override
public void showOptions() {
	System.out.println("          Scegli l'operazione da effettuare:");
	System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

	this.choice = getInput();		
}

//Impacchetta la request e la manda allo UserController.
	@Override
public void submit() {
	request = new Request();
	request.put("choice", choice);
	request.put("mode", "GETCHOICE");
	MainDispatcher.getInstance().callAction("IterSelettivo", "doControl", this.request);
}


//end

}

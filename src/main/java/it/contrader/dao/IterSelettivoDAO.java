package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.IterSelettivo;


public class IterSelettivoDAO {
	
	public static interface CONST {
		String ID_ITER_SELETTIVO = "idIterSelettivo";
		String ID_CANDIDATO = "idCandidato";
		String ID_STAFF = "idStaff";
		String PUNTEGGIO_TOTALE_SCRITTO = "punteggioTotaleScritto";
		String PUNTEGGIO_LOGICA = "punteggioLogica";
		String PUNTEGGIO_PHP = "punteggioPhp";
		String PUNTEGGIO_JAVA = "punteggioJava";
		String PUNTEGGIO_HTML = "punteggioHTML";
		String PUNTEGGIO_INGLESE = "punteggioInglese";
		String DATA_TEST_SCRITTO = "dataTestScritto";
		String DATA_TEST_ORALE = "dataTestOrale";
		String VALUTAZIONE_ORALE = "valutazioneOrale";
	}

	
	private final String QUERY_ALL = "SELECT * FROM iterselettivo";
	private final String QUERY_CREATE = "INSERT INTO iterselettivo (idIterSelettivo, idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHtml, punteggioInglese, dataTestScritto,dataTestOrale, valutazioneOrale) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM iterselettivo WHERE idIterSelettivo=?";
	private final String QUERY_UPDATE = "UPDATE iterselettivo SET idCandidato = ?, idStaff = ?, punteggioTotaleScritto = ?, punteggioLogica = ?, punteggioPhp = ?, punteggioJava = ?, punteggioHtml = ?, punteggioInglese = ?, dataTestScritto = ?, dataTestOrale = ?, valutazioneOrale = ? WHERE idIterSelettivo = ?";
	private final String QUERY_DELETE = "DELETE FROM iterselettivo WHERE idIterSelettivo = ?";
	
	public IterSelettivoDAO() {
		
	}
	
	//get all
	public List<IterSelettivo> getAll (){
		List<IterSelettivo> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			IterSelettivo iterSelettivo;
			while (resultSet.next()) {
				int idIterSelettivo = resultSet.getInt(CONST.ID_ITER_SELETTIVO);
				int idCandidato = resultSet.getInt(CONST.ID_CANDIDATO);
				int idStaff = resultSet.getInt(CONST.ID_STAFF);
				int punteggioTotaleScritto = resultSet.getInt(CONST.PUNTEGGIO_TOTALE_SCRITTO);
				int punteggioLogica = resultSet.getInt(CONST.PUNTEGGIO_LOGICA);
				int punteggioPhp = resultSet.getInt(CONST.PUNTEGGIO_PHP);
				int punteggioJava = resultSet.getInt(CONST.PUNTEGGIO_JAVA);
				int punteggioHTML = resultSet.getInt(CONST.PUNTEGGIO_HTML);
				int punteggioInglese = resultSet.getInt(CONST.PUNTEGGIO_INGLESE);
				String dataTestScritto = resultSet.getString(CONST.DATA_TEST_SCRITTO);
				String dataTestOrale = resultSet.getString(CONST.DATA_TEST_ORALE);
				int valutazioneOrale = resultSet.getInt(CONST.VALUTAZIONE_ORALE);
				iterSelettivo = new IterSelettivo(idIterSelettivo, idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, dataTestOrale, valutazioneOrale);
				iterSelettivo.setIdIterSelettivo(idIterSelettivo);
				usersList.add(iterSelettivo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	//insert
	public boolean insert(IterSelettivo iterSelettivoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, iterSelettivoToInsert.getIdIterSelettivo());
			preparedStatement.setInt(2, iterSelettivoToInsert.getIdCandidato());
			preparedStatement.setInt(3, iterSelettivoToInsert.getIdStaff());
			preparedStatement.setInt(4, iterSelettivoToInsert.getPunteggioTotaleScritto());
			preparedStatement.setInt(5, iterSelettivoToInsert.getPunteggioLogica());
			preparedStatement.setInt(6, iterSelettivoToInsert.getPunteggioPhp());
			preparedStatement.setInt(7, iterSelettivoToInsert.getPunteggioJava());
			preparedStatement.setInt(8, iterSelettivoToInsert.getPunteggioHTML());
			preparedStatement.setInt(9, iterSelettivoToInsert.getPunteggioInglese());
			preparedStatement.setString(10, iterSelettivoToInsert.getDataTestScritto());
			preparedStatement.setString(11, iterSelettivoToInsert.getDataTestOrale());
			preparedStatement.setInt(12, iterSelettivoToInsert.getValutazioneOrale());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
		
		// read
	public IterSelettivo read(int iditerSelettivo) {
			Connection connection = ConnectionSingleton.getInstance();
			try {


				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
				preparedStatement.setInt(1, iditerSelettivo);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				//int idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, valutazioneOrale;
				//String dataTestScritto, dataTestOrale;
				
				int idIterSelettivo = resultSet.getInt(CONST.ID_ITER_SELETTIVO);
				int idCandidato = resultSet.getInt(CONST.ID_CANDIDATO);
				int idStaff = resultSet.getInt(CONST.ID_STAFF);
				int punteggioTotaleScritto = resultSet.getInt(CONST.PUNTEGGIO_TOTALE_SCRITTO);
				int punteggioLogica = resultSet.getInt(CONST.PUNTEGGIO_LOGICA);
				int punteggioPhp = resultSet.getInt(CONST.PUNTEGGIO_PHP);
				int punteggioJava = resultSet.getInt(CONST.PUNTEGGIO_JAVA);
				int punteggioHTML = resultSet.getInt(CONST.PUNTEGGIO_HTML);
				int punteggioInglese = resultSet.getInt(CONST.PUNTEGGIO_INGLESE);
				String dataTestScritto = resultSet.getString(CONST.DATA_TEST_SCRITTO);
				String dataTestOrale = resultSet.getString(CONST.DATA_TEST_ORALE);
				int valutazioneOrale = resultSet.getInt(CONST.VALUTAZIONE_ORALE);
								
				IterSelettivo iterSelettivo = new IterSelettivo(idIterSelettivo, idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, dataTestOrale, valutazioneOrale);
				iterSelettivo.setIdIterSelettivo(idIterSelettivo);

				return iterSelettivo;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
	
	// update
	public boolean update(IterSelettivo iterSelettivoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (iterSelettivoToUpdate.getIdIterSelettivo() == 0)
			return false;

		IterSelettivo iterSelettivoRead = read(iterSelettivoToUpdate.getIdIterSelettivo());
		if (!iterSelettivoRead.equals(iterSelettivoToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (iterSelettivoToUpdate.getIdIterSelettivo() == 0) {
					iterSelettivoToUpdate.setIdIterSelettivo(iterSelettivoRead.getIdIterSelettivo());
				}
				if (iterSelettivoToUpdate.getIdCandidato() == 0) {
					iterSelettivoToUpdate.setIdCandidato(iterSelettivoRead.getIdCandidato());
				}
				if (iterSelettivoToUpdate.getIdStaff() == 0) {
					iterSelettivoToUpdate.setIdStaff(iterSelettivoRead.getIdStaff());
				}
				if (iterSelettivoToUpdate.getPunteggioTotaleScritto() == 0) {
					iterSelettivoToUpdate.setPunteggioTotaleScritto(iterSelettivoRead.getPunteggioTotaleScritto());
				}
				if (iterSelettivoToUpdate.getPunteggioLogica() == 0) {
					iterSelettivoToUpdate.setPunteggioLogica(iterSelettivoRead.getPunteggioLogica());
				}
				if (iterSelettivoToUpdate.getPunteggioPhp() == 0) {
					iterSelettivoToUpdate.setPunteggioPhp(iterSelettivoRead.getPunteggioPhp());
				}
				if (iterSelettivoToUpdate.getPunteggioJava() == 0) {
					iterSelettivoToUpdate.setPunteggioJava(iterSelettivoRead.getPunteggioJava());
				}
				if (iterSelettivoToUpdate.getPunteggioHTML() == 0) {
					iterSelettivoToUpdate.setPunteggioHTML(iterSelettivoRead.getPunteggioHTML());
				}
				if (iterSelettivoToUpdate.getPunteggioInglese() == 0) {
					iterSelettivoToUpdate.setPunteggioInglese(iterSelettivoRead.getPunteggioInglese());
				}		
				if (iterSelettivoToUpdate.getDataTestScritto() == null || iterSelettivoToUpdate.getDataTestScritto().equals("")) {
					iterSelettivoToUpdate.setDataTestScritto(iterSelettivoRead.getDataTestScritto());
				} 
				if (iterSelettivoToUpdate.getDataTestOrale() == null || iterSelettivoToUpdate.getDataTestOrale().equals("")) {
					iterSelettivoToUpdate.setDataTestOrale(iterSelettivoRead.getDataTestOrale());
				}
				if (iterSelettivoToUpdate.getValutazioneOrale() == 0) {
					iterSelettivoToUpdate.setValutazioneOrale(iterSelettivoRead.getValutazioneOrale());
				}
		
				// Update iter selettivo
				// dubbio se inserire o no idIterSelettivo
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, iterSelettivoToUpdate.getIdCandidato());
				preparedStatement.setInt(2, iterSelettivoToUpdate.getIdStaff());
				preparedStatement.setInt(3, iterSelettivoToUpdate.getPunteggioTotaleScritto());
				preparedStatement.setInt(4, iterSelettivoToUpdate.getPunteggioLogica());
				preparedStatement.setInt(5, iterSelettivoToUpdate.getPunteggioPhp());
				preparedStatement.setInt(6, iterSelettivoToUpdate.getPunteggioJava());
				preparedStatement.setInt(7, iterSelettivoToUpdate.getPunteggioHTML());
				preparedStatement.setInt(8, iterSelettivoToUpdate.getPunteggioInglese());
				preparedStatement.setString(9, iterSelettivoToUpdate.getDataTestScritto());
				preparedStatement.setString(10, iterSelettivoToUpdate.getDataTestOrale());
				preparedStatement.setInt(11, iterSelettivoToUpdate.getValutazioneOrale());
				preparedStatement.setInt(12, iterSelettivoToUpdate.getIdIterSelettivo());
				

				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		return false;

	}
	
	//delete
	public boolean delete(int idIterSelettivo) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idIterSelettivo);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.IterSelettivo;


public class IterSelettivoDAO {
	private final String QUERY_ALL = "SELECT * FROM IterSelettivo";
	private final String QUERY_CREATE = "INSERT INTO IterSelettivo (idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHtml, punteggioInglese, dataTestScritto, valutazioneOrale, dataTestOrale) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM IterSelettivo WHERE idIterSelettivo=?";
	private final String QUERY_UPDATE = "UPDATE IterSelettivo SET idCandidato = ?, idStaff = ?, punteggioTotaleScritto = ?, punteggioLogica = ?, punteggioPhp = ?, punteggioJava = ?, punteggioHtml = ?, punteggioInglese = ?, dataTestScritto = ?, valutazioneOrale = ?, dataTestOrale = ? WHERE idIterSelettivo = ?";
	private final String QUERY_DELETE = "DELETE * FROM IterSelettivo WHERE idIterSelettivo = ?";
	
	public IterSelettivoDAO() {
		
	}
	
	//get all
	public List<IterSelettivo> getAll (){
		List<IterSelettivo> iterSelettivoList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			IterSelettivo iterSelettivo;
			while (resultSet.next()) {
				int idIterSelettivo = resultSet.getInt("idIterSelettivo");
				int idCandidato = resultSet.getInt("idCandidato");
				int idStaff = resultSet.getInt("idStaff");
				int punteggioTotaleScritto = resultSet.getInt("punteggioTotaleScritto");
				int punteggioLogica = resultSet.getInt("punteggioLogica");
				int punteggioPhp = resultSet.getInt("punteggioPhp");
				int punteggioJava = resultSet.getInt("punteggioJava");
				int punteggioHTML = resultSet.getInt("punteggioHtml");
				int punteggioInglese = resultSet.getInt("punteggioInglese");
				String dataTestScritto = resultSet.getString("dataTestScritto");
				int valutazioneOrale = resultSet.getInt("valutazioneOrale");
				String dataTestOrale = resultSet.getString("dataTestOrale");
				iterSelettivo = new IterSelettivo(idIterSelettivo, idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, valutazioneOrale, dataTestOrale);
				iterSelettivo.setIdIterSelettivo(idIterSelettivo);
				iterSelettivoList.add(iterSelettivo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iterSelettivoList;
	}
	
	//insert
	public boolean insert(IterSelettivo iterSelettivoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, iterSelettivoToInsert.getIdCandidato());
			preparedStatement.setInt(2, iterSelettivoToInsert.getIdStaff());
			preparedStatement.setInt(3, iterSelettivoToInsert.getPunteggioTotaleScritto());
			preparedStatement.setInt(4, iterSelettivoToInsert.getPunteggioLogica());
			preparedStatement.setInt(5, iterSelettivoToInsert.getPunteggioPhp());
			preparedStatement.setInt(6, iterSelettivoToInsert.getPunteggioJava());
			preparedStatement.setInt(7, iterSelettivoToInsert.getPunteggioHTML());
			preparedStatement.setInt(8, iterSelettivoToInsert.getPunteggioInglese());
			preparedStatement.setString(9, iterSelettivoToInsert.getDataTestScritto());
			preparedStatement.setInt(10, iterSelettivoToInsert.getValutazioneOrale());
			preparedStatement.setString(11, iterSelettivoToInsert.getDataTestOrale());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
		
		// read
	public IterSelettivo read(int idIterSelettivo) {
			Connection connection = ConnectionSingleton.getInstance();
			try {


				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
				preparedStatement.setInt(1, idIterSelettivo);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, valutazioneOrale;
				String dataTestScritto, dataTestOrale;
				
				idCandidato = resultSet.getInt("idCandidato");
				idStaff = resultSet.getInt("idStaff");
				punteggioTotaleScritto = resultSet.getInt("punteggioTotaleScritto");
				punteggioLogica = resultSet.getInt("punteggioLogica");
				punteggioPhp = resultSet.getInt("punteggioPhp");
				punteggioJava = resultSet.getInt("punteggioJava");
				punteggioHTML = resultSet.getInt("punteggioHtml");
				punteggioInglese = resultSet.getInt("punteggioInglese");
				dataTestScritto = resultSet.getString("dataTestScritto");
				valutazioneOrale = resultSet.getInt("valutazioneOrale");
				dataTestOrale = resultSet.getString("dataTestOrale");
				
				IterSelettivo iterSelettivo = new IterSelettivo(idIterSelettivo, idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, valutazioneOrale, dataTestOrale);
				iterSelettivo.setIdIterSelettivo(resultSet.getInt("idIterSelettivo"));

				return iterSelettivo;
			} catch (SQLException e) {
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
				if (iterSelettivoToUpdate.getPunteggioHTML() == 0) {
					iterSelettivoToUpdate.setPunteggioHTML(iterSelettivoRead.getPunteggioHTML());
				}
				if (iterSelettivoToUpdate.getPunteggioInglese() == 0) {
					iterSelettivoToUpdate.setPunteggioInglese(iterSelettivoRead.getPunteggioInglese());
				}
				if (iterSelettivoToUpdate.getValutazioneOrale() == 0) {
					iterSelettivoToUpdate.setValutazioneOrale(iterSelettivoRead.getValutazioneOrale());
				}
				if (iterSelettivoToUpdate.getDataTestScritto() == null || iterSelettivoToUpdate.getDataTestScritto().equals("")) {
					iterSelettivoToUpdate.setDataTestScritto(iterSelettivoRead.getDataTestScritto());
				} // le date vengono considerate come stringhe
				if (iterSelettivoToUpdate.getDataTestOrale() == null || iterSelettivoToUpdate.getDataTestOrale().equals("")) {
					iterSelettivoToUpdate.setDataTestOrale(iterSelettivoRead.getDataTestOrale());
				}
		
				// Update iter selettivo
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
				preparedStatement.setInt(10, iterSelettivoToUpdate.getValutazioneOrale());
				preparedStatement.setString(11, iterSelettivoToUpdate.getDataTestOrale());

				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
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
		}
		return false;
	}

}

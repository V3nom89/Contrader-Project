package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Candidati;


public class CandidatiDAO implements DAO<Candidati> {

	

	private final String QUERY_ALL = "SELECT * FROM candidati";
	private final String QUERY_CREATE = "INSERT INTO candidati (idCandidati, idStaff, nome, cognome, email, luogoProvenienza, numeroTelefono, titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo, candidatiTramite,  idoneita, codiceFiscale, userType) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM candidati WHERE idCandidati=?";
	private final String QUERY_UPDATE = "UPDATE candidati SET idStaff = ?, nome = ?, cognome = ?, email = ?, luogoProvenienza = ?, numeroTelefono = ?, titoloStudio = ?, titoloLaurea = ?, dataCandidatura = ?, rangeCandidatura = ?, colloquioConoscitivo = ?, candidatiTramite = ?, idoneita = ?, codiceFiscale = ?, userType = ?  WHERE idCandidati=?";
	private final String QUERY_DELETE = "DELETE FROM candidati WHERE idCandidati=?";

	public CandidatiDAO() {

	}

	public List<Candidati> getAll() {
		List<Candidati> candidatiList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Candidati candidati;
			while (resultSet.next()) {
				int id = resultSet.getInt("idCandidati");
				int idStaff = resultSet.getInt("idStaff");
				String nome = resultSet.getString("nome");
				String cognome = resultSet.getString("cognome");
				String email = resultSet.getString("email");
				String luogoProvenienza = resultSet.getString("luogoProvenienza");
				int numeroTelefono = resultSet.getInt("numeroTelefono");
				String titoloStudio = resultSet.getString("titoloStudio");
				String titoloLaurea = resultSet.getString("titoloLaurea");
				String dataCandidatura = resultSet.getString("dataCandidatura");
				String rangeCandidatura = resultSet.getString("rangeCandidatura");
				boolean colloquioConoscitivo = resultSet.getBoolean("colloquioConoscitivo");
				String candidatiTramite = resultSet.getString("candidatiTramite");
				boolean idoneita = resultSet.getBoolean("idoneita");
				String codiceFiscale = resultSet.getString("codiceFiscale");
				String userType = resultSet.getString("userType");
				
				candidati = new Candidati(idStaff, nome, cognome, email, luogoProvenienza, numeroTelefono, titoloStudio,
						titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo, candidatiTramite,
						idoneita, codiceFiscale, userType);
				candidati.setIdCandidati(id);
				candidatiList.add(candidati);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidatiList;
	}

	public boolean insert(Candidati c) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, c.getIdCandidati());
			preparedStatement.setInt(2, c.getIdStaff());
			preparedStatement.setString(3, c.getNome());
			preparedStatement.setString(4, c.getCognome());
			preparedStatement.setString(5, c.getEmail());
			preparedStatement.setString(6, c.getLuogoProvenienza());
			preparedStatement.setInt(7, c.getNumeroTelefono());
			preparedStatement.setString(8, c.getTitoloStudio());
			preparedStatement.setString(9, c.getTitoloLaurea());
			preparedStatement.setString(10, c.getDataCandidatura());
			preparedStatement.setString(11, c.getRangeCandidatura());
			preparedStatement.setBoolean(12, c.isColloquioConoscitivo());
			preparedStatement.setString(13, c.getCandidatiTramite());
			preparedStatement.setBoolean(14, c.isIdoneita());
			preparedStatement.setString(15, c.getCodiceFiscale());
			preparedStatement.setString(16, c.getUserType());

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Candidati read(int idcandidati) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idcandidati);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			int id = resultSet.getInt("idCandidati");
			int idStaff = resultSet.getInt("idStaff");
			String nome = resultSet.getString("nome");
			String cognome = resultSet.getString("cognome");
			String email = resultSet.getString("email");
			String luogoProvenienza = resultSet.getString("luogoProvenienza");
			int numeroTelefono = resultSet.getInt("numeroTelefono");
			String titoloStudio = resultSet.getString("titoloStudio");
			String titoloLaurea = resultSet.getString("titoloLaurea");
			String dataCandidatura = resultSet.getString("dataCandidatura");
			String rangeCandidatura = resultSet.getString("rangeCandidatura");
			boolean colloquioConoscitivo = resultSet.getBoolean("colloquioConoscitivo");
			String candidatiTramite = resultSet.getString("candidatiTramite");
			boolean idoneita = resultSet.getBoolean("idoneita");
			String codiceFiscale = resultSet.getString("codiceFiscale");
			String userType = resultSet.getString("userType");

			Candidati candidati = new Candidati(id, idStaff, nome, cognome, email, luogoProvenienza, numeroTelefono,
					titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo,
					candidatiTramite, idoneita, codiceFiscale, userType);
			candidati.setIdCandidati(id);

			return candidati;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean update(Candidati candidatiToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (candidatiToUpdate.getIdCandidati() == 0)
			return false;

		Candidati candidatiRead = read(candidatiToUpdate.getIdCandidati());
		if (!candidatiRead.equals(candidatiToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (candidatiToUpdate.getIdCandidati() == 0) {
					candidatiToUpdate.setIdCandidati(candidatiRead.getIdCandidati());
				}
				
				if (candidatiToUpdate.getIdStaff() == 0) {
					candidatiToUpdate.setIdStaff(candidatiRead.getIdStaff());
				}

				if (candidatiToUpdate.getNome() == null || candidatiToUpdate.getNome().equals("")) {
					candidatiToUpdate.setNome(candidatiRead.getNome());
				}

				if (candidatiToUpdate.getCognome() == null || candidatiToUpdate.getCognome().equals("")) {
					candidatiToUpdate.setCognome(candidatiRead.getCognome());
				}
				if (candidatiToUpdate.getEmail() == null || candidatiToUpdate.getEmail().equals("")) {
					candidatiToUpdate.setEmail(candidatiRead.getEmail());
				}

				if (candidatiToUpdate.getLuogoProvenienza() == null || candidatiToUpdate.getLuogoProvenienza().equals("")) {
					candidatiToUpdate.setLuogoProvenienza(candidatiRead.getLuogoProvenienza());
				}

				if (candidatiToUpdate.getNumeroTelefono() == 0) {
					candidatiToUpdate.setNumeroTelefono(candidatiRead.getNumeroTelefono());
				}
				if (candidatiToUpdate.getTitoloStudio() == null || candidatiToUpdate.getTitoloStudio().equals("")) {
					candidatiToUpdate.setTitoloStudio(candidatiRead.getTitoloStudio());
				}

				if (candidatiToUpdate.getTitoloLaurea() == null || candidatiToUpdate.getTitoloLaurea().equals("")) {
					candidatiToUpdate.setTitoloLaurea(candidatiRead.getTitoloLaurea());
				}

				if (candidatiToUpdate.getDataCandidatura() == null || candidatiToUpdate.getDataCandidatura().equals("")) {
					candidatiToUpdate.setDataCandidatura(candidatiRead.getDataCandidatura());
				}
				if (candidatiToUpdate.getRangeCandidatura() == null || candidatiToUpdate.getRangeCandidatura().equals("")) {
					candidatiToUpdate.setRangeCandidatura(candidatiRead.getRangeCandidatura());
				}

				if (candidatiToUpdate.isColloquioConoscitivo() == false) {
					candidatiToUpdate.setColloquioConoscitivo(candidatiRead.isColloquioConoscitivo());
				}
				if (candidatiToUpdate.getCandidatiTramite() == null || candidatiToUpdate.getCandidatiTramite().equals("")) {
					candidatiToUpdate.setCandidatiTramite(candidatiRead.getCandidatiTramite());
				}

				
				if (candidatiToUpdate.isIdoneita() == false) {
					candidatiToUpdate.setIdoneita(candidatiRead.isIdoneita());
				}

				if (candidatiToUpdate.getCodiceFiscale() == null || candidatiToUpdate.getCodiceFiscale().equals("")) {
					candidatiToUpdate.setCodiceFiscale(candidatiRead.getCodiceFiscale());
				}

				if (candidatiToUpdate.getUserType() == null || candidatiToUpdate.getUserType().equals("")) {
					candidatiToUpdate.setUserType(candidatiRead.getUserType());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, candidatiToUpdate.getIdStaff());
				preparedStatement.setString(2, candidatiToUpdate.getNome());
				preparedStatement.setString(3, candidatiToUpdate.getCognome());
				preparedStatement.setString(4, candidatiToUpdate.getEmail());
				preparedStatement.setString(5, candidatiToUpdate.getLuogoProvenienza());
				preparedStatement.setInt(6, candidatiToUpdate.getNumeroTelefono());
				preparedStatement.setString(7, candidatiToUpdate.getTitoloStudio());
				preparedStatement.setString(8, candidatiToUpdate.getTitoloLaurea());
				preparedStatement.setString(9, candidatiToUpdate.getDataCandidatura());
				preparedStatement.setString(10, candidatiToUpdate.getRangeCandidatura());
				preparedStatement.setBoolean(11, candidatiToUpdate.isColloquioConoscitivo());
				preparedStatement.setString(12, candidatiToUpdate.getCandidatiTramite());
				preparedStatement.setBoolean(13, candidatiToUpdate.isIdoneita());
				preparedStatement.setString(14, candidatiToUpdate.getCodiceFiscale());
				preparedStatement.setString(15, candidatiToUpdate.getUserType());
				preparedStatement.setInt(16, candidatiToUpdate.getIdCandidati());
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

	public boolean delete(int idCandidati) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idCandidati);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

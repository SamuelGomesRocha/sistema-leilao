package br.edu.ifg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.Status;

public class LeilaoDao extends ConnectionDao{

	private Connection cnx = getConnection();
	
	private static final String INSERT_LEILOES_SQL = "INSERT INTO leilao" + "  (item, lanceMinimo, status, dataExpiracao) VALUES "
			+ " (?, ?, ?, ?);";
	
	private static final String SELECT_ALL_LEILOES_SQL = "SELECT * FROM leilao";
	
	private static final String DELETE_LEILOES_SQL = "DELETE FROM leilao WHERE item = ?";
	
	public LeilaoDao() {
		
	}
	
	
	//Método que salva leilão
	public void salvaLeilao(Leilao leilao) throws SQLException{
		System.out.println(INSERT_LEILOES_SQL);
		
		try(PreparedStatement ps = cnx.prepareStatement(INSERT_LEILOES_SQL)){
		
			ps.setString(1, leilao.getItem());
			ps.setDouble(2, leilao.getLanceMinimo());
			ps.setInt(3, leilao.getStatus().ordinal()+1);
			ps.setDate(4, (Date) leilao.getDataExpiracao());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Leilao> listaLeiloes(){
		List<Leilao> leiloes = new ArrayList<Leilao>();
		
		try(PreparedStatement ps = cnx.prepareStatement(SELECT_ALL_LEILOES_SQL)){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String item = rs.getString("item");
				Double lanceMinimo = rs.getDouble("lanceMinimo");
				Date dataExpiracao = rs.getDate("dataExpiracao");
				String status = rs.getString("status");
				
				leiloes.add(new Leilao(item, lanceMinimo, Status.valueOf(status), dataExpiracao));
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//for(Leilao l : leiloes) System.out.println(l.getItem() +" - " +  l.getLanceMinimo() + " " + l.getStatus() + " " + l.getDataExpiracao());
		return leiloes;
	}
	
	
	public void deletaLeilao(String item) {
		
		try(PreparedStatement ps = cnx.prepareStatement(DELETE_LEILOES_SQL)){	
			
			ps.setString(1, item);		
			ps.execute();
			ps.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

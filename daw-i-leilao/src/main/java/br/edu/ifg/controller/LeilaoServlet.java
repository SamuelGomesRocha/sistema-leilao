package br.edu.ifg.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.dao.LeilaoDao;
import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.Status;

/**
 * Servlet implementation class LeilaoServlet
 */
@WebServlet("/leilao")
public class LeilaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LeilaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			cadastraLeilao(request, response);
		
	}

	
	private void cadastraLeilao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String item = request.getParameter("input-item");
		String valorMinimo = request.getParameter("input-lanceMinimo");
		String dataExpiracao = request.getParameter("input-dataExpiracao");
		Date dateE = Date.valueOf(dataExpiracao);
		Leilao leilao = new Leilao(item, Double.parseDouble(valorMinimo), Status.INATIVO, dateE);
		
		LeilaoDao ld = new LeilaoDao();
		
		try {
			ld.salvaLeilao(leilao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastro efetuado com sucesso, nome do item: "+leilao.getItem());
		System.out.println("Value of: "+leilao.getStatus()+"is: "+ leilao.getStatus().ordinal());
		response.sendRedirect("cadastro-leilao");
	}
	
}

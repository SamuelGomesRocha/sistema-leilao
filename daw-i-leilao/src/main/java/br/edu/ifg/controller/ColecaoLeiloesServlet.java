package br.edu.ifg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.dao.LeilaoDao;
import br.edu.ifg.entities.Leilao;

@WebServlet(urlPatterns = "/colecaoLeiloes")
public class ColecaoLeiloesServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Leilao> leiloes = new LeilaoDao().listaLeiloes();
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/pages/colecao-leiloes.jsp");
		for(Leilao l : leiloes) System.out.println(l.getItem() +" - " +  l.getLanceMinimo() + " " + l.getStatus() + " " + l.getDataExpiracao());
		req.setAttribute("leiloes", leiloes);
		dispatcher.forward(req, resp);
	
	}
	
}

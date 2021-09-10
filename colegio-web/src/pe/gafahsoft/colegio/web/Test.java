package pe.gafahsoft.colegio.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.gafahsoft.colegio.modelo.Menu;
import pe.gafahsoft.colegio.service.GeneralServiceRemote;
import pe.gafahsoft.colegio.util.ServiceLocator;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//@EJB
	//AlumnoBeanDAOLocal alumnoBeanDAOLocal;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
//		System.out.println(alumnoBeanDAOLocal.getAlumnos().size());
//		GeneralServiceRemote generalServiceRemote = ServiceLocator.doLookup(); 
//		System.out.println("<<<<< "+generalServiceRemote.getAlumnos(null).size());
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		List<Menu> lista = generalServiceRemote.getMenus();
//		System.out.println("Tami "+lista.size());
//		Menu menu = lista.get(0);
//		System.out.println(menu.getUsuReg());
//		System.out.println(menu.getMenuDesc());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

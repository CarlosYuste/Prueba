package com.ecodeup.com;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validacio
 */
@WebServlet("/validacio")
public class validacio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validacio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * Comprovamos que los datos introducidos son los correctos y si es así accedemos a succes.html, sino a fail.html
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Poner aquí expresiones regulares porfavor dios te lo pido no falles esta vez te quiero mucho mamá.
		String email= request.getParameter("mail");
		String compemail = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
			      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
		String name= request.getParameter("name");
		String compname = "(^[a-zA-Z0-9]{1,10})$";
		String password = request.getParameter("password");
		String comptraseña="(^[a-zA-Z0-9]{8,})$";
		
		boolean sii=LoginCase.selectUser(name);
		boolean si=LoginCase.insertUser(name,password,email);
		
		if(Pattern.matches(compemail, email) && Pattern.matches(compname,name) && Pattern.matches(comptraseña,password) && sii==false) {
			if(si==true) {
				getServletContext().getRequestDispatcher("/html/success.html").forward(request, response);
			}
		}else {
			getServletContext().getRequestDispatcher("/html/fail.html").forward(request, response);
		}
	}
//https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=389:configurar-java-en-windows-variables-de-entorno-javahome-y-path-cu00610b&catid=68&Itemid=188
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

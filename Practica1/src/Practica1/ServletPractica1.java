package Practica1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPractica1
 */
@WebServlet("/ServletPractica1")
public class ServletPractica1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // Constructor
    public ServletPractica1() {
        super();
    }

    
	/**
	 * Dentro del Servlet hay dos m�todos importantes: doGet y doPost. Estos m�todos son
	 * los que atienden las peticiones POST y GET de la p�gina, respectivamente.
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		requestHeader(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	//Creamos una clase que nos permita obtener las cabeceras de petici�n HTTP
	public void requestHeader(HttpServletRequest req, HttpServletResponse res) throws IOException {
				//
		        PrintWriter out = res.getWriter();
		        
		        Enumeration<String> headerNames = req.getHeaderNames();
		        while (headerNames.hasMoreElements()) {
		            String headerName = headerNames.nextElement();

		            out.write("\n"+headerName);
		            Enumeration<String> headers = req.getHeaders(headerName);
		            while (headers.hasMoreElements()) {
	
		                String headerValue = headers.nextElement();
		                out.write(":"+headerValue);
		            }

		        }
		        out.close();

		    }
		
}

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
	 * Dentro del Servlet hay dos métodos importantes: doGet y doPost. Estos métodos son
	 * los que atienden las peticiones POST y GET de la página, respectivamente.
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		requestHeader(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	//Creamos un método que nos permita obtener las cabeceras de petición HTTP
	public void requestHeader(HttpServletRequest req, HttpServletResponse res) throws IOException {
				//Definimos una variable out de tipo Printwriter.
				//Esta clase imprime representaciones formateadas de objetos en una secuencia de salida de texto.
		        PrintWriter out = res.getWriter();
		        
		        //Interfaz Enumeration: Un objeto que implementa la interfaz Enumeration permite generar series de elementos
		        //Enumeración llamada headerNames a la que le asignamos las distintas cabeceras sin su valor
		        Enumeration<String> headerNames = req.getHeaderNames();
		        
		        while (headerNames.hasMoreElements()) { //hasMoreElements()-> prueba si esta enumeración contiene más elementos
		        	//Definimos una variable headerName de tipo String y le asignamos el valor siguiente de headerNames (contiene
		        	//los nombres de las cabeceras)
		            String headerName = headerNames.nextElement();
		            //En nuestra salida, escribe un salto de línea + el nombre de la cabecera
		            out.write("\n"+headerName);
		            
		            //Enumeracion de tipo string llamada header a la que le asignamos el valor de las distintas cabeceras
		            //req.getHeaders(headerName) -> Obtiene el valor de las cabeceras de la petición
		            Enumeration<String> headers = req.getHeaders(headerName);
		            
		            while (headers.hasMoreElements()) { //prueba si esta enumeración contiene más elementos
	
		            	//Definimos una variable que contendra el valor de nuestra cabecera y se lo asignamos
		                String headerValue = headers.nextElement();
		                //Escribe en nuestra página web : y el valor de la cabecera
		                out.write(":"+headerValue);
		            }

		        }
		        //Cerramos salida.
		        out.close();

		    }
		
}

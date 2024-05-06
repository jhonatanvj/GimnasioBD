/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servidores;

import Model.Rutina;
import Model.RutinaAumento;
import Model.RutinaFuerza;
import Model.RutinaResistencia;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jhona
 */
@WebServlet(name = "VerRutina", urlPatterns = {"/VerRutina"})
public class VerRutina extends HttpServlet {
    
    public static Rutina ru;
    Usuario usu = new Usuario();
    

    
    public static void liskov(Rutina r) {
        r.aniadirEjercicios();
        r.addSeries();
        r.addRepeticiones();
        ru=r;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        usu.setNombre(request.getParameter("nombre"));
        if ("aumento".equals(request.getParameter("objetivo"))) {
            RutinaAumento aumento=new RutinaAumento();
            liskov(aumento);
        }else if ("fuerza".equals(request.getParameter("objetivo"))) {
            RutinaFuerza fuerza = new RutinaFuerza();
            liskov(fuerza);
        }else if("resistencia".equals(request.getParameter("objetivo"))){
                RutinaResistencia resistencia = new RutinaResistencia();
                liskov(resistencia);
            }
        int dias=Integer.parseInt(request.getParameter("dias"));
        String[] diasSemana = {"1", "2", "3", "4", "5", "6", "7"};
        
        
       try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Horario de Ejercicios</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" href=\"estilo2.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Horario de Ejercicios</h1>");
            out.println("<div>");
            out.println("<p>Nombre del Cliente: " + usu.getNombre()  + "</p>");
            out.println("</div>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Día</th>");
            out.println("<th>Tipo</th>");
            out.println("<th>Ejercicio 1</th>");
            out.println("<th>Ejercicio 2</th>");
            out.println("<th>Ejercicio 3</th>");
            out.println("</tr>");
            boolean[] diasEntrenamientoSeleccionados = new boolean[7];
            Random rand = new Random();
           
            if (dias == 1) {
                diasEntrenamientoSeleccionados[rand.nextInt(7)] = true;
            }
            if (dias == 2) {
                diasEntrenamientoSeleccionados[0] = true; 
                diasEntrenamientoSeleccionados[3] = true; 
            }
            if (dias == 3) {
                diasEntrenamientoSeleccionados[0] = true; 
                diasEntrenamientoSeleccionados[2] = true; 
                diasEntrenamientoSeleccionados[4] = true; 
            }
            if (dias == 4) {
                diasEntrenamientoSeleccionados[0] = true;
                diasEntrenamientoSeleccionados[2] = true;
                diasEntrenamientoSeleccionados[4] = true;
                diasEntrenamientoSeleccionados[6] = true; 
            }
            if(dias == 5){
                diasEntrenamientoSeleccionados[0] = true; 
                diasEntrenamientoSeleccionados[1] = true; 
                diasEntrenamientoSeleccionados[2] = true; 
                diasEntrenamientoSeleccionados[3] = true; 
                diasEntrenamientoSeleccionados[4] = true;
            }
            
            String[] ejerciciosSeleccionados = new String[3];
            
            for (int i = 0; i < 7; i++) {
                out.println("<tr>");
                out.println("<td>" + diasSemana[i] + "</td>");

                
                String tipoDia = diasEntrenamientoSeleccionados[i] ? "Entrenamiento" : "Descanso";
                out.println("<td>" + tipoDia + "</td>");
                if (diasEntrenamientoSeleccionados[i]) {
                    for (int j = 0; j < 3; j++) {
                        String ejercicio;
                        if (ejerciciosSeleccionados[j] != null) {
                            ejercicio = ejerciciosSeleccionados[j];
                        } else {
                            do {
                                ejercicio = ru.getEjercicioAleatorio(rand);
                            } while (Arrays.asList(ejerciciosSeleccionados).contains(ejercicio));
                                ejerciciosSeleccionados[j] = ejercicio;
                        }
                        out.println("<td>" + ejercicio + "<br>" + 
                                "Repeticiones: " + ru.getRepeticiones() + "<br>" + 
                                "Series: " + ru.getSeries() + "</td>");
                    }
                } else {
                    
                    out.println("<td>Descanso</td>");
                    out.println("<td>Descanso</td>");
                    out.println("<td>Descanso</td>");
                }

                out.println("</tr>");
                Arrays.fill(ejerciciosSeleccionados, null);
            }
            
            out.println("</table>");
            out.println("<a href=\"CrearRutina.html\">Volver</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

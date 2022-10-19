package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet ( urlPatterns = "/ciclos" )

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            if (optId.isPresent()) {
                resp.setStatus(HttpServletResponse.SC_OK);
                ArrayList<Todo> TodoT = new ArrayList<Todo>();
                Todo elemento = Service.getTodo(Integer.parseInt(optId.get()));
                TodoT.add(elemento);
                responseWriter.write(Service.todosToHTMLTable(TodoT));
                responseWriter.flush();
            }
        } catch (FileNotFoundException FException) {
            resp.setStatus(HttpServletResponse.SC_FOUND);
            responseWriter.write("Item no encontrado");
        }catch (NumberFormatException NException) {
            resp.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
            responseWriter.write("Solicitud invalida");
        }catch (MalformedURLException MException) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseWriter.write("Error interno en el servidor");
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
            responseWriter.write("Invalido");


        }
    }
}

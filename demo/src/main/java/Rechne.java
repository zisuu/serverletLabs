import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rechne extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int zahl1 = 0;
        int zahl2 = 0;
        boolean fehler = false;
        // Zahlen aus den Parametern lesen und parsen
        try {
            zahl1 = Integer.parseInt(request.getParameter("zahl1"));
            zahl2 = Integer.parseInt(request.getParameter("zahl2"));
        } catch (RuntimeException ex) {
            // Falls es beim Parsen zu einem Fehler kommt, dies für die Ausgabe merken.
            fehler = true;
        }
        // Die Antwort ist im HTML-Format
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // HTML-Text ausgeben
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ergebnis</title>");
            out.println("</head>");
            out.println("<body>");
            if (fehler) {
                // Wenn die Parameter fehlerhaft waren eine Meldung ausgeben
                out.println("Eingaben konnten nicht in Zahlen umgewandelt werden!");
            } else {
                // Sonst die Summe berechnen und Ausgeben
                out.println(zahl1 + " + " + zahl2 + " = " + (zahl1 + zahl2));
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}

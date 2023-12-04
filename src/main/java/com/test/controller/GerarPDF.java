package com.test.controller;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.model.Jogos;
import com.test.model.JogosDAO;

@WebServlet("/GerarArquivoPDF")
public class GerarPDF extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=lista_jogos.pdf");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("Lista de Jogos em PDF\n\n"));
            for (Jogos jogo : JogosDAO.jogos()) {
                document.add(new Paragraph("ID: " + jogo.getIdJogo()));
                document.add(new Paragraph("Horário: " + jogo.getHorario()));
                document.add(new Paragraph("Time da casa: " + jogo.getMandante()));
                document.add(new Paragraph("Gol(s): " + jogo.getGolMandante()));
                document.add(new Paragraph("Time visitante: " + jogo.getVisitante()));
                document.add(new Paragraph("Gol(s): " + jogo.getGolVisitante()));
                document.add(new Paragraph("Estádio: " + jogo.getEstadio()));
                document.add(new Paragraph("CreateBy: " + jogo.getCreate()));
                document.add(new Paragraph("\n"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}

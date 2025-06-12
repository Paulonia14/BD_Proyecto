/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.report;

import ar.edu.uncuyo.dao.NutricionistaDAO;
import ar.edu.uncuyo.model.Nutricionista;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author Paula
 */
public class NutricionistaPDFExporter {
    public void exportarNutricionista(String rutaDestino) {
        NutricionistaDAO dao = new NutricionistaDAO();
        List<Nutricionista> nutricionistas = dao.obtenerTodos();
        Document document = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaDestino));
            document.open();
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font fuenteTabla = FontFactory.getFont(FontFactory.HELVETICA, 8);
            Paragraph titulo = new Paragraph("Reporte de Nutricionistas", fuenteTitulo);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            PdfPTable tabla = new PdfPTable(9);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);

            float[] anchos = {1f, 2f, 2f, 3f, 2f, 2f, 2.5f, 2.5f, 2.5f};
            tabla.setWidths(anchos);
            String[] encabezados = {
                "ID", "Nombre", "Apellido", "Email", "Contraseña",
                "Tarifa", "Título Profesional", "Años de Experiencia", "Disponibilidad"
            };

            for (String h : encabezados) {
                PdfPCell celdaHeader = new PdfPCell(new Phrase(h, fuenteTabla));
                celdaHeader.setBackgroundColor(new Color(220, 220, 220)); 
                celdaHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celdaHeader);
            }

            for (Nutricionista n : nutricionistas) {
                tabla.addCell(new Phrase(String.valueOf(n.getId()), fuenteTabla));
                tabla.addCell(new Phrase(n.getNombre(), fuenteTabla));
                tabla.addCell(new Phrase(n.getApellido(), fuenteTabla));
                tabla.addCell(new Phrase(n.getEmail(), fuenteTabla));
                tabla.addCell(new Phrase(n.getContraseña(), fuenteTabla));
                tabla.addCell(new Phrase(String.valueOf(n.getTarifa()), fuenteTabla));
                tabla.addCell(new Phrase(n.getTituloProfesional(), fuenteTabla));  
                tabla.addCell(new Phrase(String.valueOf(n.getAñosExperiencia()), fuenteTabla));
                tabla.addCell(new Phrase(n.getDisponibilidad(), fuenteTabla));
            }

            document.add(tabla);
            document.close();
            System.out.println("PDF generado correctamente en: " + rutaDestino);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
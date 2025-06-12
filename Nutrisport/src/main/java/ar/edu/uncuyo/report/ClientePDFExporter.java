/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.report;

/**
 *
 * @author Paula
 */
import ar.edu.uncuyo.dao.ClienteDAO;
import ar.edu.uncuyo.model.Cliente;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.Color;


public class ClientePDFExporter {
    public void exportarClientes(String rutaDestino) {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.obtenerTodos();
        Document document = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaDestino));
            document.open();
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font fuenteTabla = FontFactory.getFont(FontFactory.HELVETICA, 8);
            Paragraph titulo = new Paragraph("Reporte de Clientes", fuenteTitulo);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            PdfPTable tabla = new PdfPTable(10);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);

            float[] anchos = {1f, 2f, 2f, 3f, 2f, 2f, 1f, 2.5f, 2.5f, 2.5f};
            tabla.setWidths(anchos);
            String[] encabezados = {
                "ID", "Nombre", "Apellido", "Email", "Contraseña",
                "Fecha Nacimiento", "Género", "Objetivo", "Tipo Actividad", "Frecuencia Actividad"
            };

            for (String h : encabezados) {
                PdfPCell celdaHeader = new PdfPCell(new Phrase(h, fuenteTabla));
                celdaHeader.setBackgroundColor(new Color(220, 220, 220)); 
                celdaHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celdaHeader);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (Cliente c : clientes) {
                tabla.addCell(new Phrase(String.valueOf(c.getId()), fuenteTabla));
                tabla.addCell(new Phrase(c.getNombre(), fuenteTabla));
                tabla.addCell(new Phrase(c.getApellido(), fuenteTabla));
                tabla.addCell(new Phrase(c.getEmail(), fuenteTabla));
                tabla.addCell(new Phrase(c.getContraseña(), fuenteTabla));
                tabla.addCell(new Phrase(sdf.format(c.getFechaNacimiento()), fuenteTabla));
                tabla.addCell(new Phrase(String.valueOf(c.getGenero()), fuenteTabla));
                tabla.addCell(new Phrase(c.getObjetivo(), fuenteTabla));
                tabla.addCell(new Phrase(c.getTipoActividad(), fuenteTabla));
                tabla.addCell(new Phrase(c.getFrecuenciaActividad(), fuenteTabla));
            }

            document.add(tabla);
            document.close();
            System.out.println("PDF generado correctamente en: " + rutaDestino);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

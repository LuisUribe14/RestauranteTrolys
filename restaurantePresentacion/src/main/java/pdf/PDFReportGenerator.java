package pdf;

import DTOs.ClienteFrecuenteDTO;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author chris
 */
public class PDFReportGenerator {

    public static void generarReporteClientes(List<ClienteFrecuenteDTO> clientes, String filePath) throws IOException {
        // Crear el archivo y los directorios si no existen
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        // Crear el escritor y documento PDF
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Título centrado
        document.add(new Paragraph("Reporte de Clientes Frecuentes")
                .setBold()
                .setFontSize(16)
                .setTextAlignment(TextAlignment.CENTER));

        // Crear tabla con 7 columnas
        Table table = new Table(7);

        // Encabezados
        table.addHeaderCell(new Cell().add(new Paragraph("Nombre")));
        table.addHeaderCell(new Cell().add(new Paragraph("Apellido Paterno")));
        table.addHeaderCell(new Cell().add(new Paragraph("Apellido Materno")));
        table.addHeaderCell(new Cell().add(new Paragraph("Visitas")));
        table.addHeaderCell(new Cell().add(new Paragraph("Total Gastado")));
        table.addHeaderCell(new Cell().add(new Paragraph("Puntos")));
        table.addHeaderCell(new Cell().add(new Paragraph("Última Comanda")));

        // Formateo de fechas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Filas con los datos
        for (ClienteFrecuenteDTO dto : clientes) {
            table.addCell(new Cell().add(new Paragraph(dto.getNombre())));
            table.addCell(new Cell().add(new Paragraph(dto.getApellidoPaterno())));
            table.addCell(new Cell().add(new Paragraph(dto.getApellidoMaterno())));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(dto.getVisitas()))));
            table.addCell(new Cell().add(new Paragraph("$" + dto.getTotalGastado())));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(dto.getPuntos()))));
            table.addCell(new Cell().add(new Paragraph(
                    dto.getFechaUltimaComanda() != null ? dto.getFechaUltimaComanda().format(formatter) : "N/A")));
        }

        // Agregar tabla y cerrar
        document.add(table);
        document.close();
    }
}

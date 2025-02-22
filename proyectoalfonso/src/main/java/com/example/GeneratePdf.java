package com.example;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import java.io.File;

public class GeneratePdf {
    public static void main(String[] args) {
        String dest = "pedeefe.pdf";
        String imagePath = ".\\proyectoalfonso\\patricio.jpg";
        
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            
            // Texto con colores
            Paragraph coloredText = new Paragraph("Proyecto interfaces Alfonso")
                    .setFontColor(new DeviceRgb(255, 0, 255));
            document.add(coloredText);
            
            // Añadir una tabla
            Table table = new Table(3);
            table.addCell("Mario");
            table.addCell("Serradilla");
            table.addCell("Penido");

            table.addCell("Angel");
            table.addCell("Garcia");
            table.addCell("Ojeda");

            table.addCell("Daniel");
            table.addCell("Jimenez");
            table.addCell("Zapata");

            document.add(table);
            
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                ImageData imageData = ImageDataFactory.create(imagePath);
                Image image = new Image(imageData).setWidth(200);
                document.add(image);
            } else {
                document.add(new Paragraph("No se encuntra la imagen"));
            }
            
            document.close();
            System.out.println("PDF creado en: " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

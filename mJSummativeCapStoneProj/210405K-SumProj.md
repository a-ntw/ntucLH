### PDF Export
The very basic
#### pom.xml
``` xml
    <dependency>
        <groupId>com.github.librepdf</groupId>
        <artifactId>openpdf</artifactId>
        <version>1.3.8</version>
    </dependency>
    <dependency>
        <groupId>net.sf.supercsv</groupId>
        <artifactId>super-csv</artifactId>
        <version>2.4.0</version>
    </dependency>
```
#### InvController.java
``` java
    @GetMapping("/inv/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        	Invoice inv = invoiceDao.getInvoiceById(1);
         
       UserPDFExporter exporter = new UserPDFExporter(inv);
       exporter.export(response);
    }
```

#### UserPDFExporter.java
``` java
package carDate.inv;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
public class UserPDFExporter {
	private Invoice inv;
	
	public UserPDFExporter(Invoice inv) {
		this.inv = inv;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
	}
	
	private void writeTableData(PdfPTable table) {
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize .A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		Paragraph p = new Paragraph("HELLO");

		document.add(p);
		
		document.close();
	}
}
```
---
### CarZoom
210405ExportPDF.png <img src="scrShot/210405ExportPDF.png">

#### UserPDFExporter.java
``` java
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class UserPDFExporter {
	private Invoice inv;
	
	public UserPDFExporter(Invoice inv) {
		this.inv = inv;
	}

	private void writeTableHeader(PdfPTable table) {
	}
	
	private void writeTableData(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);
        //Font font = FontFactory.getFont(FontFactory.HELVETICA);
        
        cell.setPhrase(new Phrase("Total Time Charge at Daily Rate: " + inv.getRated()));
        cell.setBorderWidth(0);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Sub Total: " + inv.getAmount()));
        cell.setIndent(10);
        cell.setBorderWidth(0);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase(""));
        cell.setBorderWidth(0);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase( "Total Due: $" + inv.getAmount()));
        table.addCell(cell);  
	}
	
	/*
	 * ref: https://www.programcreek.com/java-api-examples/?api=com.lowagie.text.pdf.PdfWriter
	 * add img - see example 18 
	 * */
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize .A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		Paragraph pT = new Paragraph("CarZoom Vehicle Leasing", new Font(Font.ITALIC, 10));
		document.add(pT);
		
		Paragraph p1 = new Paragraph("INVOICE", new Font(Font.COURIER, 18));
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		p1.setSpacingBefore(25);
		document.add(p1);
		
		Paragraph p2 = new Paragraph("Invoice No.: " + inv.getInvNo());
		p2.setAlignment(Paragraph.ALIGN_RIGHT);
		p2.setSpacingBefore(50);
		document.add(p2);
		
		Paragraph p3 = new Paragraph("Date: " + inv.getDated());
		document.add(p3);
		p3 = new Paragraph("Customer's ID: " + inv.getCustId());
		p3.setSpacingBefore(18);
		document.add(p3);
		
		Paragraph p4 = new Paragraph("Reservation Summary", new Font(Font.COURIER, 16));
		p4.setSpacingBefore(25);
		document.add(p4);
		Paragraph p5 = new Paragraph("Start and End Time: " + inv.getDesc1());
		document.add(p5);
		p5 = new Paragraph(inv.getDesc2());
		document.add(p5);
		p5 = new Paragraph(inv.getDesc3());
		document.add(p5);

		Paragraph p6 = new Paragraph("Invoice Details", new Font(Font.COURIER, 16));
		p6.setSpacingBefore(18);
		document.add(p6);
		p6 = new Paragraph("Reservation Charges No.: " + inv.getHireId());
		document.add(p6);
		
		PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {12.0f, 4.0f}); // total 17.5
        table.setSpacingBefore(18);
		writeTableData(table);
		document.add(table);
		
		Paragraph p7 = new Paragraph("Payment", new Font(Font.COURIER, 16));
		p7.setSpacingBefore(25);
		document.add(p7);
		p7 = new Paragraph("Payment Date: " + inv.getPaidDate());
		document.add(p7);

        Font font = FontFactory.getFont(FontFactory.TIMES_ITALIC);
        font.setSize(10);
		Paragraph pBottom = new Paragraph("Thank you for using CarZoom!", font);	
		pBottom.setSpacingBefore(25);
		document.add(pBottom);

		document.close();
		
	}
}
```
#### InvController.java
``` java
    @GetMapping("/inv/export/pdf/{invId}")
    public void exportToPDF(@PathVariable("invId") int invId, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

    	Invoice inv = invoiceDao.getInvoiceById(invId);
        	
    	log.warn("=====> /inv/export/pdf/> pdf: " + headerValue);
         
		UserPDFExporter exporter = new UserPDFExporter(inv);
		exporter.export(response);
    }
}
```

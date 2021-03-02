export to PDF file
===
[top]: topOfThePage


210302ExportPdf.png <img src="210302ExportPdf.png">

#### UserPDFExporter.java
``` java
package SpringManyToMany;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
 
 
public class UserPDFExporter {
    private List<Users> listUsers;
     
    public UserPDFExporter(List<Users> listUsers) {
        this.listUsers = listUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("User ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("User Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Password", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Roles", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Enabled", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
        for (Users user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getUsername());
            table.addCell(user.getPassword());
            table.addCell(user.getRoles().toString());
            table.addCell(String.valueOf(user.isEnabled()));
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
    
}
```

#### UserController.java
``` java

	@GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Users> listUsers = repo.findAll();
         
       UserPDFExporter exporter = new UserPDFExporter(listUsers);
       exporter.export(response);
    }
	
	@GetMapping("/users/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
         
        List<Users> listUsers = repo.findAll();
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"User ID", "Username", "Password", "Roles", "Enabled"};
        String[] nameMapping = {"id", "username", "password", "roles", "enabled"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (Users user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
         
        csvWriter.close();
         
    }

```

#### users.html
``` html
				
</table>				

<br>

<a th:href="@{/users/export/pdf}">Export to PDF</a> &nbsp;&nbsp;&nbsp; <a th:href="@{/users/export}">Export to CSV</a>

```


---
[:top: Top](#top)
package cryodex.export;

import cryodex.CryodexController;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportUtils {

    public static void displayHTML(String content, String filename) {
        String preventTableBreak = "table.print-friendly {page-break-inside: avoid;}";
        String mediaCss = "@media print {.pagebreak {page-break-after: always;}}";
        String fancyCss = "table{border-collapse: collapse;}th{color:white; background-color:DarkSlateGray; font-size:120%;} tr:nth-child(odd){    background-color:lightgray;}";
        String notFancyCss = "table{border-collapse: collapse;}th{color:black; background-color:white; font-size:120%;} tr:nth-child(odd){    background-color:lightgray;}";
        String internationalCharacters = "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />";
        
        String outputCss;
        
        if(CryodexController.getOptions().isPrinterFriendly()) outputCss = notFancyCss;
        else outputCss = fancyCss;
        
        String html = "<html><head><style type=\"text/css\">.smallFont{font-size:10px}"
                + outputCss + mediaCss + preventTableBreak + "</style>" + internationalCharacters + "</head><body>" + content + "</body></html>";

        try {
            File file = File.createTempFile(filename, ".html");

            FileOutputStream stream = new FileOutputStream(file);

            stream.write(html.getBytes("UTF-8"));
            stream.flush();
            stream.close();

            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    public static void addTableStart(StringBuilder sb){
        sb.append("<table border=\"1\">");
    }

    public static void addTableHeader(StringBuilder sb, String ...strings){
        
        sb.append("<tr>");
        
        for(String s : strings){
            sb.append("<th>").append(s).append("</th>");
        }
        
        sb.append("</tr>");
    }
    
    public static void addTableRow(StringBuilder sb, String ...strings){

        sb.append("<tr>");
        
        for(String s : strings){
            sb.append("<td>").append(s).append("</td>");
        }
        
        sb.append("</tr>");
    }
    
    public static void addTableEnd(StringBuilder sb){
        sb.append("</table>");
    }
    
    
}

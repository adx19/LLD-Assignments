import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    @Override
    protected ExportResult doExport(String title, String body) {
        String csv =
                "title,body\n" +
                escape(title) + "," +
                escape(body) + "\n";

        return new ExportResult("text/csv",
                csv.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        String escaped = s.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }
}
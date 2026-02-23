public class XmlExporter extends Exporter {
    @Override
    protected ExportResult doExport(String title, String body) {
        String xml = "<report><title>" + title +
                     "</title><body>" + body +
                     "</body></report>";

        return new ExportResult("application/xml",
                xml.getBytes());
    }
}
public abstract class Exporter {

    public final ExportResult export(ExportRequest req) {
        if (req == null) throw new IllegalArgumentException("request cannot be null");
        if (req.title == null) throw new IllegalArgumentException("title cannot be null");

        String body = req.body == null ? "" : req.body;

        return doExport(req.title, body);
    }

    protected abstract ExportResult doExport(String title, String body);
}
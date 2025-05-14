package project.csc427.core;

import java.io.FileWriter;
import java.io.IOException;

public class XMLExporter {
    public static void exportToXML(Component component, String filePath) {
        XMLExportVisitor visitor = new XMLExportVisitor();
        component.accept(visitor);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(visitor.getXML());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
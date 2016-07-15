import org.apache.commons.io.FileUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * Created by Shobal on 7/15/16.
 */
public class HTMLToPDF {

    public static void main (String args[]) throws Exception {

        FileUtils.writeByteArrayToFile(new File("Document.pdf"), toPdf("http://www.w3schools.com/html/demo_xhtml.asp"));

    }

    public static byte[] toPdf(String url) throws Exception {

        final ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        renderer.layout();

        ByteArrayOutputStream fos = new ByteArrayOutputStream(url.length());
        renderer.createPDF(fos);
        return fos.toByteArray();
    }

}

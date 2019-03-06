
import java.util.Arrays;
import java.util.List;

public class T {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "D", "E", "F");
        list.stream().peek(System.out::println);

//        try {
//            PDDocument document = PDDocument.load(new File("/home/ff/Downloads/VI_EDITOR.pdf"));
//            PDFRenderer pdfRenderer = new PDFRenderer(document);
//            pdfRenderer
//            for (int i=0; i<document.getNumberOfPages(); i++) {
//                BufferedImage bi = null;
//                Graphics2D g2d = bi.createGraphics();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        System.exit(0);
//        PrinterJob job = PrinterJob.getPrinterJob();
//        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
//
//        PageFormat pf = job.pageDialog(aset);
//        if (pf != null) {
//            job.setPrintable(new HelloWorldPrinter(), pf);
//
//            if (job.printDialog(aset)) {
//                try {
//                    job.print(aset);
//                } catch (PrinterException e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//            System.out.println("Dialog closed. Exiting");
//        }
    }
//
//    public static class HelloWorldPrinter
//            implements Printable {
//
//        public int print(Graphics g, PageFormat pf, int page)
//                throws PrinterException {
//
//
//
//            // We have only one page, and 'page'
//            // is zero-based
//            if (page > 0) {
//                return NO_SUCH_PAGE;
//            }
//
//            // User (0,0) is typically outside the
//            // imageable area, so we must translate
//            // by the X and Y values in the PageFormat
//            // to avoid clipping.
//            Graphics2D g2d = (Graphics2D) g;
//            g2d.translate(pf.getImageableX(), pf.getImageableY());
//
//            // Now we perform our rendering
//            g.drawString("Hello world!", 100, 100);
//
//            // tell the caller that this page is part
//            // of the printed document
//            return PAGE_EXISTS;
//        }
//    }
}

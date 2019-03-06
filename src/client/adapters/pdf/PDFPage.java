package client.adapters.pdf;

import shared.Page;
import client.adapters.ImageFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PDFPage implements Page {

    private BufferedImage bi;
    private ImageFormat format;

    public PDFPage(BufferedImage bi, ImageFormat format) {
        this.bi = bi;
        this.format = format;
    }

    @Override
    public Byte[] getBytes() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format.toString(), baos);

        byte[] prims = baos.toByteArray();
        Byte[] bytes = new Byte[prims.length];
        for (int i=0; i<prims.length; i++) {
            bytes[i] = prims[i];
        }
        //check gc

        return bytes;
    }
}

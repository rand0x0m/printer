package shared;

import java.io.IOException;

public interface Page {
    Byte[] getBytes() throws IOException;
}

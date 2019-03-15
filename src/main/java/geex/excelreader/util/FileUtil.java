package geex.excelreader.util;

import java.io.InputStream;

/**
 * //TODO description.
 *
 * @author JuChen
 * @date 2019/3/12
 */
public class FileUtil {
    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }
}

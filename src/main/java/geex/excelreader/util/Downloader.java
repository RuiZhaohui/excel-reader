package geex.excelreader.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * //TODO description.
 *
 * @author JuChen
 * @date 2019/3/12
 */
public class Downloader {
    public static void download(String url, String fileName) throws IOException {
        FileUtils.copyURLToFile(new URL(url), new File(fileName));
    }
}

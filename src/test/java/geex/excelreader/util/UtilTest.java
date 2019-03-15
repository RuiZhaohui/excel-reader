package geex.excelreader.util;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void download() {
        String url = "https://www.geexfinance.com/group1/M00/7F/5B/wKhkJFwN9fCARD6SAEwh-re-KxI806.mp4";
        String fileName = "E:/NYB01-180325-217009/wKhkJFwN9fCARD6SAEwh-re-KxI806.mp4";
        try {
            Downloader.download(url, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAudio() {
        String videoPath = "E:/NYB01-180325-217009/wKhkJFwN9fCARD6SAEwh-re-KxI806.mp4";
        String audioPath = "E:/NYB01-180325-217009/wKhkJFwN9fCARD6SAEwh-re-KxI806";
        FFMpegUtil.videoToAudio(videoPath, audioPath);
    }
}
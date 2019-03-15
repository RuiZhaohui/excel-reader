package geex.excelreader.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * //TODO description.
 *
 * @author JuChen
 * @date 2019/3/12
 */
public class FFMpegUtil {
    private static final Logger logger = LoggerFactory.getLogger(FFMpegUtil.class);

    private static final String FFMPEG_PATH = "D:\\ffmpeg\\bin\\ffmpeg.exe";

    /**
     * 视频转音频
     * @param videoUrl
     */
    public static String videoToAudio(String videoUrl, String audioPath){
        String wavFile;
        try {
            wavFile = audioPath + ".wav";
            String command = FFMPEG_PATH + " -i "+ videoUrl + " -f wav -ar 16000 "+ wavFile;
            logger.info("video to audio command : " + command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            logger.error("视频转音频失败，视频地址："+videoUrl, e);
        }
        return "";
    }
}

package geex.excelreader.handler;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import geex.excelreader.model.VideoModel;
import geex.excelreader.util.Downloader;
import geex.excelreader.util.FFMpegUtil;
import geex.excelreader.util.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * //TODO description.
 *
 * @author JuChen
 * @date 2019/3/12
 */
@Slf4j
public class ExcelHandler {
    public void readExcel() throws InterruptedException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("video.xlsx");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0, VideoModel.class));
        String domain = "https://example.com/";
        for (Object entity : data) {
            VideoModel model = (VideoModel) entity;
            String[] paths = model.getVideoPath().split("/");
            String filename = paths[paths.length - 1];
            String url = domain + model.getVideoPath();
            String videoFilePath = "E:/music/" + model.getNum() + "/" + filename;
            String audioFilePath = "E:/music/" + model.getNum() + "/" + filename.split("\\.")[0];
            log.info("url: {} ---- videoFilePath: {}  ----- audioFilePath: {}", url, videoFilePath, audioFilePath);
            try {
                Downloader.download(url, videoFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            boolean hasVideo = false;
            while (!hasVideo) {
                File file = new File(videoFilePath);
                if (!file.exists()) {
                    Thread.sleep(100);
                } else {
                    hasVideo = true;
                }
            }
            FFMpegUtil.videoToAudio(videoFilePath, audioFilePath);
        }
    }
}

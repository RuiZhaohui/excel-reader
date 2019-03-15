package geex.excelreader;

import geex.excelreader.handler.ExcelHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExcelReaderApplication.class)
public class ExcelReaderApplicationTests {

    @Test
    public void contextLoads() throws InterruptedException {
        ExcelHandler excelHandler = new ExcelHandler();
        excelHandler.readExcel();
    }

}

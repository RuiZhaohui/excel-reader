package geex.excelreader.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * //TODO description.
 *
 * @author JuChen
 * @date 2019/3/12
 */
@ToString
@Getter
@Setter
public class VideoModel extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String num;
    @ExcelProperty(index = 8)
    private String videoPath;
}

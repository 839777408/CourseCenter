package top.nanzx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Nan
 * @Date: Created in 14:40 2021/1/24
 * @Description: 返回封装后的Json
 */
@Data
@AllArgsConstructor
public class JsonResult {
    private int state;//1表示正常，0表示异常

    private String message;//状态码对应的具体信息

    private Object data;//返回页面需要的数据

}

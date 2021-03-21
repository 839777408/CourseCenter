package top.nanzx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 10:36 2021/3/21
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Directory {
    private String label;
    private List<Object> children;
}

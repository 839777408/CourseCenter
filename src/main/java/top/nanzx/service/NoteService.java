package top.nanzx.service;

import top.nanzx.dto.JsonResult;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 22:45 2021/2/4
 * @Description:
 */
public interface NoteService {

    JsonResult getNotes(String no, Integer currentPage, Integer size);

    JsonResult addNote(HashMap<String, String> map);

    JsonResult getNote(String id);

    JsonResult editNote(HashMap<String, String> map);

    JsonResult delNote(String id);
}

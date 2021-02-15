package top.nanzx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nanzx.dao.NoteDao;
import top.nanzx.dto.JsonResult;
import top.nanzx.entity.Note;
import top.nanzx.service.NoteService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 22:45 2021/2/4
 * @Description:
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    /**
     * @Author: Nan
     * @Param: [no, currentPage, size, prop, order]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 22:34 2021/2/6
     * @Description: 获取当前页的多条笔记（分页查询）
     */
    @Override
    public JsonResult getNotes(String no, Integer currentPage, Integer size) {
        PageHelper.startPage(currentPage, size);
        List<Note> notes = noteDao.getNotes(no);
        PageInfo<Note> pageInfo = new PageInfo<>(notes, 5);
        return new JsonResult(0, "获取当前页的所有笔记成功！", pageInfo);
    }

    /**
     * @Author: Nan
     * @Param: [no, title, content]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 22:23 2021/2/2
     * @Description: 添加笔记
     */
    @Override
    public JsonResult addNote(HashMap<String, String> map) {
        String no = map.get("no");
        String title = map.get("title");
        String content = map.get("content");
        Date date = new Date();

        Boolean flag = noteDao.addNote(no, title, content, date);
        if (flag) {
            return new JsonResult(0, "添加笔记成功！", null);
        } else {
            return new JsonResult(1, "添加笔记失败！", null);
        }
    }

    /**
     * @Author: Nan
     * @Param: [id]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 22:40 2021/2/4
     * @Description: 获取该用户的某个笔记
     */
    @Override
    public JsonResult getNote(String id) {
        Note note = noteDao.getNote(id);
        if (note != null) {
            return new JsonResult(0, "查询笔记成功！", note);
        } else {
            return new JsonResult(1, "查询笔记失败！", null);
        }
    }

    /**
     * @Author: Nan
     * @Param: [map]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 20:44 2021/2/9
     * @Description: 修改笔记
     */
    @Override
    public JsonResult editNote(HashMap<String, String> map) {
        String id = map.get("id");
        String title = map.get("title");
        String content = map.get("content");
        Date date = new Date();

        Boolean flag = noteDao.editNote(id, title, content, date);
        if (flag) {
            return new JsonResult(0, "修改笔记成功！", null);
        } else {
            return new JsonResult(1, "修改笔记失败！", null);
        }
    }

    /**
     * @Author: Nan
     * @Param: [id]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 20:45 2021/2/9
     * @Description: 删除笔记
     */
    @Override
    public JsonResult delNote(String id) {
        Boolean flag = noteDao.delNote(id);
        if (flag) {
            return new JsonResult(0, "删除笔记成功！", null);
        } else {
            return new JsonResult(1, "删除笔记失败！", null);
        }
    }
}

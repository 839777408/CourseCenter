package top.nanzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.nanzx.dto.JsonResult;
import top.nanzx.service.NoteService;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 22:43 2021/2/4
 * @Description:
 */
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/getNotes")
    public JsonResult getNotes(String no, Integer currentPage, Integer size) {
        if (currentPage == null || currentPage < 1) {
            currentPage = 1;
        }
        return noteService.getNotes(no, currentPage, size);
    }

    @PostMapping("/addNote")
    public JsonResult addNote(@RequestBody HashMap<String, String> map) {
        return noteService.addNote(map);
    }

    @GetMapping("/getNote/{id}")
    public JsonResult getNote(@PathVariable("id") String id) {
        return noteService.getNote(id);
    }

    @PutMapping("/editNote")
    public JsonResult editNote(@RequestBody HashMap<String, String> map) {
        return noteService.editNote(map);
    }

    @DeleteMapping("/delNote/{id}")
    public JsonResult delNote(@PathVariable("id") String id) {
        return noteService.delNote(id);
    }
}

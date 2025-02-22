package org.nuc.course.controller;
import org.nuc.course.core.Result;
import org.nuc.course.core.ResultGenerator;
import org.nuc.course.dto.CommentDTO;
import org.nuc.course.model.Comment;
import org.nuc.course.db.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.nuc.course.utils.DateUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xmmmmmovo on 2020/01/04.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public Result add(Comment comment) {
        comment.setCommentTime(DateUtils.getTimeStamp());
        commentService.save(comment);
        CommentDTO commentDTO = commentService.findADTO(comment.getId());
        return ResultGenerator.genSuccessResult(commentDTO);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Long id) {
        commentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PatchMapping("/update")
    public Result update(Comment comment) {
        commentService.update(comment);
        CommentDTO commentDTO = commentService.findADTO(comment.getId());
        return ResultGenerator.genSuccessResult(commentDTO);
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Comment comment = commentService.findById(id);
        return ResultGenerator.genSuccessResult(comment);
    }

    @PostMapping("/art_comment")
    public Result artComment(@RequestParam(defaultValue = "0") Integer page,
                             @RequestParam(defaultValue = "0") Integer size,
                             @RequestParam Long id) {

        PageHelper.startPage(page, size);
        List<CommentDTO> comments = commentService.findByArtId(id);
        PageInfo pageInfo = new PageInfo(comments);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CommentDTO> list = commentService.findAllList();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/all")
    public Result all() {
        return ResultGenerator.genSuccessResult(commentService.findAll());
    }
}
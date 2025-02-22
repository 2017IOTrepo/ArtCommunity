package org.nuc.course.controller;
import org.nuc.course.core.Result;
import org.nuc.course.core.ResultGenerator;
import org.nuc.course.dto.LikeDTO;
import org.nuc.course.model.LikeList;
import org.nuc.course.db.service.LikeListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.nuc.course.utils.DateUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by xmmmmmovo on 2020/01/07.
*/
@RestController
@RequestMapping("/like/list")
public class LikeListController {
    @Resource
    private LikeListService likeListService;

    @PostMapping("/add")
    public Result add(LikeList likeList) {
        likeList.setLikeTime(DateUtils.getTimeStamp());
        likeListService.save(likeList);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Long id) {
        likeListService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PatchMapping("/update")
    public Result update(LikeList likeList) {
        likeListService.update(likeList);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        LikeDTO likeDTO = likeListService.findADTO(id);
        return ResultGenerator.genSuccessResult(likeDTO);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size
    ) {
        PageHelper.startPage(page, size);
        List<LikeDTO> list = likeListService.findAllList();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/find_user_art_list")
    public Result listUserList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size,
            @RequestParam Long id
    ) {
        PageHelper.startPage(page, size);
        List<LikeDTO> list = likeListService.findLikeDTO(id);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/find_is_like")
    public Result findIsLike(@RequestParam Long userId,
                             @RequestParam Long artId) {
        List<LikeDTO> likeDTO = likeListService.findALikeDTO(userId, artId);
        return ResultGenerator.genSuccessResult(likeDTO);
    }
}

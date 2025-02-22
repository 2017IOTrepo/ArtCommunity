package org.nuc.course.controller;

import org.nuc.course.core.Result;
import org.nuc.course.core.ResultGenerator;
import org.nuc.course.dto.ArticleDTO;
import org.nuc.course.dto.LikeDTO;
import org.nuc.course.model.Article;
import org.nuc.course.db.service.ArticleService;
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
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/add")
    public Result add(Article article) {
        article.setCreateTime(DateUtils.getTimeStamp());
        articleService.save(article);
        ArticleDTO articleDTO = articleService.findADTO(article.getId());
        return ResultGenerator.genSuccessResult(articleDTO);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Long id) {
        articleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PatchMapping("/update")
    public Result update(Article article) {
        articleService.update(article);
        ArticleDTO articleDTO = articleService.findADTO(article.getId());
        return ResultGenerator.genSuccessResult(article);
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        ArticleDTO articleDTO = articleService.findADTO(id);
        return ResultGenerator.genSuccessResult(articleDTO);
    }

    @PostMapping("/list")
    public Result list(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size
    ) {
        PageHelper.startPage(page, size);
        List<ArticleDTO> list = articleService.findAllList();
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
        List<ArticleDTO> list = articleService.findArticleDTO(id);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

package org.nuc.course.db.service;
import org.nuc.course.dto.ArticleDTO;
import org.nuc.course.dto.CommentDTO;
import org.nuc.course.model.Comment;
import org.nuc.course.db.service.Service;

import java.util.List;


/**
 * Created by xmmmmmovo on 2020/01/04.
 */
public interface CommentService extends Service<Comment> {
    List<CommentDTO> findAllList();
    CommentDTO findADTO(Long id);
    List<CommentDTO> findByArtId(Long id);
}
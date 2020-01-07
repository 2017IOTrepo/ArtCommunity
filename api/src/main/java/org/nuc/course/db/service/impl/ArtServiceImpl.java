package org.nuc.course.db.service.impl;

import org.nuc.course.db.dao.ArtMapper;
import org.nuc.course.dto.ArtDTO;
import org.nuc.course.model.Art;
import org.nuc.course.db.service.ArtService;
import org.nuc.course.db.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xmmmmmovo on 2020/01/04.
 */
@Service
@Transactional
public class ArtServiceImpl extends AbstractService<Art> implements ArtService {
    @Resource
    private ArtMapper artMapper;

    @Override
    public List<ArtDTO> findAllList() {
        return artMapper.findAllDTO();
    }

    @Override
    public List<ArtDTO> findUserDTO(String token) {
        return artMapper.findUserDTO(token);
    }

    @Override
    public ArtDTO findADTO(Long id) {
        return artMapper.findIdDTO(id);
    }
}

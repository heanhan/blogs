package com.zhaojh.blogs.service.impl;

import com.zhaojh.blogs.dao.IPersonalNotesDao;
import com.zhaojh.blogs.pojo.PersonalNotes;
import com.zhaojh.blogs.service.IPersonalNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author : zhaojh
 * @date : 2019-10-12
 * @function : 个人随记的业务实现层
 *
 */

@Service
public class PersonalNotesServiceImpl implements IPersonalNotesService {


    @Autowired
    private IPersonalNotesDao personalNotesDao;



    /**
     *
     * @param personalNotes 随记
     * @return success / fail
     */
    @Override
    @Transactional
    public String addPersonalNotes(PersonalNotes personalNotes){
        PersonalNotes save = personalNotesDao.save(personalNotes);
        if (save.getId()!=null&&"".equals(save.getId())){
            return "success";
        }
        return "fail";
    }


    /**
     * 分页查询随记
     * @param pageRequest 分页参数
     * @return String
     */
    @Override
    public Page<PersonalNotes> findAllPersonalNotesByPage(PageRequest pageRequest){
        Page<PersonalNotes> personalNotesPage = personalNotesDao.findAll(pageRequest);
        return personalNotesPage;
    }
}

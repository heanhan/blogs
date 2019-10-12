package com.zhaojh.blogs.service;

import com.zhaojh.blogs.pojo.PersonalNotes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IPersonalNotesService {

    /**
     *
     * @param personalNotes 随记
     * @return success / fail
     */
    String addPersonalNotes(PersonalNotes personalNotes);

    /**
     * 分页查询随记
     * @param pageRequest 分页参数
     * @return String
     */
    Page<PersonalNotes> findAllPersonalNotesByPage(PageRequest pageRequest);
}

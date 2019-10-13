package com.zhaojh.blogs.service;

import com.zhaojh.blogs.pojo.PersonalNotes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

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

    /**
     * 根据随记的id查询单条随记
     * @param id id
     * @return PersonalNotes
     */
    PersonalNotes findPersonalNotesById(String id);
}

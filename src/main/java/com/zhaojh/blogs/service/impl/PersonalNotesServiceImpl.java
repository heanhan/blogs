package com.zhaojh.blogs.service.impl;

import com.zhaojh.blogs.dao.IPersonalNotesDao;
import com.zhaojh.blogs.pojo.PersonalNotes;
import com.zhaojh.blogs.service.IPersonalNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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


    /**
     * 根据随记的id查询单条随记
     * @param id id
     * @return PersonalNotes
     */
    @Override
    public PersonalNotes findPersonalNotesById(String id){
        Optional<PersonalNotes> optionPersonalNotes = personalNotesDao.findById(id);
        /**
         * Optinal jdk 8 特性  可以避免空指针
         *  重要的方法
         *          get(): 获取当前对象
         *          isPresent() 如果值存在返回true，否则返回false。
         *          empty() 返回一个空的 Optional实例。
         *          of(T value) 为非null的值创建一个Optional。
         *          ofNullable(T value) 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
         *          orElse(T other) 如果有值则将其返回，否则返回指定的其它值other。
         */
        PersonalNotes personalNotes = optionPersonalNotes.get();
        return personalNotes;
    }


    /**
     * 统计个人随记的数量。
     * @return long
     */
    @Override
    public long countPersonalNotes(){
        long count = personalNotesDao.count();
        return count;
    }
}

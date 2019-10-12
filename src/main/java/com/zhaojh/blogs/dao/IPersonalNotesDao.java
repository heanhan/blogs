package com.zhaojh.blogs.dao;

import com.zhaojh.blogs.pojo.PersonalNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonalNotesDao extends JpaRepository<PersonalNotes,String>, JpaSpecificationExecutor<PersonalNotes> {


}

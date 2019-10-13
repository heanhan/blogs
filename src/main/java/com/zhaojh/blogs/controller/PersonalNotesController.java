package com.zhaojh.blogs.controller;

import com.zhaojh.blogs.pojo.PersonalNotes;
import com.zhaojh.blogs.service.IPersonalNotesService;
import com.zhaojh.blogs.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-10-12
 * @function : 个人随机的 控制层
 */

@Slf4j
@Controller
@RequestMapping(value = "/personaleNotes")
public class PersonalNotesController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private HttpServletRequest request ;

    @Autowired
    private IPersonalNotesService personalNotesService;


    /**
     * 添加心情随记
     * @param title 标题
     * @param category 分类
     * @param content  随记的内容
     * @return success/fail
     */
    @PostMapping(value = "/addPersonalNotes")
    @ResponseBody
    public String addPersonalNotes(String title,String category,String content) throws ParseException {
        log.info("接受的参数为"+title+" /"+category+"/"+content);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
;        String account = (String)request.getSession().getAttribute("account");//获取当前用户
        /**
         * 判断当前用户是否存在，不存在，返回浏览器，提示登录。
         */
        if(account==null||"".equals(account)){
            return "inputAccount";//返回提示 提示登录，否则无法记录随记
        }
        String timeDate= sdf.format(new Date());
        PersonalNotes personalNotes = new PersonalNotes();//个人随机的实体类
        personalNotes.setId(idWorker.nextId()+"");//添加主键
        personalNotes.setAuthor(account);//作者
        personalNotes.setTitle(title+"-"+timeDate);//标题
        personalNotes.setCategory(category);//分类
        personalNotes.setContent(content);//内容
        personalNotes.setPraise("0");//初始化点赞 为0
        personalNotes.setReadNumber("0");//初始化 阅读量为 0
        personalNotes.setCreateTime(new Date(Calendar.getInstance().getTimeInMillis()));//创建时间
        String result = personalNotesService.addPersonalNotes(personalNotes);//添加随记入库
        return result;//返回处理结果
    }

    /**
     * 分页查询 个人随记
     * @return
     */
    @GetMapping(value = "/findAllPersonalNotesByPage")
    @ResponseBody
    public Page<PersonalNotes> findAllPersonalNotesByPage(@RequestParam(defaultValue = "1")String pageIndex,@RequestParam(defaultValue = "1")String size){
        log.info("个人随记的分页查询：当前页"+pageIndex+"每页 大小："+size);
        PageRequest pageRequest= PageRequest.of(Integer.parseInt(pageIndex)-1, Integer.parseInt(size));//封装分页参数
        Page<PersonalNotes> allPersonalNotesByPage = personalNotesService.findAllPersonalNotesByPage(pageRequest);

        return allPersonalNotesByPage;

    }

    /**
     * 根据随记的id 查询单条随记
     * @param id  id
     * @return PersonnalNotese
     */
    @GetMapping(value = "/findPersonalNotesById")
    @ResponseBody
    public PersonalNotes findPersonalNotesById(String id){
        log.info("获取的随记的id为："+id);
        PersonalNotes personalNotes =  personalNotesService.findPersonalNotesById(id);
        return personalNotes;
    }
}

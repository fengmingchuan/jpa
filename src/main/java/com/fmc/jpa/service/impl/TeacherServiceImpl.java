package com.fmc.jpa.service.impl;

import com.fmc.jpa.dao.Course;
import com.fmc.jpa.dao.Teacher;
import com.fmc.jpa.entity.EduCourse;
import com.fmc.jpa.entity.EduTeacher;
import com.fmc.jpa.entity.vo.CourseInfo;
import com.fmc.jpa.entity.vo.QueryTeacher;
import com.fmc.jpa.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private Teacher teacher;

    @Autowired
    private Course course;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EduTeacher> getList() {

        List<EduTeacher> all = teacher.findAll();

        return all;
    }

    @Override
    public Page<EduTeacher> getPageList() {
        Pageable pageable = PageRequest.of(1,4);
        Page<EduTeacher> pa = teacher.findAll(pageable);
       return  pa;
    }

  /*  @Override
    public List<CourseInfo> querysfindQuery(QueryTeacher queryTeacher) {

*//*
        StringBuffer sql = new StringBuffer("SELECT et.name AS name,et.level AS level,ec.title  AS title,ec.price  AS price,ec.lesson_num AS  lessonNum   FROM  edu_course ec INNER JOIN edu_teacher et  ON et.id=ec.teacher_id   WHERE 1=1");

        if (  queryTeacher.getName() != null){
            sql.append("  and et.name   like  '%"+queryTeacher.getName()+"%'");
        }
        if (queryTeacher.getTitle()!=null){
            sql.append(" and ec.title="+queryTeacher.getTitle());
        }
        if (queryTeacher.getLessonNum()!=null){
            sql.append(" and ec.lesson_num="+queryTeacher.getLessonNum());
        }
        System.out.println("sql:"+sql.toString());
        Query nativeQuery = em.createNativeQuery(sql.toString());
        List<CourseInfo> resultList = nativeQuery.getResultList();
        return resultList;*//*
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("title",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("lessonNum",ExampleMatcher.GenericPropertyMatchers.exact()) ; //
        EduCourse ec = new EduCourse();
        BeanUtils.copyProperties(queryTeacher,ec);
        Example<EduCourse> example = Example.of(ec, exampleMatcher);
        List<EduCourse> all = course.findAll(example);
        ArrayList<CourseInfo> courseInfos = new ArrayList<>();
        BeanUtils.copyProperties(all,courseInfos);
        return  courseInfos;



    }*/
}

package com.fmc.jpa.service;

import com.fmc.jpa.entity.EduCourse;
import com.fmc.jpa.entity.EduTeacher;
import com.fmc.jpa.entity.vo.CourseInfo;
import com.fmc.jpa.entity.vo.QueryTeacher;

import java.util.List;

public interface CourseService {
    List<EduCourse> querysfindQuery(QueryTeacher queryTeacher);
    List<EduCourse>  parmsMany(QueryTeacher queryTeacher);
    List<CourseInfo>  list() ;
}

package com.fmc.jpa.service;

import com.fmc.jpa.entity.EduTeacher;
import com.fmc.jpa.entity.vo.CourseInfo;
import com.fmc.jpa.entity.vo.QueryTeacher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TeacherService {
    List<EduTeacher> getList();
    Page<EduTeacher> getPageList();

}

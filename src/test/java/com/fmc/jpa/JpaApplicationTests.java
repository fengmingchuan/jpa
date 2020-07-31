package com.fmc.jpa;

import com.fmc.jpa.entity.EduCourse;
import com.fmc.jpa.entity.EduTeacher;
import com.fmc.jpa.entity.vo.CourseInfo;
import com.fmc.jpa.entity.vo.QueryTeacher;
import com.fmc.jpa.service.CourseService;
import com.fmc.jpa.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootTest
class JpaApplicationTests {
    @Autowired
  private   TeacherService ts;
    @Autowired
    CourseService cs;
    @Test
    void contextLoads() {

      //  List<EduTeacher> list = ts.getList();
       /* Page<EduTeacher> pageList = ts.getPageList();
        List<EduTeacher> list = pageList.toList();
         System.out.println("共计:"+pageList.getSize());*/
       /* QueryTeacher qt = new QueryTeacher();
        qt.setName("王");
        List<CourseInfo> li = ts.querysfindQuery(qt);
        for (CourseInfo cs: li) {
            System.out.println(cs.toString());
        }*/
/*        QueryTeacher qt = new QueryTeacher();
        qt.setTitle("HTML");
        List<CourseInfo> courseInfos = cs.querysfindQuery(qt);*/
        QueryTeacher qt = new QueryTeacher();
        qt.setTitle("HTML");
        List<EduCourse> courseInfos = cs.querysfindQuery(qt);
        for (EduCourse c: courseInfos
             ) {
            System.out.println("发生分解算法就看撒JFK链接发");
            System.out.println(c.toString());
        }
    }
    @Test
    void contextLoads1() {
       /* QueryTeacher qt = new QueryTeacher();
        qt.setTitle("HTML");
        qt.setName("王");
        List<EduCourse> eduCourses = cs.parmsMany(qt);
        for (EduCourse e: eduCourses
             ) {
            System.out.println(eduCourses.toString());
        }*/
        List<CourseInfo> list = cs.list();
        for (CourseInfo ci: list
             ) {
            System.out.println(ci.toString());
        }
    }
}

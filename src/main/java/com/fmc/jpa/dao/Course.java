package com.fmc.jpa.dao;

import com.fmc.jpa.entity.EduCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Course   extends JpaRepository<EduCourse,String > , JpaSpecificationExecutor<EduCourse> {
@Query(value = "SELECT ec.title,ec.price,et.name FROM  edu_teacher et INNER JOIN edu_course ec WHERE" +
        " et.id=ec.teacher_id AND ec.title LIKE '%HTML%'",nativeQuery = true)
    List<Object[]>  selectByNameAndTitle(  String title);

}

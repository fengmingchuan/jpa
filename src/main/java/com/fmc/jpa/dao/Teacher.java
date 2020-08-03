package com.fmc.jpa.dao;

import com.fmc.jpa.entity.EduTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface Teacher  extends JpaRepository<EduTeacher,String>, JpaSpecificationExecutor<EduTeacher> {

 //hello word  sdfasfdsf


}

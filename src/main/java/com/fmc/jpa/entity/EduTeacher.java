package com.fmc.jpa.entity;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author testjava
 * @since 2020-02-24
 */
@Data
@Entity
@Table(name="edu_teacher")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

   @Id
    private String id;


    private String name;


    private String intro;


    private String career;


    private Integer level;

    private String avatar;


    private Integer sort;


    private Boolean isDeleted;



    private Date gmtCreate;


    private Date gmtModified;




}

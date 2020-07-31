package com.fmc.jpa.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author testjava
 * @since 2020-04-04
 */
@Data
@Entity
@Table(name = "edu_course")
public class EduCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
//贵ui一看就立刻
    private String teacherId;


    private String subjectId;


    private String subjectParentId;


    private String title;


    private BigDecimal price;


    private Integer lessonNum;


    private String cover;


    private Long buyCount;


    private Long viewCount;


    private Long version;


    private String status;


    private Integer isDeleted;


    private Date gmtCreate;


    private Date gmtModified;


}

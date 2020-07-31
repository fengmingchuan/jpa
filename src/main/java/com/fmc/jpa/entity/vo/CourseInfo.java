package com.fmc.jpa.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor

public class CourseInfo  implements Serializable {
    private static final long serialVersionUID = 7L;
    private  String title;
    private BigDecimal price;
    private  String name;
    public  CourseInfo(String title,BigDecimal price,String name){
        super();
        this.title=title;
        this.price=price;
        this.name=name;
    }

}

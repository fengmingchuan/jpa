package com.fmc.jpa.service.impl;

import com.fmc.jpa.dao.Course;
import com.fmc.jpa.entity.EduCourse;
import com.fmc.jpa.entity.EduTeacher;
import com.fmc.jpa.entity.vo.CourseInfo;
import com.fmc.jpa.entity.vo.QueryTeacher;
import com.fmc.jpa.service.CourseService;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    Course course;

    @PersistenceContext
    EntityManager entityManager;

    @Override

    public List<EduCourse> querysfindQuery(QueryTeacher queryTeacher) {
        String likeitle = queryTeacher.getTitle();
      /*  Specification<EduCourse> spe = new Specification<EduCourse>() {
            //实现接口的方法   关于Root、CriteriaBuilder上面有介绍
            public Predicate toPredicate(Root<EduCourse> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //获取实体属性name
                Path<Object> name = root.get("name");
                //根据指定的姓名查询
                Predicate select = cb.equal(name, "蚂蚁小哥");
                //返回一定是Predicate类型
                return select;
            }
        };*/
        Specification<EduCourse> spe = new Specification<EduCourse>() {
            @Override
            public Predicate toPredicate(Root<EduCourse> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Path<Object> title = root.get("title");
                System.out.println("爱丽丝大舅啊龙卷风：" + title + "'%" + likeitle + "%'");
                Predicate select = cb.like(title.as(String.class), "%" + likeitle + "%");
                return select;
            }

        };
        List<EduCourse> titles = course.findAll(spe);


        return titles;

/*

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
        Query query = em.createNativeQuery(sql.toString()).setFirstResult(0).setMaxResults(10);
        return  query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(CourseInfo.class)).getResultList();
*/



       /*
        Query query=entityManager.createNativeQuery(sql).setFirstResult(0).setMaxResults(10);

        return query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(StudentInfo.class)).getResultList();







       ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("title",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("lessonNum",ExampleMatcher.GenericPropertyMatchers.exact()) ;
        EduCourse ec = new EduCourse();
        BeanUtils.copyProperties(queryTeacher,ec);
        Example<EduCourse> example = Example.of(ec, exampleMatcher);
        List<EduCourse> all = course.findAll(example);
        System.out.println(all+"sdaffaa啊的设计费刷卡积分的快捷方式咖啡碱撒");
        ArrayList<CourseInfo> courseInfos = new ArrayList<>();
        CourseInfo  ci =null;
        for (EduCourse e: all
             ) {
         ci=  new CourseInfo();
         BeanUtils.copyProperties(e,ci);
         courseInfos.add(ci);
        }
        return  courseInfos;


         i  //根据gradeName 查询user
 87                 if (StringUtils.isNotBlank(params.getGradeName())) {
 88                     Join<Grade, User> join = root.join("grade", JoinType.LEFT);
 89                     list.add(cb.equal(join.get("gradeName"), params.getGradeName()));
 90                 }
*/


    }

    @Override
    public List<EduCourse> parmsMany(QueryTeacher queryTeacher) {
        List<EduCourse> all = course.findAll(new Specification<EduCourse>() {
            @Override
            public Predicate toPredicate(Root<EduCourse> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (queryTeacher.getName() != null) {
                    Join<EduTeacher, EduCourse> join = root.join("eduTeacher", JoinType.LEFT);
                    predicates.add(cb.like(join.get("name").as(String.class), "%" + queryTeacher.getName() + "%"));
                }
                if (queryTeacher.getTitle() != null || queryTeacher.getTitle() != " ") {

                    predicates.add(cb.like(root.get("title").as(String.class), "%" + queryTeacher.getTitle() + "%"));
                }
                if (queryTeacher.getLessonNum() != null) {

                    predicates.add(cb.equal(root.get("lessonNum"), queryTeacher.getName()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                criteriaQuery.where(predicates.toArray(pre));
                return cb.and(predicates.toArray(pre));
            }
        });

        return all;
    }

    @Override
    public List<CourseInfo> list() {
        QueryTeacher qt = new QueryTeacher();
        qt.setName("王");
        qt.setTitle("HTML");
       /* qt.setLessonNum(10);*/

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ec.title,ec.price,et.name FROM  edu_teacher et INNER JOIN edu_course ec WHERE et.id=ec.teacher_id ");
        if (qt.getName() != null && !qt.getName().equals("")) {
            sb.append(" and  et.name like '%" + qt.getName() + "%'");
        }
        if (qt.getName() != null && !qt.getName().equals("")) {
            sb.append(" and  ec.title like '%" + qt.getTitle() + "%'");
        }
        if (qt.getLessonNum() != null && !qt.getLessonNum().equals("")) {
            sb.append(" and  ec.lesson_num = " + qt.getLessonNum());
        }
//sqljoint.apped("附加的where子句")
        String sql = sb.toString();
        System.out.println("sql的语句："+sql);
        /*  em.getTransaction().begin();*/
//创建原生查询的时候，将info.class类即第二个参数，写成要传回的bean，这样就可以直接用List<Bean>接收



       /* Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(CourseInfo.class));*/
        List<CourseInfo> list = entityManager.createNativeQuery(sql).unwrap(Query.class)
                               .setResultTransformer(Transformers.aliasToBean(CourseInfo.class)).list();

//cvzxcv
        return  list;










       /*

        List<Object[]> wang = course.selectByNameAndTitle("wang");
        //要保证参数名字对顺序一致
        List<CourseInfo> objects = null;
        try {
            objects = CastEntityUtil.castEntity(wang, CourseInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return   objects;*/
    }
}

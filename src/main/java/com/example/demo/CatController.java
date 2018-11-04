package com.example.demo;

import com.example.demo.model.CatEntity;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;
import java.util.Vector;

/**
 * @author gaojindan
 * @date 2018/10/31 14:20
 * @des
 */
@RestController
@RequestMapping("/cat")
public class CatController {

    @PersistenceContext(type= PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @RequestMapping("/get1")
    public List<CatEntity> get1(){

        String hql = " FROM CatEntity";
        Query query = em.createQuery(hql);
        List<CatEntity> tmplist = query.getResultList();

        return tmplist;
    }

    @RequestMapping("/get2")
    public List<CatEntity> get2(){

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CatEntity.class);
        detachedCriteria.add(Restrictions.eq("catId",1L));
        Criteria criteria = detachedCriteria.getExecutableCriteria(em.unwrap(Session.class));
        criteria.setCacheable(true);
        List<CatEntity> tmplist = criteria.list();
        return tmplist;
    }

    @RequestMapping("/get3")
    public List<CatEntity> get3(){
        SessionFactory sf =
                new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        String sql = "select * FROM Cat ";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(CatEntity.class);
        List<CatEntity> tmplist = sqlQuery.list();

        return tmplist;
    }

    @RequestMapping("/get4")
    public void get4(){
        Vector v=new Vector(10);
        while (true) {
            Object o = new Object();
            v.add(o);
        }
    }
    public String getStr(){
        return getStr();
    }
}

package com.codegym.repository.implement;

import com.codegym.models.Blog;
import com.codegym.repository.BlogRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "My_Blog")
@Transactional
public class BlogRepository implements BlogRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Blog> getAllBlog() {
        TypedQuery<Blog> typedQuery = entityManager.createQuery(
                "select b from Blog b", Blog.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public Blog getByIdBlog(Integer id) {
        Blog blog = entityManager.find(Blog.class, id);
        return blog;
    }

    @Override
    public void deleteBlog(Integer id) {
        Blog blog = getByIdBlog(id);
        entityManager.remove(blog);
    }

    @Override
    public void editBlog(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void addBlog(Blog blog) {
         entityManager.persist(blog);
    }
}

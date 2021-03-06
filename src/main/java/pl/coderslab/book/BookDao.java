package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Book> findAll() {
        return entityManager
                .createQuery("SELECT b from Book b")
                .getResultList();
    }

    public List<Book> findByPublisherId(long publisherId) {
        return entityManager
                .createQuery("SELECT b from Book b where b.publisher.id=:publiherId", Book.class)
                .setParameter("publiherId", publisherId)
                .getResultList();
    }


    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

}

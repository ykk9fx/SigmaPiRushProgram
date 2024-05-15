import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import java.util.List;
import org.hibernate.query.Query;

public class FirstRoundDriver extends DatabaseDriver{
    public FirstRoundDriver(){}

    public void pushToSecondRound(FirstRound fr){
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            SecondRound sr = new SecondRound(fr.getName(), fr.getPhoneNumber(), fr.getDorm(), fr.getPhoto());
            session.persist(sr);
            transaction.commit();
        } catch (ConstraintViolationException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<FirstRound> getFirstRoundList(){
        Transaction transaction = null;
        Session session = null;
        List<FirstRound> firstRoundList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query<FirstRound> query = session.createQuery("FROM FirstRound ", FirstRound.class);
            firstRoundList = query.getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return firstRoundList;
    }
}

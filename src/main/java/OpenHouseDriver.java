import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import java.util.List;
import org.hibernate.query.Query;

public class OpenHouseDriver extends DatabaseDriver {
    public OpenHouseDriver() {
    }

    public void addOpenHouse(String fn, String ln, String number, String dorm, Photo photo) throws Exception {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            OpenHouse oh = new OpenHouse(fn, ln, number, dorm, photo);
            session.persist(oh);
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
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void pushToFirstRound(OpenHouse oh) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            FirstRound fr = new FirstRound(oh.getName(), oh.getPhoneNumber(), oh.getDorm(), oh.getPhoto());
            session.persist(fr);
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

    public List<OpenHouse> getOpenHouseList() {
        Transaction transaction = null;
        Session session = null;
        List<OpenHouse> openHouseList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query<OpenHouse> query = session.createQuery("FROM OpenHouse", OpenHouse.class);
            openHouseList = query.getResultList();
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
        return openHouseList;
    }
}

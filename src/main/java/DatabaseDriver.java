import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.schema.spi.SchemaManagementException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
public class DatabaseDriver {
    public DatabaseDriver() {
    }

    public void createTables() throws Exception {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(standardRegistry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.createNativeQuery("select 1").uniqueResult();
                transaction.commit();
            } catch (SchemaManagementException e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw new Exception("Error creating tables: " + e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }
    }
}
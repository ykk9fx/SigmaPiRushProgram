import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.schema.spi.SchemaManagementException;


public class DatabaseDriver {
    public DatabaseDriver(){
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

    public void dropTables() throws Exception {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(standardRegistry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                session.createNativeQuery("DROP TABLE IF EXISTS OPENHOUSE").executeUpdate();
                session.createNativeQuery("DROP TABLE IF EXISTS FIRSTROUND").executeUpdate();
                session.createNativeQuery("DROP TABLE IF EXISTS SECONDROUND").executeUpdate();
                session.createNativeQuery("DROP TABLE IF EXISTS THIRDROUND").executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw new Exception("Error dropping tables: " + e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }
    }
}
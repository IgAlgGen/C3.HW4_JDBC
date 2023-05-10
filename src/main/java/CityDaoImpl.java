import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public void addCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> getAllCity() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM City").list();
        }
    }


    @Override
    public void updateCity(int id, City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            city.setCity_id(id);
            session.update(city);
            transaction.commit();
        }

    }

    @Override
    public void deleteCity(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(session.find(City.class,id));
            transaction.commit();
        }
    }
}

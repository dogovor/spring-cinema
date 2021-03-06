package cinema.spring.dao.impl;

import java.util.Optional;

import cinema.spring.dao.AbstractDao;
import cinema.spring.dao.RoleDao;
import cinema.spring.exception.DataProcessingException;
import cinema.spring.model.Role;
import cinema.spring.model.RoleName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Role> findByName = session.createQuery(
                        "FROM Role WHERE name = :name", Role.class);
            findByName.setParameter("name", RoleName.valueOf(name));
            return findByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + name + " not found", e);
        }
    }
}

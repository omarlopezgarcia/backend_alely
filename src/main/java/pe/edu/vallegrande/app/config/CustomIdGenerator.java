package pe.edu.vallegrande.app.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String prefix = "P";
        String uniqueId = prefix + UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        return uniqueId;
    }

}

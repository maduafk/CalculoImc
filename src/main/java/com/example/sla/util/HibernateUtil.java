package com.example.sla.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HibernateUtil {
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("jpa_ProvaN2", loadDatabaseProperties());
        }
        return emf.createEntityManager();
    }

    private static Map<String, String> loadDatabaseProperties() {
        Properties file = new Properties();
        try (InputStream in = HibernateUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (in == null) {
                throw new IllegalStateException(
                        "Arquivo db.properties não encontrado. Copie src/main/resources/db.properties.example para src/main/resources/db.properties e preencha a senha local."
                );
            }
            file.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler db.properties", e);
        }

        Map<String, String> props = new HashMap<>();
        props.put("javax.persistence.jdbc.url", required(file, "db.url"));
        props.put("javax.persistence.jdbc.user", required(file, "db.user"));
        props.put("javax.persistence.jdbc.password", file.getProperty("db.password", ""));
        return props;
    }

    private static String required(Properties file, String key) {
        String value = file.getProperty(key, "").trim();
        if (value.isEmpty()) {
            throw new IllegalStateException("Propriedade obrigatória ausente em db.properties: " + key);
        }
        return value;
    }

    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}

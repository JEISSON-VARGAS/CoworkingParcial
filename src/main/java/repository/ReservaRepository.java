package repository;

import config.JPAUtil;
import jakarta.persistence.EntityManager;
import model.Reserva;

import java.util.List;

/**
 * Clase Repository para manejar operaciones CRUD de la entidad Reserva.
 * Esta clase abstrae el acceso a la base de datos usando JPA.
 */
public class ReservaRepository {
    /**
     * Guarda una nueva reserva en la base de datos.
     *
     * @param reserva Objeto Reserva a persistir
     */
    public void guardar(Reserva reserva) {

        // Obtener un EntityManager desde la utilidad de configuración JPA
        EntityManager em = JPAUtil.getEntityManager();

        try {
            // Inicia la transacción
            em.getTransaction().begin();

            // Persiste la reserva en la base de datos
            em.persist(reserva);

            // Confirma la transacción
            em.getTransaction().commit();

        } catch (Exception e) {
            // Si hay error, hace rollback de la transacción
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            // Cierra el EntityManager para liberar recursos
            em.close();
        }
    }

    /**
     * Lista todas las reservas existentes en la base de datos.
     *
     * @return Lista de objetos Reserva
     */
    public List<Reserva> listar() {

        // Obtener EntityManager
        EntityManager em = JPAUtil.getEntityManager();

        // Ejecutar consulta JPQL para traer todas las reservas
        List<Reserva> reservas =
                em.createQuery("SELECT r FROM Reserva r", Reserva.class)
                        .getResultList();

        // Cerrar EntityManager
        em.close();

        return reservas;
    }

    /**
     * Elimina una reserva por su ID.
     *
     * @param id ID de la reserva a eliminar
     */
    public void eliminar(Long id) {

        // Obtener EntityManager
        EntityManager em = JPAUtil.getEntityManager();

        try {
            // Inicia la transacción
            em.getTransaction().begin();

            // Busca la reserva por ID
            Reserva reserva = em.find(Reserva.class, id);

            // Si existe, la elimina
            if (reserva != null) {
                em.remove(reserva);
            }

            // Confirma la transacción
            em.getTransaction().commit();

        } catch (Exception e) {
            // Rollback en caso de error
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }
}

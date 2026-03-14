package repository;

import config.JPAUtil;
import jakarta.persistence.EntityManager;
import model.Reserva;

import java.util.List;

public class ReservaRepository {
    public void guardar(Reserva reserva) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(reserva);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public List<Reserva> listar() {

        EntityManager em = JPAUtil.getEntityManager();

        List<Reserva> reservas =
                em.createQuery("SELECT r FROM Reserva r", Reserva.class)
                        .getResultList();

        em.close();

        return reservas;
    }

    public void eliminar(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            Reserva reserva = em.find(Reserva.class, id);

            if (reserva != null) {
                em.remove(reserva);
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }
}

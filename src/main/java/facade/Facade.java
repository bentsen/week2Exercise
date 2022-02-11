package facade;

import entities.SemesterEntity;
import entities.StudentEntity;
import entities.TeacherEntity;
import entities.TeacherSemesterEntity;

import javax.persistence.*;
import java.util.List;

public class Facade
{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public List<StudentEntity> getAllStudents()
    {
        EntityManager em = emf.createEntityManager();

        TypedQuery<StudentEntity> tq = em.createQuery("SELECT s from StudentEntity s",StudentEntity.class);

        return tq.getResultList();
    }

    public List<StudentEntity>getStundentsWithName(String name)
    {
        EntityManager em = emf.createEntityManager();

        TypedQuery<StudentEntity> tq = em.createQuery("SELECT s from StudentEntity s WHERE s.firstname = :name",
                StudentEntity.class);

        tq.setParameter("name",name);

        return tq.getResultList();
    }

    public void addStudent(StudentEntity student)
    {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    public void assignToSemester(StudentEntity student)
    {
        SemesterEntity semesterEntity = new SemesterEntity();
        StudentEntity student1 = new StudentEntity();

    }

    public List<StudentEntity> FindStudentWithLastName(String lastName)
    {
        EntityManager em = emf.createEntityManager();

        try{
            TypedQuery<StudentEntity> tq = em.createQuery("SELECT s FROM StudentEntity s WHERE s.lastname = :lastName"
                    ,StudentEntity.class);
            tq.setParameter("lastName",lastName);
            return tq.getResultList();
        }
        finally {
            em.close();
        }
    }

    public void numberOfStudentsInSemester(SemesterEntity semester)
    {
        EntityManager em = emf.createEntityManager();


    }

    public void allStundentsInSemesters()
    {

    }

    public void mostActiveTeacher()
    {
        EntityManager em = emf.createEntityManager();

        TypedQuery<TeacherSemesterEntity> tq = em.createQuery("SELECT count(t) FROM TeacherSemesterEntity t GROUP BY t.teachersId ORDER BY t.teachersId DESC",TeacherSemesterEntity.class);
        tq.setMaxResults(1);

        System.out.println(tq.getSingleResult());
    }


    public static void main(String[] args)
    {
        Facade facade = new Facade();
        facade.mostActiveTeacher();
    }
}




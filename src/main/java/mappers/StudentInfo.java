package mappers;

import entities.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentInfo
{
    public String fullName;

    public long studenId;

    public String classNameThisSemester;

    public String classDescription;

    public StudentInfo(String firstname, String lastname)
    {
        this.fullName = firstname + " " + lastname;
    }

    public List<StudentInfo> listOfStudents()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        TypedQuery<StudentInfo> query = em.createQuery("SELECT NEW mappers.StudentInfo(s.firstname, s.lastname) FROM StudentEntity AS s",StudentInfo.class);
        List<StudentInfo> studentInfos = query.getResultList();

        return studentInfos;
    }

    public StudentInfo getStudenInfo(long id)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<StudentInfo> query = em.createQuery("SELECT NEW mappers.StudentInfo(S.firstname, s.lastname) FROM StudentEntity AS s WHERE s.id = :id",StudentInfo.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}

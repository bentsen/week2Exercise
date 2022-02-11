package entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TeacherSemesterEntityPK implements Serializable {
    private long teachingId;
    private long teachersId;

    @Column(name = "teaching_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(long teachingId) {
        this.teachingId = teachingId;
    }

    @Column(name = "teachers_ID")
    @Id
    public long getTeachersId() {
        return teachersId;
    }

    public void setTeachersId(long teachersId) {
        this.teachersId = teachersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherSemesterEntityPK that = (TeacherSemesterEntityPK) o;
        return teachingId == that.teachingId && teachersId == that.teachersId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teachingId, teachersId);
    }
}

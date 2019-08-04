package smf.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ttpdv {
    private int tdvId;
    private String tdvNum;
    private Timestamp tdvFechacreacion;

    @Id
    @Column(name = "tdv_id")
    public int getTdvId() {
        return tdvId;
    }

    public void setTdvId(int tdvId) {
        this.tdvId = tdvId;
    }

    @Basic
    @Column(name = "tdv_num")
    public String getTdvNum() {
        return tdvNum;
    }

    public void setTdvNum(String tdvNum) {
        this.tdvNum = tdvNum;
    }

    @Basic
    @Column(name = "tdv_fechacreacion")
    public Timestamp getTdvFechacreacion() {
        return tdvFechacreacion;
    }

    public void setTdvFechacreacion(Timestamp tdvFechacreacion) {
        this.tdvFechacreacion = tdvFechacreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ttpdv ttpdv = (Ttpdv) o;
        return tdvId == ttpdv.tdvId &&
                Objects.equals(tdvNum, ttpdv.tdvNum) &&
                Objects.equals(tdvFechacreacion, ttpdv.tdvFechacreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tdvId, tdvNum, tdvFechacreacion);
    }
}

package com.codeOfCritical.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deviations that = (Deviations) o;

        return id == that.id;
    }*/

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "DEMO_CONTACT")
@Entity(name = "demo$Contact")
public class Contact extends StandardEntity {
    private static final long serialVersionUID = 1125283329421437610L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "contact")
    protected Set<Phone> phones;

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Set<Phone> getPhones() {
        return phones;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
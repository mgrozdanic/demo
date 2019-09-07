package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aviocompanyadmin")
public class AvioCompanyAdmin extends User  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aviocompanyadminid", unique = true, nullable = false)
    private Long avioCompanyAdminId;

    @ManyToOne
    private AvioCompany emloyer;

    public AvioCompanyAdmin() {
    }

    public AvioCompany getEmloyer() {
        return emloyer;
    }

    public void setEmloyer(AvioCompany emloyer) {
        this.emloyer = emloyer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAvioCompanyAdminId() {
        return avioCompanyAdminId;
    }

    public void setAvioCompanyAdminId(Long avioCompanyAdminId) {
        this.avioCompanyAdminId = avioCompanyAdminId;
    }
}

package com.se.mycompany.homeware.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String parent_id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog_id")
    private List<Product> products;

    public Catalog() {
    }

    public Catalog(int id, String name, String parent_id) {
        super();
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int cate_id) {
        this.id = cate_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "Catalog [id=" + id + ", name=" + name + ", parent_id=" + parent_id + "]";
    }

}

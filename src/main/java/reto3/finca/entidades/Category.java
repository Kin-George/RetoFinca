package reto3.finca.entidades;

import java.util.List;
import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categorias")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false,length = 45)
    private String name;
    @Column(name="description", nullable= false, length = 250)
    private String description; 
    
    // Relacion finca-categoria
    @OneToMany //(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    //@JsonIgnoreProperties("category")
    private List<Farms> farms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Farms> getFarms() {
        return farms;
    }

    public void setFarms(List<Farms> farms) {
        this.farms = farms;
    }

    

    

    

    
}

    

    

    
    


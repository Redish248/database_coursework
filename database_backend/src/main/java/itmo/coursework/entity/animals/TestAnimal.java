package itmo.coursework.entity.animals;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Entity
@Document(collection = "test_animal")
public class TestAnimal {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Field(value = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestAnimal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
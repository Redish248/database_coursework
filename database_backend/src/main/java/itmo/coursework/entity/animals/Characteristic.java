package itmo.coursework.entity.animals;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Characteristic {

    @Field(value = "name")
    private String name;

    @Field(value = "description")
    private String description;
}

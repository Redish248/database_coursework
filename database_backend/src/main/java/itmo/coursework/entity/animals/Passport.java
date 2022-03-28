package itmo.coursework.entity.animals;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Passport {

    @Field(value = "number")
    private String number;

    @Field(value = "officialName")
    private String officialName;
}

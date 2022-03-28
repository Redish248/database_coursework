package itmo.coursework.entity.animals;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class AnimalTypeInfo {

    @Field(value = "typical_illnesses")
    private List<Characteristic> typicalIllnesses;

    @Field(value = "habits")
    private List<Characteristic> habits;

    @Field(value = "additional_info")
    private List<Characteristic> additionalInfo;

}

package itmo.coursework.entity.animals;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Document(collection = "mongo_animal")
public class MongoAnimal {
    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "animal_type")
    private String animalType;

    @Field(value = "gender")
    private String gender;

    @Field(value = "weight")
    private int weight;

    @Field(value = "age")
    private int age;

    @Field(value = "date_of_arrival")
    private Date dateOfArrival;

    @Field(value = "place_of_arrival")
    private String placeOfArrival;

    @Field(value = "photo")
    private byte[] photo;

    @Field(value = "fur_color")
    private String furColor;

    @Field(value = "eyes_color")
    private String eyesColor;

    @Field(value = "passport")
    private Passport passport;

    @Field(value = "new_owner")
    private Owner newOwner; // current =)

    @Field(value = "feed")
    private List<Feed> feed;

    @Field(value = "animal_type_info")
    private AnimalTypeInfo animalTypeInfo;

    @Field(value = "additional_characteristics")
    private List<Characteristic> additionalCharacteristics;

}
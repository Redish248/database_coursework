package itmo.coursework.entity.animals;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Owner {
    //FIXME: это для связи с таблицами статистик? для id для монги лучше новое поле muid
    @Field(value = "uid")
    private int uid;

    @Field(value = "full_name")
    private String fullName;

    @Field(value = "phone")
    private String phone;

    @Field(value = "email")
    private String email;

    @Field(value = "address")
    private String address;

}

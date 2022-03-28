package itmo.coursework.entity.animals;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Feed {
    //FIXME: это для связи с таблицами статистик? для id для монги лучше новое поле muid
    @Field(value = "uid")
    private int uid;

    @Field(value = "amount_in_gramm")
    private int amountInGramm;
}

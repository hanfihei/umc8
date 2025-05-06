package umc.spring.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFoodChoice is a Querydsl query type for FoodChoice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodChoice extends EntityPathBase<FoodChoice> {

    private static final long serialVersionUID = -1352827162L;

    public static final QFoodChoice foodChoice = new QFoodChoice("foodChoice");

    public final umc.spring.study.domain.common.QBaseEntity _super = new umc.spring.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath field = createString("field");

    public final StringPath foodName = createString("foodName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFoodChoice(String variable) {
        super(FoodChoice.class, forVariable(variable));
    }

    public QFoodChoice(Path<? extends FoodChoice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodChoice(PathMetadata metadata) {
        super(FoodChoice.class, metadata);
    }

}


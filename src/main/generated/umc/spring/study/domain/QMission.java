package umc.spring.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = 194754469L;

    public static final QMission mission = new QMission("mission");

    public final umc.spring.study.domain.common.QBaseEntity _super = new umc.spring.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<RegionMission, QRegionMission> regionMissionList = this.<RegionMission, QRegionMission>createList("regionMissionList", RegionMission.class, QRegionMission.class, PathInits.DIRECT2);

    public final StringPath text = createString("text");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.study.domain.mapping.UserMission, umc.spring.study.domain.mapping.QUserMission> userMissionList = this.<umc.spring.study.domain.mapping.UserMission, umc.spring.study.domain.mapping.QUserMission>createList("userMissionList", umc.spring.study.domain.mapping.UserMission.class, umc.spring.study.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public QMission(String variable) {
        super(Mission.class, forVariable(variable));
    }

    public QMission(Path<? extends Mission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMission(PathMetadata metadata) {
        super(Mission.class, metadata);
    }

}


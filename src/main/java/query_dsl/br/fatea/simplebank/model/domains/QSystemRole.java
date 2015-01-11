package br.fatea.simplebank.model.domains;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QSystemRole is a Querydsl query type for SystemRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemRole extends EntityPathBase<SystemRole> {

    private static final long serialVersionUID = 396253266;

    public static final QSystemRole systemRole = new QSystemRole("systemRole");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QSystemRole(String variable) {
        super(SystemRole.class, forVariable(variable));
    }

    public QSystemRole(Path<? extends SystemRole> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QSystemRole(PathMetadata<?> metadata) {
        super(SystemRole.class, metadata);
    }

}


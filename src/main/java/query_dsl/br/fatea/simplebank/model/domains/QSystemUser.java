package br.fatea.simplebank.model.domains;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QSystemUser is a Querydsl query type for SystemUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemUser extends EntityPathBase<SystemUser> {

    private static final long serialVersionUID = 396346279;

    public static final QSystemUser systemUser = new QSystemUser("systemUser");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final SetPath<SystemRole, QSystemRole> roles = this.<SystemRole, QSystemRole>createSet("roles", SystemRole.class, QSystemRole.class);

    public final StringPath username = createString("username");

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QSystemUser(String variable) {
        super(SystemUser.class, forVariable(variable));
    }

    public QSystemUser(Path<? extends SystemUser> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QSystemUser(PathMetadata<?> metadata) {
        super(SystemUser.class, metadata);
    }

}


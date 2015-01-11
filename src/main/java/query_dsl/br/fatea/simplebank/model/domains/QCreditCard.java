package br.fatea.simplebank.model.domains;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QCreditCard is a Querydsl query type for CreditCard
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCreditCard extends EntityPathBase<CreditCard> {

    private static final long serialVersionUID = -811395402;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QCreditCard creditCard = new QCreditCard("creditCard");

    public final NumberPath<Integer> code = createNumber("code", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath number = createString("number");

    public final StringPath ownerName = createString("ownerName");

    public final QValidationDate validationDate;

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QCreditCard(String variable) {
        this(CreditCard.class, forVariable(variable), INITS);
    }

    public QCreditCard(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCreditCard(PathMetadata<?> metadata, PathInits inits) {
        this(CreditCard.class, metadata, inits);
    }

    public QCreditCard(Class<? extends CreditCard> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.validationDate = inits.isInitialized("validationDate") ? new QValidationDate(forProperty("validationDate")) : null;
    }

}


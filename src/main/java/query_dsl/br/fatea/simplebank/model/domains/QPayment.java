package br.fatea.simplebank.model.domains;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = -668470247;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QPayment payment = new QPayment("payment");

    public final QCreditCard creditCard;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Calendar> registrationDate = createDateTime("registrationDate", java.util.Calendar.class);

    public final EnumPath<br.fatea.simplebank.soap.payment.v1.PaymentStatus> status = createEnum("status", br.fatea.simplebank.soap.payment.v1.PaymentStatus.class);

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPayment(PathMetadata<?> metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creditCard = inits.isInitialized("creditCard") ? new QCreditCard(forProperty("creditCard"), inits.get("creditCard")) : null;
    }

}


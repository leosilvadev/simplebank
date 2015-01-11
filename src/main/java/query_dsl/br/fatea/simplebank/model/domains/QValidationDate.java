package br.fatea.simplebank.model.domains;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QValidationDate is a Querydsl query type for ValidationDate
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QValidationDate extends BeanPath<ValidationDate> {

    private static final long serialVersionUID = 1335433812;

    public static final QValidationDate validationDate = new QValidationDate("validationDate");

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QValidationDate(String variable) {
        super(ValidationDate.class, forVariable(variable));
    }

    public QValidationDate(Path<? extends ValidationDate> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QValidationDate(PathMetadata<?> metadata) {
        super(ValidationDate.class, metadata);
    }

}


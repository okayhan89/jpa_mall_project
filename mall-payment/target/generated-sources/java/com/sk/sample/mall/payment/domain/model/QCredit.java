package com.sk.sample.mall.payment.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCredit is a Querydsl query type for Credit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCredit extends EntityPathBase<Credit> {

    private static final long serialVersionUID = -919331231L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCredit credit = new QCredit("credit");

    public final com.sk.sample.mall.shared.base.QAbstractEntity _super = new com.sk.sample.mall.shared.base.QAbstractEntity(this);

    public final QCreditCard creditCard;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> limitAmount = createNumber("limitAmount", Integer.class);

    public final NumberPath<Integer> usedAmount = createNumber("usedAmount", Integer.class);

    public QCredit(String variable) {
        this(Credit.class, forVariable(variable), INITS);
    }

    public QCredit(Path<? extends Credit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCredit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCredit(PathMetadata metadata, PathInits inits) {
        this(Credit.class, metadata, inits);
    }

    public QCredit(Class<? extends Credit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creditCard = inits.isInitialized("creditCard") ? new QCreditCard(forProperty("creditCard")) : null;
    }

}


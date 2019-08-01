package com.sk.sample.mall.payment.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = -249812066L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final com.sk.sample.mall.shared.base.QAbstractEntity _super = new com.sk.sample.mall.shared.base.QAbstractEntity(this);

    public final QCreditCard creditCard;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> purchasedAmount = createNumber("purchasedAmount", Integer.class);

    public final DateTimePath<java.util.Date> purchasedDate = createDateTime("purchasedDate", java.util.Date.class);

    public final BooleanPath successed = createBoolean("successed");

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creditCard = inits.isInitialized("creditCard") ? new QCreditCard(forProperty("creditCard")) : null;
    }

}


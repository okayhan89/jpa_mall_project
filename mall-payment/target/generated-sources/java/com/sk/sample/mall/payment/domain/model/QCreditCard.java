package com.sk.sample.mall.payment.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCreditCard is a Querydsl query type for CreditCard
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCreditCard extends BeanPath<CreditCard> {

    private static final long serialVersionUID = -1150552815L;

    public static final QCreditCard creditCard = new QCreditCard("creditCard");

    public final StringPath cardNumber = createString("cardNumber");

    public final StringPath validThru = createString("validThru");

    public QCreditCard(String variable) {
        super(CreditCard.class, forVariable(variable));
    }

    public QCreditCard(Path<? extends CreditCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCreditCard(PathMetadata metadata) {
        super(CreditCard.class, metadata);
    }

}


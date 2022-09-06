package com.springboot.userservice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWard is a Querydsl query type for Ward
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWard extends EntityPathBase<Ward> {

    private static final long serialVersionUID = 306291585L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWard ward = new QWard("ward");

    public final SetPath<Address, QAddress> addresses = this.<Address, QAddress>createSet("addresses", Address.class, QAddress.class, PathInits.DIRECT2);

    public final QDistrict district;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final SetPath<AppUser, QAppUser> users = this.<AppUser, QAppUser>createSet("users", AppUser.class, QAppUser.class, PathInits.DIRECT2);

    public QWard(String variable) {
        this(Ward.class, forVariable(variable), INITS);
    }

    public QWard(Path<? extends Ward> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWard(PathMetadata metadata, PathInits inits) {
        this(Ward.class, metadata, inits);
    }

    public QWard(Class<? extends Ward> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.district = inits.isInitialized("district") ? new QDistrict(forProperty("district"), inits.get("district")) : null;
    }

}


package com.hospitality.util;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(PrimaryKeyListener.class)
public class BaseEntity<T> extends AuditFields<T>{

}

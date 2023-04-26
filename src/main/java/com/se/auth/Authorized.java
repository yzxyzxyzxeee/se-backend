package com.se.auth;

import com.se.enums.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorized {
    Role[]  roles() default {
             Role.INVENTORY_MANAGER,  Role.GM};
    String message() default "";
}

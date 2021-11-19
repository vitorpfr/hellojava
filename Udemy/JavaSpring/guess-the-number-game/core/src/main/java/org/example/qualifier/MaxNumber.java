package org.example.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD}) // our annotation can be applied to fields, parameters or methods
@Retention(RetentionPolicy.RUNTIME) // our annotation is retained at runtime
@Qualifier // annotate custom annotations
public @interface MaxNumber {
}

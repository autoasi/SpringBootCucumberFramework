package com.autoasi.springselenium.app.annotation;

import java.lang.annotation.*;

@Page
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // Annotation will be available during runtime and not compile time
public @interface Window {
    String value() default ""; // this is aspect oriented programming dependency
}

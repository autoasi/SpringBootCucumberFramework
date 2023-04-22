package com.autoasi.springselenium.app.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Lazy
@Configuration
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // Annotation will be available during runtime and not compile time
public @interface LazyConfiguration {
}

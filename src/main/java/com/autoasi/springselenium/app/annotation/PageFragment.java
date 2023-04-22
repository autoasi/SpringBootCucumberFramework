package com.autoasi.springselenium.app.annotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Lazy
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Can also do @Scope("prototype")
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // Annotation will be available during runtime and not compile time
public @interface PageFragment {
}

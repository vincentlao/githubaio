package com.laoning.githubaio.di.module;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by laoning on 07/02/2018.
 */


@Documented
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
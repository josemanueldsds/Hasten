package com.josemanueldsds.pruebatecnicahasten.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * PerActivity
 *
 * @author JoseManuel
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}

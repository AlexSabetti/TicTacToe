package com.codingdojo.tictactoe.classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConfirmation {
	String message() default "Passwords do not match!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

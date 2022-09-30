package com.coderspace.todoapp.security;

public class SecurityConstants {
    public static final String SIGN_UP_URL = "/api/todoapp/register";
    public static final String LOGIN = "/api/todoapp/sign-in";
    public static final String SECRET = "Coderspace";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 gün
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}

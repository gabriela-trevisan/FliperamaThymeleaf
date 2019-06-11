package com.fliperamaestudio.fliperamaestudio.security;

public interface PasswordEncoder {
    String encode(CharSequence senha);
    boolean matches(CharSequence senha, String encodedPassword);
}

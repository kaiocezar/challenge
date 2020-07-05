package com.labs.challenge.exceptions;

public class UniqueEmailException extends RuntimeException{

    public UniqueEmailException(String email){
        super("Já existe um elemento cadastrado na base com o email: "+email);
    }

}

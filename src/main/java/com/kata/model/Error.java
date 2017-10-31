package com.kata.model;

public enum Error {

    WRONG_ACCOUNT_NUMBER("Ce numéro ne correspond à aucun compte."),
    WRONG_CHOICE("Nous avons pas compris votre choix"),
    WRONG_AMOUNT("Veuillez entrez un nombre valide"),
    UNSUFFICIENT_BALANCE("Votre solde est insuffisant pour effectuer cette opération"),
    NO_HISTORY("Vous n'avez pas encore effectué d'opération");

    private String errorMessage;

    Error(String errorMessage){
        this.errorMessage=errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}

package com.kata.model;

public enum Messages {

    FILL_ACCOUNT_NUMBER("Veuillez saisir votre numero de compte"),
    FILL_AMOUNT("Veuillez saisir le montant"),
    OPERATION_CHOICES("Si vous voulez effectuer un retrait avec ticket tapez 1\n" +
            "Si vous voulez effectuer un retrait sans ticket tapez 2\n" +
            "Si vous voulez effectuer un depot avec ticket tapez 3\n" +
            "Si vous voulez effectuer un depot sans ticket tapez 4\n" +
            "Si vous voulez voir l'historique de vos operations tapez 5"
    ),
    EXIT("L'operation a ete effectue avec succes, si vous voulez quitter tapez n si vous voulez continuer tapez o");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

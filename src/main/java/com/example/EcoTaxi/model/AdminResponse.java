package com.example.EcoTaxi.model;


//Mbron të dhënat sensitive (fjalëkalimin) nga ekspozimi tek klienti.
    public record AdminResponse(Long id, String firstName, String lastName, String email) {
}

package com.example.EcoTaxi.model;


//Krijon një kontratë të qartë dhe të fortë midis serverit dhe klientit.
public record LoginResponse(String token, AdminResponse admin) {

}
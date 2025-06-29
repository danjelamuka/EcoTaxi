package com.example.EcoTaxi.service;

import com.example.EcoTaxi.entity.Cars;
import com.example.EcoTaxi.entity.TaxiOffers;
import com.example.EcoTaxi.repository.TaxiOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxiOfferService {

    @Autowired
    private TaxiOffersRepository taxiOffersRepository;

    public List<TaxiOffers> getAllTaxiOffers(){
        return taxiOffersRepository.findAll();
    }

    public TaxiOffers saveTaxiOffers(TaxiOffers taxiOffers){
        return taxiOffersRepository.save(taxiOffers);
    }

    public void deleteTaxiOffers(Long id){
        taxiOffersRepository.deleteById(id);
    }

    public TaxiOffers updateOffers(Long id,TaxiOffers updatedOffers){
        Optional<TaxiOffers> existingTaxiOffers = taxiOffersRepository.findById(id);
        if(existingTaxiOffers.isPresent()){
            TaxiOffers taxiOffers = existingTaxiOffers.get();
            taxiOffers.setRoute(updatedOffers.getRoute());
            taxiOffers.setPrice(updatedOffers.getPrice());
            taxiOffers.setImageUrl(updatedOffers.getImageUrl());
            return taxiOffersRepository.save(taxiOffers);
        } else {
            return null;
        }
    }
}

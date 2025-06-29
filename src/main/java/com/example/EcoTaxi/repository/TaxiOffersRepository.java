package com.example.EcoTaxi.repository;

import com.example.EcoTaxi.entity.TaxiOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiOffersRepository extends JpaRepository<TaxiOffers, Long> {
}

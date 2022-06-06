package com.savin.repository;

import com.savin.model.Buying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyingRepository extends JpaRepository<Buying, Long> {
}

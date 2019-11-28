package com.loginext.programmingchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginext.programmingchallenge.model.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}

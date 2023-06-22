/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Repos;

import com.apptivate.OptIn.Entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author david
 */
public interface ClientDao extends JpaRepository<Client, Integer>, JpaSpecificationExecutor<Client> {

    @Query("SELECT c FROM Client c WHERE c.id =:id")
    @Override
    Client getOne(@Param("id") Integer id);
    Page<Client> findAllByDateDeletedIsNull(Pageable pageable);
    List<Client> findAllByCorrelatorIsNotNull();
    Client findFirstByCorrelator(String correlator);
    Client findCorrelatorById(Integer id);

}

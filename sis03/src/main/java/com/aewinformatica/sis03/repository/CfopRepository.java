package com.aewinformatica.sis03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aewinformatica.sis03.entity.Cfop;

@Repository
public interface CfopRepository extends JpaRepository<Cfop, Integer> {

}

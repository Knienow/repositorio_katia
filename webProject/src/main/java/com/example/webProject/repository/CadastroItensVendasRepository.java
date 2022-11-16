package com.example.webProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webProject.model.CadastroItensVendas;

@Repository
public interface CadastroItensVendasRepository extends JpaRepository<CadastroItensVendas, Integer>  {

}

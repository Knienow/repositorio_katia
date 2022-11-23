package com.example.frameworkMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.frameworkMvc.model.CadastroServicos;

@Repository
public interface CadastroServicosRepository  extends JpaRepository<CadastroServicos, Integer>{

}

package com.example.webProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webProject.model.CadastroPessoa;

@Repository
public interface CadastroPessoaRepository  extends JpaRepository<CadastroPessoa, Integer>{

}

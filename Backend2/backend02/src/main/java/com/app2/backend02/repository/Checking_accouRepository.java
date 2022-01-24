package com.app2.backend02.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app2.backend02.entity.Checking_accou;

@Repository("checking_accouRepository")
public interface Checking_accouRepository extends JpaRepository<Checking_accou, Serializable> {

}
package com.app2.backend02.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app2.backend02.entity.Saving_accou;

@Repository("saving_accouRepository")
public interface Saving_accouRepository extends JpaRepository <Saving_accou, Serializable> {

}

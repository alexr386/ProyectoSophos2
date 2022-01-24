package com.app2.backend02.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app2.backend02.entity.Rol;


@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Serializable> {

}

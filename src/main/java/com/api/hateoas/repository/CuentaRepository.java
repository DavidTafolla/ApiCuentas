package com.api.hateoas.repository;


import com.api.hateoas.model.Cuenta;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.client.support.InterceptingHttpAccessor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {

    @Query ("UPDATE Cuenta c SET c.monto = c.monto + :monto WHERE c.id = :id")
    @Modifying
    void actualizarMonto(float monto, Integer id);

}
package com.api.hateoas;

import com.api.hateoas.model.Cuenta;
import com.api.hateoas.repository.CuentaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.AutoConfigureDataCassandra;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuentaRepositoryTest {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Test
    void testAgregarCuentas(){
        Cuenta cuenta=new Cuenta(10,"100");
        Cuenta cuentaGuardada=cuentaRepository.save(cuenta);

        Assertions.assertThat(cuentaGuardada).isNotNull(); //Comprobamos que la cuenta no sea nula
        Assertions.assertThat(cuentaGuardada.getId()).isGreaterThan(0); //Comprobamos del ID de la cuenta guardada sea mayor que 0


    }

}

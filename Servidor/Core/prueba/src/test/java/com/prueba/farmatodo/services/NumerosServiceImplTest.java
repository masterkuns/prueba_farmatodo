package com.prueba.farmatodo.services;

//unit test junit 4 and mockito

import com.prueba.farmatodo.dto.RpaNumeroDto;
import com.prueba.farmatodo.dto.SumatoriaDto;
import com.prueba.farmatodo.services.impl.NumerosServiceImpl;
import com.sun.jdi.LongValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NumerosServiceImplTest {

    private NumerosServiceImpl numerosServiceImpl;

    @Before
    public void setUp() {
        //numeroservice tiene constructor privado
        numerosServiceImpl = new NumerosServiceImpl();
    }



    @Test
    public void testSumar() {
        SumatoriaDto sumatoriaDto = numerosServiceImpl.sumatoriaNumerosNaturales(numero());
        Assert.assertEquals(15, Long.parseLong(String.valueOf(sumatoriaDto.getResult())));
    }

    @Test
    public void testSumar2() {
        SumatoriaDto sumatoriaDto = numerosServiceImpl.sumatoriaNumerosNaturales(numero2());
        Assert.assertEquals(55, Long.parseLong(String.valueOf(sumatoriaDto.getResult())));
    }

    private RpaNumeroDto numero() {
        RpaNumeroDto rpaNumeroDto = new RpaNumeroDto();
        rpaNumeroDto.setNumero(5);
        return rpaNumeroDto;
    }

    private RpaNumeroDto numero2() {
        RpaNumeroDto rpaNumeroDto = new RpaNumeroDto();
        rpaNumeroDto.setNumero(10);
        return rpaNumeroDto;
    }

}


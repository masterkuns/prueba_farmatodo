package com.prueba.farmatodo.services.impl;

import com.prueba.farmatodo.dto.*;
import com.prueba.farmatodo.services.INumerosService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class NumerosServiceImpl implements INumerosService {


    private List<NumeroFelizDto> numeroFeliz;

    @Autowired
    public NumerosServiceImpl(List<NumeroFelizDto> numeroFeliz) {
        this.numeroFeliz = numeroFeliz;
    }

    public NumerosServiceImpl() {

    }


    public static int[] digitosNumero(int iNumero) {

        String x = Integer.toString(iNumero);
        int[] iNumeros = new int[x.length()];
        int iDigito = 0;

        while (iNumero > 0) {
            iNumeros[iDigito] = iNumero % 10;
            iNumero = iNumero / 10;
            iDigito++;
        }
        return iNumeros;
    }

    @Override
    public NFelicesDto consultarNumerosFelices(RpaListadoNumerosDto rpaListadoNumerosDto) {
        numeroFeliz.clear();
        NFelicesDto nFelicesDto = new NFelicesDto();

        try {
            for (Integer numero : rpaListadoNumerosDto.getNumeros()) {
                Set<Integer> iCalculados = new HashSet<Integer>();
                boolean bRepetido = false;
                int[] iNumeros = digitosNumero(numero);
                int iSuma = 0;

                while ((iSuma != 1) && !(bRepetido)) {
                    iSuma = 0;
                    for (int x = 0; x < iNumeros.length; x++)
                        iSuma += Math.pow(iNumeros[x], 2);
                    iNumeros = digitosNumero(iSuma);

                    if (iCalculados.contains(new Integer(iSuma)))
                        bRepetido = true;
                    else
                        iCalculados.add(new Integer(iSuma));
                }

                NumeroFelizDto numeroFelizDto = new NumeroFelizDto();
                numeroFelizDto.setNumber(numero);
                if (bRepetido) {
                    numeroFelizDto.setIsHappy(false);
                } else {
                    numeroFelizDto.setIsHappy(true);
                }
                numeroFeliz.add(numeroFelizDto);
            }
            nFelicesDto.setNumbers(numeroFeliz);

        } catch (Exception e) {
            log.error("Error al consultar los numeros felices", e);
        }

        return nFelicesDto;
    }

    @Override
    public SumatoriaDto sumatoriaNumerosNaturales(RpaNumeroDto rpaNumeroDto) {

        SumatoriaDto sumatoriaDto = new SumatoriaDto();

        try {
            int n = rpaNumeroDto.getNumero(), sum = 0, i = 1;
            while (i <= n) {
                sum = sum + i;
                i++;
            }
            sumatoriaDto.setResult(sum);
        } catch (Exception e) {
            log.error("Error al sumar los numeros naturales", e);
        }
        return sumatoriaDto;
    }
}



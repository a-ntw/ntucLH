
package com.logic;

import javax.ejb.Stateless;

@Stateless
public class ConversionSLSB implements ConversionSLSBLocal {
    @Override
    public double convert_C2K(double val) {
        return val + 273.15;
    }
    
    @Override
    public double convert_C2F(double val) {
        return (val * 1.8) + 32 ;
    }

    @Override
    public double convert_F2C(double fah) {
        return (fah - 32) * 5/9;
    }

    @Override
    public double convert_F2K(double fah) {
        return (fah - 32) * 5/9 + 273.15;
    }

    @Override
    public double convert_K2C(double kel) {
        return (kel - 273.15);
    }

    @Override
    public double convert_K2F(double kel) {
        return (kel -273.15) * 9/5 + 32;
    }
}

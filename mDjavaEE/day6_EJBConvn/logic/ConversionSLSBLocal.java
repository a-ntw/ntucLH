
package com.logic;

import javax.ejb.Local;

@Local
public interface ConversionSLSBLocal {

    public double convert_C2K(double val);

    public double convert_C2F(double val);

    public double convert_F2C(double fah);

    public double convert_F2K(double fah);

    public double convert_K2C(double kel);

    public double convert_K2F(double kel);
    
}

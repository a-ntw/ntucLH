
package com.logic;

import javax.ejb.Local;

/**
 *
 * @author antw
 */
@Local
public interface ConversionSLSBLocal {

    double convert_C2K(double val);

    double convert_C2F(double val);

    double convert_F2C(double fah);

    double convert_F2K(double fah);

    double convert_K2C(double kel);

    double convert_K2F(double kel);
}

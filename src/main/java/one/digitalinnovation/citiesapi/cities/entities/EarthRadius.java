package one.digitalinnovation.citiesapi.cities.entities;

import java.math.BigDecimal;

public enum EarthRadius {
    METERS("m", BigDecimal.valueOf(6378168)),
    KILOMETERS("km", BigDecimal.valueOf(6378.168)),
    MILES("mi", BigDecimal.valueOf(3958.747716));
  
    private final String unit;
    private final BigDecimal value;
  
    EarthRadius(final String unit, final BigDecimal value) {
      this.unit = unit;
      this.value = value;
    }
  
    public BigDecimal getValue() {
      return value;
    }
  
    public String getUnit() {
      return unit;
    }
}

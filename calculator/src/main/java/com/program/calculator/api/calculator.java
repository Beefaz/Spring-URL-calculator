package com.program.calculator.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;


// + %2B
// - %2D
// * %2A
// / %2F
@RestController
public class calculator {
    @RequestMapping(value = "/skaiciuoti")
    public String calulation(@RequestParam double sk1, double sk2, char zenklas) {
        //hashcode of space character is 32
        //Html changes + symbol into space symbol, so it is changed into hashCode instead.
        //BigDecimal lines fixes 0.1+0.2 wrong result error
        if (Character.hashCode(zenklas) == 32) {
            return "Rezultatas: " + BigDecimal.valueOf(sk1).add(BigDecimal.valueOf(sk2), MathContext.UNLIMITED);
        } else if (Character.valueOf('-').equals(zenklas)) {
            return "Rezultatas: " + BigDecimal.valueOf(sk1).subtract(BigDecimal.valueOf(sk2), MathContext.UNLIMITED);
        } else if (Character.valueOf('*').equals(zenklas)) {
            return "Rezultatas: " + BigDecimal.valueOf(sk1).multiply(BigDecimal.valueOf(sk2), MathContext.UNLIMITED);
        } else if (Character.valueOf('/').equals(zenklas)) {
            return "Rezultatas: " + BigDecimal.valueOf(sk1).divide(BigDecimal.valueOf(sk2), MathContext.UNLIMITED);
        }
        return "Kažką ne taip įvedei!!!"+
                "<BR><BR>Rašyk:"+
                "<BR><BR>http://localhost:8080/skaiciuoti?sk1=<b>X</b>&sk2=<b>Y</b>&zenklas=<b>Z</b>"+
                "<BR><BR><b>X</b>, <b>Y</b> - skaičiai"+
                "<BR><BR><b>Z</b> - norimas veiksmas (+, -, *, /)";
    }
}

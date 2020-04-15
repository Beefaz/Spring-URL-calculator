package com.program.calculator.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// + %2B
// - %2D
// * %2A
// / %2F
@RestController
public class calculator {
    @RequestMapping(value = "/skaiciuoti")
    public String calulation(@RequestParam double sk1, double sk2, char zenklas) {
        //(zenklas.hashCode()==32)
        if (Character.hashCode(zenklas) == 32) {
            return "Rezultatas: " + (sk1 + sk2);
        } else if (Character.valueOf('-').equals(zenklas)) {
            return "Rezultatas: " + (sk1 - sk2);
        } else if (Character.valueOf('*').equals(zenklas)) {
            return "Rezultatas: " + (sk1 * sk2);
        } else if (Character.valueOf('/').equals(zenklas)) {
            return "Rezultatas: " + (sk1 / sk2);
        }
        return "Kažką ne taip įvedei!!!"+
                "<BR><BR>Rašyk:"+
                "<BR><BR>http://localhost:8080/skaiciuoti?sk1=<b>X</b>&sk2=<b>Y</b>&zenklas=<b>Z</b>"+
                "<BR><BR><b>X</b>, <b>Y</b> - skaičiai"+
                "<BR><BR><b>Z</b> - norimas veiksmas (+, -, *, /)";
    }
}

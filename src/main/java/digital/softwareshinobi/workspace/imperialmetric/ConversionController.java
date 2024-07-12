package digital.softwareshinobi.workspace.imperialmetric;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conversions/imperialmetric")
public class ConversionController {

    @GetMapping("feet-inches-to-meter")
    public ConversionResponse convertToMeter(@RequestParam double value, @RequestParam boolean isFeetIn) {
        if (isFeetIn) {
            return new ConversionResponse(value * 0.3048, "meters");
        } else {
            return new ConversionResponse(value / 2.54, "meters");
        }
    }

    @GetMapping("/meter-to-ftin")
    public ConversionResponse convertToFtIn(@RequestParam double value) {
        double meters = value;
        double feet = meters / 0.3048;
        double inches = (feet - Math.floor(feet)) * 12;
        return new ConversionResponse(feet + " feet, " + inches + " inches", "");
    }

    // Similar methods for other conversions
    @GetMapping("/cups-to-ml")
    public ConversionResponse convertToMl(@RequestParam double value) {
        return new ConversionResponse(value * 236.59, "milliliters");
    }

    @GetMapping("/ml-to-cups")
    public ConversionResponse convertToCups(@RequestParam double value) {
        return new ConversionResponse(value / 236.59, "cups");
    }

    @GetMapping("/kg-to-lbs")
    public ConversionResponse convertToLbs(@RequestParam double value) {
        return new ConversionResponse(value * 2.2046, "pounds");
    }

    @GetMapping("/lbs-to-kg")
    public ConversionResponse convertToKg(@RequestParam double value) {
        return new ConversionResponse(value / 2.2046, "kilograms");
    }

    @GetMapping("c-f")
    public ConversionResponse convertToFahrenheit(@RequestParam double value) {
        return new ConversionResponse((value * 1.8) + 32, "Fahrenheit");
    }

    @GetMapping("/fahrenheit-to-celsius")
    public ConversionResponse convertToCelsius(@RequestParam double value) {
        return new ConversionResponse((value - 32) / 1.8, "Celsius");
    }
}

class ConversionResponse {

    private Object convertedValue;
    private Object unit;

    public ConversionResponse(String convertedValue, String unit) {
        this.convertedValue = convertedValue;
        this.unit = unit;
    }

    public ConversionResponse(double convertedValue, String unit) {
        this.convertedValue = convertedValue;
        this.unit = unit;
    }

    // Getters and setters (optional)
}

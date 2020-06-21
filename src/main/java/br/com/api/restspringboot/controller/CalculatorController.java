package br.com.api.restspringboot.controller;

import br.com.api.restspringboot.Math.SimpleOperationsMath;
import br.com.api.restspringboot.exception.UnsupportedMathOperationException;
import br.com.api.restspringboot.request.convert.NumberConvert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private NumberConvert numberConvert;
    private SimpleOperationsMath result = new SimpleOperationsMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!numberConvert.isNumeric(numberOne) || !numberConvert.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return  result.sum(numberConvert.convertToDouble(numberOne), numberConvert.convertToDouble(numberTwo));
        }


    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!numberConvert.isNumeric(numberOne) || !numberConvert.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return result.subtraction(numberConvert.convertToDouble(numberOne), numberConvert.convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!numberConvert.isNumeric(numberOne)|| !numberConvert.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return result.multiplication(numberConvert.convertToDouble(numberOne), numberConvert.convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!numberConvert.isNumeric(numberOne) || !numberConvert.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return result.division(numberConvert.convertToDouble(numberOne), numberConvert.convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!numberConvert.isNumeric(numberOne) || !numberConvert.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return  result.avg(numberConvert.convertToDouble(numberOne), numberConvert.convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!numberConvert.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return result.squareRoot(numberConvert.convertToDouble(number));
    }
}

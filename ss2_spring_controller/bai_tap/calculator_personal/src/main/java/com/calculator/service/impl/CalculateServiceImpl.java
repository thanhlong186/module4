package com.calculator.service.impl;

import com.calculator.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public double calculation(String number, double no1, double no2) {
        double result = 0;
        switch (number) {
            case "Addition (+)":
                result = no1 + no2;
                break;
            case "Subtraction (-)":
                result = no1 - no2;
                break;
            case "Multiplication (x)":
                result = no1 * no2;
                break;
            case "Division (/)":
                if (no2 != 0)
                    result = no1 / no2;
                else
                    throw new RuntimeException("Bạn không thể chia cho 0");
                break;
            default:
                break;
        }
            return  result;
    }
}

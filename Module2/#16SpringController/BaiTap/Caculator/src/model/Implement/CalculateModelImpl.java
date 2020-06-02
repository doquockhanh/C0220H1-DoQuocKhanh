package model.Implement;

import model.CalculateModel;
import org.springframework.stereotype.Service;

@Service
public class CalculateModelImpl implements CalculateModel {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public double div(int a, int b) {
        return a / b;
    }
}

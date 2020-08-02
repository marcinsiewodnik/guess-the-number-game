package com.marcinsi.implementation_layer;

import com.marcinsi.annotations.MaxNumber;
import com.marcinsi.annotations.MinNumber;
import com.marcinsi.interface_layer.NumberGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==

    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    // == constructors ==

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {

        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // == public methods ==

    @Override
    public int next() {

//        Code still to analyze!

        return random.nextInt(maxNumber + 1 - minNumber) + minNumber;
    }
}

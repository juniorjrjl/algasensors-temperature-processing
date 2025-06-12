package com.algaworks.algasensors.temperature.processing.common;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochGenerator;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class IdGenerator {

    private static final TimeBasedEpochGenerator timeBasedEpochGenerator =
            Generators.timeBasedEpochGenerator();

    public static UUID generateTimeBasedUUID(){
        return timeBasedEpochGenerator.generate();
    }

}

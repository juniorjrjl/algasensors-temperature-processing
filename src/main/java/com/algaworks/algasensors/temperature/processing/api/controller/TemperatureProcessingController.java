package com.algaworks.algasensors.temperature.processing.api.controller;

import com.algaworks.algasensors.temperature.processing.api.model.TemperatureLogResponse;
import com.algaworks.algasensors.temperature.processing.common.IdGenerator;
import io.hypersistence.tsid.TSID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures/data")
public class TemperatureProcessingController {

    @PostMapping(consumes = TEXT_PLAIN_VALUE)
    void data(@PathVariable final TSID sensorId, @RequestBody final String input){
        if (isNull(input) || input.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST);
        }
        double temperature;
        try {
            temperature = Double.parseDouble(input);
        }catch (NumberFormatException ex){
            throw new ResponseStatusException(BAD_REQUEST);
        }
        var response = new TemperatureLogResponse();
        response.setId(IdGenerator.generateTimeBasedUUID());
        response.setSensorId(sensorId);
        response.setValue(temperature);
        response.setRegisteredAt(OffsetDateTime.now());
        log.info(response.toString());
    }


}

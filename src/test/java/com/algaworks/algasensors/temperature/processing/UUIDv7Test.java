package com.algaworks.algasensors.temperature.processing;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static com.algaworks.algasensors.temperature.processing.common.IdGenerator.generateTimeBasedUUID;
import static com.algaworks.algasensors.temperature.processing.common.UUIDv7Util.extractOffsetDateTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import static org.assertj.core.api.Assertions.assertThat;

class UUIDv7Test {

    @Test
    void shouldGenerateUUIDv7(){
        var uuid1 = generateTimeBasedUUID();

        var uuidDatetime = extractOffsetDateTime(uuid1).truncatedTo(MINUTES);
        var current = OffsetDateTime.now().truncatedTo(MINUTES);

        assertThat(uuidDatetime).isEqualTo(current);
    }

}

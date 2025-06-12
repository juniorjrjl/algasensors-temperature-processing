package com.algaworks.algasensors.temperature.processing.common;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.OffsetDateTime;
import java.util.UUID;

import static java.time.Instant.ofEpochMilli;
import static java.time.ZoneId.systemDefault;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UUIDv7Util {

    public static OffsetDateTime extractOffsetDateTime(@NonNull final UUID uuid){
        var timestamp = uuid.getMostSignificantBits() >>> 16;
        return OffsetDateTime.ofInstant(ofEpochMilli(timestamp), systemDefault());
    }

}

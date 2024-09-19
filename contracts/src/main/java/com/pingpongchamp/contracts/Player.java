package com.pingpongchamp.contracts;

import java.time.LocalDate;

public record Player(long id, String name, LocalDate dateOfBirth) {
}

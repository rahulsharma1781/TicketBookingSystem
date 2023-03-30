package com.org.work.booking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MovieNotFoundException extends Exception{

    /**
     * The nonexistent movie's id
     */
    private Long mid;

}

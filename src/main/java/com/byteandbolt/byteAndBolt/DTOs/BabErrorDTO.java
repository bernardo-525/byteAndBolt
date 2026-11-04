package com.byteandbolt.byteAndBolt.DTOs;

import com.byteandbolt.byteAndBolt.exception.BabErrorMessage;

public record BabErrorDTO(BabErrorMessage code, String message) {

}

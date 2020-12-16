package com.noy.iot.websocket.model;

import lombok.Data;

@Data
public class OutputData {

    private double celsiusTemp;
    private double humidityTemp;
    private String time;

    public OutputData(final double celsiusTemp, final double humidityTemp, final String time) {

        this.celsiusTemp = celsiusTemp;
        this.humidityTemp = humidityTemp;
        this.time = time;
    }
}

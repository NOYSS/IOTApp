package com.noy.iot.websocket.model;

import lombok.Data;

@Data
public class OutputData {

    private String from;
    private String text;
    private String time;

    public OutputData(final String from, final String text, final String time) {

        this.from = from;
        this.text = text;
        this.time = time;
    }
}

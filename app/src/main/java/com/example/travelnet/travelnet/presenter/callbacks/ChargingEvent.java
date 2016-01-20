package com.example.travelnet.travelnet.presenter.callbacks;

/**
 * Created by cvazquez on 19/01/2016.
 */
public class ChargingEvent {
    private String data;

    public ChargingEvent(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }
}
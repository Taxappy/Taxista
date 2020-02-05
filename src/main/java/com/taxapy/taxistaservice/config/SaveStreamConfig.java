package com.taxapy.taxistaservice.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.taxapy.taxistaservice.stream.NotificationSaveStream;


@EnableBinding(NotificationSaveStream.class)
public class SaveStreamConfig {

}

package com.taxapy.taxistaservice.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.taxapy.taxistaservice.stream.NotificationDeleteStream;


@EnableBinding(NotificationDeleteStream.class)
public class DeleteStreamConfig {

}

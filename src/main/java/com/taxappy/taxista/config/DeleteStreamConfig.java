package com.taxappy.taxista.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.taxappy.taxista.stream.NotificationDeleteStream;


@EnableBinding(NotificationDeleteStream.class)
public class DeleteStreamConfig {

}

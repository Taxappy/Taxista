package com.taxappy.taxista.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.taxappy.taxista.stream.NotificationSaveStream;




@EnableBinding(NotificationSaveStream.class)
public class SaveStreamConfig {

}

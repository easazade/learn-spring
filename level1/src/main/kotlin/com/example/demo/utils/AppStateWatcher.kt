package com.example.demo.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.availability.AvailabilityChangeEvent
import org.springframework.boot.availability.ReadinessState
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationContext
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class AppStateWatcher(@Autowired val context: ApplicationContext) {

  @EventListener
  fun onReadyStateChange(event: ApplicationReadyEvent) {
    if(event.applicationContext == context) {
      println("###################### READY EVENT => $event")
    }else{
      println("###################### contexts does not match")
    }
  }

  @EventListener
  fun onAvailabilityStateChange(event: AvailabilityChangeEvent<ReadinessState>) {
    val state = event.state
//    ReadinessState.ACCEPTING_TRAFFIC
//    ReadinessState.REFUSING_TRAFFIC
    println("###################### AVAILABILITY EVENT => $state")
  }
}
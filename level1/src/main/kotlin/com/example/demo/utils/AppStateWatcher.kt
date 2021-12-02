package com.example.demo.utils

import org.springframework.boot.availability.AvailabilityChangeEvent
import org.springframework.boot.availability.ReadinessState
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class AppStateWatcher {

  @EventListener
  fun onReadyStateChange(event: ApplicationReadyEvent) {
    println("###################### READY EVENT => $event")
  }

  @EventListener
  fun onAvailabilityStateChange(event: AvailabilityChangeEvent<ReadinessState>) {
    val state = event.state
//    ReadinessState.ACCEPTING_TRAFFIC
//    ReadinessState.REFUSING_TRAFFIC
    println("###################### AVAILABILITY EVENT => $state")
  }
}
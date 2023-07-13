package com.example.kotlin
    class Phone(var isScreenLightOn: Boolean = false) {
        fun switchOn() {
            isScreenLightOn = true
            println("encendido")
        }

        fun switchOff() {
            isScreenLightOn = false
            println("apagado")
        }

        fun checkPhoneScreenLight() {
            val phoneScreenLight = if (isScreenLightOn) "on" else "off"
            println("The phone screen's light is $phoneScreenLight.")
        }
    }

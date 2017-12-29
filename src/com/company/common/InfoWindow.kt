package com.company.common

import javafx.scene.control.Alert

// This file is written in Kotlin language, just to show our skills

class InfoWindow {

    companion object {

        fun createWindow(title: String, text: String) {
            val alert = Alert(Alert.AlertType.INFORMATION)
            alert.title = title
            alert.headerText = ""
            alert.contentText = text
            alert.showAndWait()
        }
    }
}
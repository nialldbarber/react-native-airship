/* Copyright Urban Airship and Contributors */

package com.urbanairship.reactnative.events

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReadableMap
import com.urbanairship.reactnative.Event

/**
 * Registration event.
 *
 * @param channelId The channel ID.
 * @param registrationToken The registration token.
 */
class RegistrationEvent(private val channelId: String, private val registrationToken: String?) : Event {

    override val name = CHANNEL_REGISTRATION_EVENT

    override val body: ReadableMap = Arguments.createMap().apply {
        putString(CHANNEL_ID, channelId)
        registrationToken?.let {
            putString(REGISTRATION_TOKEN, it)
        }
    }

    override val isForeground = true

    companion object {
        private const val CHANNEL_REGISTRATION_EVENT = "com.urbanairship.registration"
        private const val CHANNEL_ID = "channelId"
        private const val REGISTRATION_TOKEN = "registrationToken"
    }
}
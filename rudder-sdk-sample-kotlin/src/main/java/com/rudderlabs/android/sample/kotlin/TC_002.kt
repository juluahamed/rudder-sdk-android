package com.rudderlabs.android.sample.kotlin

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.rudderlabs.android.sdk.core.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.NotNull

object TC_002{
    fun run(rudderClient: RudderClient, userId: String, screenName: String) {
        rudderClient.screen(screenName)
        rudderClient.track("some_test_event")
        rudderClient.screen(screenName)
        val traits: RudderTraits = RudderTraits()
            .putAddress(
                RudderTraits.Address()
                    .putCity("some_city")
                    .putCountry("some_country")
                    .putPostalCode("123456")
                    .putState("some_state")
                    .putStreet("some_street")
            )
            .put("userId", userId)
            .put("some_test_key", "some_test_value")

        rudderClient.identify(
            "some_user_id",
            traits,
            null
        )
        rudderClient.track("some_test_event")
        // rudderClient.reset()
        rudderClient.track("some_other_test_event")
    }
}

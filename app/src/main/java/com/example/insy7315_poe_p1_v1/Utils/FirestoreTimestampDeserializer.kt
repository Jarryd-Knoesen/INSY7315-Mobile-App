package com.example.insy7315_poe_p1_v1.Utils

import com.google.gson.*
import java.lang.reflect.Type
import java.util.*

// ChatGPT helped explain this class:
// - How to create a custom Gson deserializer
// - Why this is needed for Firestore timestamps
class FirestoreTimestampDeserializer : JsonDeserializer<Date> {

    override fun deserialize(
        json: JsonElement?,          // The JSON element from the API
        typeOfT: Type?,              // The expected type (Date)
        context: JsonDeserializationContext? // Gson context
    ): Date? {
        if (json == null || json.isJsonNull) {
            return null
        }

        return try {
            // Expecting Firestore timestamps to be objects containing "seconds" and "nanoseconds"
            val jsonObject = json.asJsonObject
            val secondsElement = jsonObject.get("seconds")
            val nanosElement = jsonObject.get("nanoseconds")

            if (secondsElement != null && !secondsElement.isJsonNull) {
                val seconds = secondsElement.asLong
                val nanos = nanosElement?.asLong ?: 0L

                // Convert Firestore timestamp to Java Date
                Date(seconds * 1000 + nanos / 1_000_000) // milliseconds
            } else {
                null
            }
        } catch (e: Exception) {
            null // Fail silently if deserialization fails
        }
    }
}

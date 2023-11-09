package org.alexcawl.memorize.ui

interface DAdapterItem {
    val diffId: Any
    val diffContent: Any

    fun onChangePayload(other: DAdapterItem): Payload = Payload.None

    interface Payload {
        object None : Payload
    }
}
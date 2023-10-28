package org.alexcawl.memorize.ui

interface DelegateAdapterItem {
    val id: Any
    val content: Any

    fun onPayloadChange(other: DelegateAdapterItem): Payload = Payload.None

    interface Payload {
        object None : Payload
    }
}
package org.alexcawl.memorize.ui

interface DelegateAdapterItem {
    val diffId: Any
    val diffContent: Any

    fun onChangePayload(other: DelegateAdapterItem): Payload = Payload.None

    interface Payload {
        object None : Payload
    }
}
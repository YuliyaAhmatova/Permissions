package com.example.permissions

class ContactModal(
    val name: String,
    val phone: String
) {
    companion object {
        var contacts = mutableListOf(
            ContactModal("Иван", "89123456789"),
            ContactModal("Петр", "89123456788"),
            ContactModal("Марина", "89123456787"),
            ContactModal("Екатерина", "89123456786"),
            ContactModal("Валения", "89123456785"),
        )
    }
}
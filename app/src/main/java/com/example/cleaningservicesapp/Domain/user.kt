package com.example.cleaningservicesapp.Domain
/*
fun processUserAction(user: User) {
    when (user) {
        is User.Client -> {
            // Aqui o Android Studio só te mostra as propriedades de Cliente!
            println("Cliente: ${user.favoriteAddresses}")
        }
        is User.Partner -> {
            // Aqui o Android Studio só te mostra as propriedades de Parceiro!
            println("Parceiro com nota: ${user.rating}")
        }
    }
}
*/



sealed class User {
    abstract val id: String
    abstract val name: String
    abstract val email: String

    // Se for Cliente, só tem parâmetros de cliente
    data class Client(
        override val id: String,
        override val name: String,
        override val email: String,
        val favoriteAddresses: List<String> // Exemplo: endereços salvos do cliente
    ) : User()

    // Se for Parceiro (faxineiro), só tem parâmetros de parceiro
    data class Partner(
        override val id: String,
        override val name: String,
        override val email: String,
        val rating: Double,             // Exemplo: nota média do prestador
        val verifiedDocuments: Boolean  // Exemplo: verificação de antecedentes
    ) : User()
}


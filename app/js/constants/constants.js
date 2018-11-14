angular.module("pokemonApp")
    .constant("constantes", {
        baseUrl: "http://localhost:8080/pokemon/rest",
        mensagemPokemonExcluidoSucesso: "Pokemon Excluido com sucesso!"
    });
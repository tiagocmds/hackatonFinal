angular.module("pokemonApp")
    .factory("treinadorService", treinadorService);

    treinadorService.$inject = ["pokemonService"];

    function treinadorService(pokemonService) {
        var _treinador = null;
        
        var _listaTreinadores = 
            [{id: 1, nome: "João da Silva", listaPokemons: angular.copy(pokemonService.listaPokemons)}];
        
        return {
            listaTreinadores: _listaTreinadores,
            treinador: _treinador
        };
    }
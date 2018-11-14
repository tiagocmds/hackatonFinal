angular.module("pokemonApp")
    .factory("treinadorService", treinadorService);

    treinadorService.$inject = ["pokemonService"];

    function treinadorService(pokemonService) {
        var _treinador = null;
        
        var _listaTreinadores = 
            [{id: 1, nome: "João da Silva", listaPokemons: angular.copy(pokemonService.listaPokemons)}];
        
        return {
            listaTreinadores: _listaTreinadores,
            treinador: _treinador,

            listar: function() {
                return $http.get(constantes.baseUrl + "/treinador");
            },
            cadastrar: function(pokemon) {
                return $http.post(constantes.baseUrl + "/treinador", treinador);
            },
            obter: function(id) {
                return $http.get(constantes.baseUrl + "/treinador/obter/" + id);
            },
            excluir: function(id) {
                return $http.delete(constantes.baseUrl + "/treinador", {
                    params: {
                        id: id
                    }
                });
            },
            alterar: function(pokemon) {
                return $http.put(constantes.baseUrl + "/treinador", treinador);
            }  
        };
    }
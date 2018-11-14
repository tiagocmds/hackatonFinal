angular.module("pokemonApp")
    .factory("pokemonService", pokemonService);

    pokemonService.$inject = ['$http', "constantes"];

    function pokemonService($http, constantes) {
        var _pokemon = null;
        var _listaTipos = [
            {codigo: 1, descricao: "Raio"},
            {codigo: 2, descricao: "Fogo"},
            {codigo: 3, descricao: "Água"}
        ];

        return {
            listaTipos: _listaTipos,
            pokemon: _pokemon,
            listar: function() {
                return $http.get(constantes.baseUrl + "/pokemon");
            },
            cadastrar: function(pokemon) {
                return $http.post(constantes.baseUrl + "/pokemon", pokemon);
            },
            obter: function(id) {
                return $http.get(constantes.baseUrl + "/pokemon/obter/" + id);
            },
            excluir: function(id) {
                return $http.delete(constantes.baseUrl + "/pokemon", {
                    params: {
                        id: id
                    }
                });
            },
            alterar: function(pokemon) {
                return $http.put(constantes.baseUrl + "/pokemon", pokemon);
            }
        };
    }
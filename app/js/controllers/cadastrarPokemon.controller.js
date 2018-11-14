        angular.module("pokemonApp")
        .controller("cadastrarPokemonController", cadastrarPokemonController);

        cadastrarPokemonController.$inject = ['$scope', "$rootScope", "$location", "pokemonService"];

        function cadastrarPokemonController($scope, $rootScope, $location, pokemonService) {
            $scope.service = pokemonService;
            $scope.pokemon = $scope.service.pokemon;
            
            $scope.inserir = function(pokemon) {
                if (pokemon.id) {
                    
                    $scope.service.alterar(pokemon)
                    .then(function(response) {
                        console.log(response.data);
                        
                    }, function(error) {
                        console.log(error);
                    });
                    
                } else {
                    $scope.service.cadastrar(pokemon)
                    .then(function(response) {
                        console.log(response.data);
                    }, function(error) {
                        console.log(error);
                    });
                }

                $scope.pokemon = {};
                $scope.service.pokemon = {};
                $location.path("/listar");
            };

        }
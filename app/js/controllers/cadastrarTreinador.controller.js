angular.module("pokemonApp")
        .controller("cadastrarTreinadorController", cadastrarTreinadorController);

        cadastrarTreinadorController.$inject = ['$scope', "$rootScope", "$location", "pokemonService", "treinadorService"];

        function cadastrarTreinadorController($scope, $rootScope, $location, pokemonService, treinadorService) {
            $scope.pokemonService = pokemonService;
            $scope.treinadorService = treinadorService;
            $scope.treinador = $scope.pokemonService.treinador;
    
            $scope.inserir = function(treinador){
                if (treinador.id) {
                    
                    $scope.service.alterar(treinador)
                    .then(function(response) {
                        console.log(response.data);
                        
                    }, function(error) {
                        console.log(error);
                    });
                    
                } else {
                    $scope.service.cadastrar(treinador)
                    .then(function(response) {
                        console.log(response.data);
                    }, function(error) {
                        console.log(error);
                    });
                }

                $scope.treinador = {};
                $scope.treinadorService.treinador = {};
                $location.path("/treinador/listar");
            };
        }
angular.module("pokemonApp")
        .controller("cadastrarTreinadorController", cadastrarTreinadorController);

        cadastrarTreinadorController.$inject = ['$scope', "$rootScope", "$location", "pokemonService", "treinadorService"];

        function cadastrarTreinadorController($scope, $rootScope, $location, pokemonService, treinadorService) {
            $scope.contadorId = 1;
            $scope.pokemonService = pokemonService;
            $scope.treinadorService = treinadorService;
            $scope.treinador = $scope.pokemonService.treinador;
    
            $scope.inserir = function(treinador){
                if (treinador.id) {
                    var treinadorAlterado = $scope.treinadorService.listaTreinadores
                        .filter(
                            function(treinadorItem) {
                                if (treinadorItem.id === treinador.id) {
                                    
                                    return treinadorItem;
                                    
                                }
                        });
                    
                    var index = $scope.treinadorService.listaTreinadores.indexOf(treinadorAlterado[0]);
                    $scope.treinador.treinadorService.splice(index, 1, treinador);
                
                } else {
                    
                    treinador.id = ++$scope.contadorId;
                    $scope.treinadorService.listaTreinadores.push(angular.copy(treinador));  
                          
                }
    
                $scope.treinador = {};
                $scope.treinadorService.treinador = {};
                $location.path("/treinador/listar");
            };
        }
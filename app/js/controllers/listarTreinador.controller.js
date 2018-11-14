angular.module("pokemonApp")
        .controller("listarTreinadorController", listarTreinadorController);

    listarTreinadorController.$inject = ['$scope', "$rootScope", "$location", "treinadorService"];

    function listarTreinadorController($scope, $rootScope, $location, treinadorService) {
        var self = this.
        self.treinadorService = treinadorService;


        self.irTelaCadastrar = function() {
            $location.path("/treinador/cadastrar");
        };

        self.editar = function(treinador) {
            self.treinadorService.treinador = treinador;
            self.irTelaCadastrar();
        };

        self.excluir = function(index) {
            self.treinadorService.listaTreinadores.splice(index, 1);
        };
        self.batalhar = function(){
            $location.path("/batalhar");
        };
    }
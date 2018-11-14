angular.module("pokemonApp")
        .controller("listarTreinadorController", listarTreinadorController);

    listarTreinadorController.$inject = ['$scope', "$rootScope", "$location", "treinadorService"];

    function listarTreinadorController($scope, $rootScope, $location, treinadorService) {
        var self = this.
        self.treinadorService = treinadorService;
        self.idSelecionado = null;

        self.irTelaCadastrar = function() {
            $location.path("/treinador/cadastrar");
        };

        self.editar = function(treinador) {
            self.treinadorService.treinador = treinador;
            self.irTelaCadastrar();
        };

        self.excluir = function(id) {
            self.treinadorService.excluir(id)
            .then(function(response) {
                console.log("Excluido com sucesso");
                self.listar();
            }, function(error) {
                console.log(error);
            });

            self.idSelecionado = null;
        };
        self.obter = function(id) {
            self.treinadorService.obter(id)
            .then(function(response) {
                self.treinador = response.data;
            }, function(error) {
                console.log(error);
            });
        };
        self.listar = function() {
            self.treinadorService.listar()
                .then(function(response) {
                    self.treinadorService = response.data;
                }, function(error) {
                    console.log("Retornou erro");
                });
        };
        self.batalhar = function(){
            $location.path("/batalhar");
        };
    }
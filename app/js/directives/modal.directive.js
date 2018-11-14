angular.module("pokemonApp")
    .directive("pokemonModal", pokemonModal);

    pokemonModal.$inject = [];

    function pokemonModal() {
        return {
            transclude: true,
            template: `
            <div id="{{idModal}}" class="modal" tabindex="-1" role="dialog">
            <div class="modal-dialog {{tamanho}}" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">{{tituloModal}}</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <ng-transclude></ng-transclude>
                </div>
                <div class="modal-footer">
                  <button type="button" ng-if="mostrarBotaoConfirmar" ng-click="confirmar()" class="btn btn-primary">Confirmar</button>
                  <button type="button" ng-if="mostrarBotaoCancelar" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                </div>
              </div>
            </div>
          </div>
          `,
          scope: {
                idModal: "@",
                tituloModal: "@",
                tamanho: "@",
                callbackConfirmar: "&",
                mostrarBotaoCancelar: "=?",
                mostrarBotaoConfirmar: "=?"
          },
          link: function($scope) {
            
            if (angular.isUndefined($scope.mostrarBotaoCancelar) || $scope.mostrarBotaoCancelar === "") {
                $scope.mostrarBotaoCancelar = true;
            }

            if (angular.isUndefined($scope.mostrarBotaoConfirmar) || $scope.mostrarBotaoConfirmar === "") {
                $scope.mostrarBotaoConfirmar = true;
            }

            $scope.confirmar = function() {
                $scope.callbackConfirmar();
                $("#"+ $scope.idModal).modal("hide");
            };

          }
        };
    }
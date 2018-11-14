angular.module("pokemonApp", ["ngRoute"])
    .config(config)
    .run(run);

run.$inject = ["$rootScope", "$location"];
config.$inject = ["$routeProvider"];

function config($routeProvider) {
    $routeProvider.
    when("/login", {
        templateUrl: "./app/pages/login/login.html"
    }).
    when("/pokemon/listar", {
        templateUrl: "./app/pages/pokemon/listar.html"
    }).
    when("/pokemon/cadastrar", {
        templateUrl: "./app/pages/pokemon/cadastrar.html",
        controller: "cadastrarPokemonController as vm"
    }).
    when("/treinador/listar", {
        templateUrl: "./app/pages/treinador/listar.html"
    }).
    when("/treinador/cadastrar", {
        templateUrl: "./app/pages/treinador/cadastrar.html"
    }).
    when("/home", {
        templateUrl: "./app/pages/home.html"
    }).
    when("/batalhar", {
        templateURL: "./app/pages/batalhar.html"
    })
    .otherwise({
        redirectTo: "/login"
    }); 

}

function run($rootScope, $location) {
    /*$rootScope.$on("$routeChangeStart", function(evt, route) {
        if (route.originalPath !== "/login") {
            if (!$rootScope.usuario) {
                $location.path("/login");
            }
        }
    });*/
}
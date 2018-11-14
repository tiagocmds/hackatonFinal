module.exports = function(grunt) {
    var nodeModules = "node_modules/";
    
    grunt.initConfig({
        
        uglify: {
            dist: {
                src: ["app/js/**/*.js"],
                dest: "dist/js/build.min.js"
            }
        },
        cssmin: {
            dist: {
                src: ["app/css/**/*.css"],
                dest: "dist/css/style.min.css"
            }
        },
        htmlmin: {
            dist: {
                src: ["app/pages/**/*.html", "index.html"],
                dest:"dist",
                expand: true,
                options: {
                    removeComments: true,
                    collapseWhitespace: true
                }
            }
        },
        copy: {
            dist: {
                expand: true,
                src: [
                    nodeModules + "angular/angular.min.js",
                    nodeModules + "bootstrap/dist/css/bootstrap.min.css",
                    nodeModules + "bootstrap/dist/js/bootstrap.min.js",
                    nodeModules + "jquery/dist/jquery.min.js",
                    nodeModules + "popper.js/dist/popper.min.js",
                    nodeModules + "angular-route/angular-route.min.js"
                ],
                dest: "dist"
            },
            dev: {
                expand: true,
                src: [
                    nodeModules + "angular/angular.min.js",
                    nodeModules + "bootstrap/dist/css/bootstrap.min.css",
                    nodeModules + "bootstrap/dist/js/bootstrap.min.js",
                    nodeModules + "jquery/dist/jquery.min.js",
                    nodeModules + "popper.js/dist/popper.min.js",
                    nodeModules + "angular-route/angular-route.min.js",
                    "app/**",
                    "index.html"
                ],
                dest: "dist"
            },
            devWindows: {
                expand: true,
                src: [
                    nodeModules + "angular/angular.min.js",
                    nodeModules + "bootstrap/dist/css/bootstrap.min.css",
                    nodeModules + "bootstrap/dist/js/bootstrap.min.js",
                    nodeModules + "jquery/dist/jquery.min.js",
                    nodeModules + "popper.js/dist/popper.min.js",
                    nodeModules + "angular-route/angular-route.min.js",
                    "app/**",
                    "index.html"
                ],
                dest: "WebContent"
            }
        },
        clean: {
            dist: {
                src: ["dist"] 
            }
        },
        jshint: {
            options: {
                esversion: 6,
                bitwise: true,
                curly: true,
                asi: false
            },
            all: ["app/js/**/*.js", "!app/js/assets/popper.mim.js"]
        },
        connect: {
            server: {
                options: {
                    port: 8000,
                    base: "./dist"
                }
            }
        },
        watch: {
            dist: {
                files: ["app/**/*.js", "app/**/*.css", "app/**/*.html", "index.html"]
            },
            dev: {
                files: ["app/**/*.js", "app/**/*.css", "app/**/*.html", "index.html"],
                tasks: ["refresh"],
                options: {
                    spawn: false,
                    livereload: true
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-uglify-es');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-htmlmin');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.registerTask("default", ["jshint", "clean", "copy:devWindows", "connect", "watch:dev"]);
    grunt.registerTask("build", ["jshint", "clean", "uglify", "cssmin", "htmlmin", "copy:dist", "connect", "watch:dist"]);
    grunt.registerTask("refresh", ["jshint", "clean", "copy:devWindows"]);

}
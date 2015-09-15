module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    "babel": {
      options: {
        sourceMap: true
      },
      dist: {
        files: [{
          expand: true,
          cwd: 'src/',
          src: ['**/*.js'],
          dest: 'src/',  
        }]
      }
    }
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-babel');

  // Default task(s).
  grunt.registerTask('default', ['babel']);

};
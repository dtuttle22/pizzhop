require.config({
	shim: {
		underscore: {
			exports: '_'
		},
		backbone: {
			deps: [
				'underscore',
				'jquery'
			],
			exports: 'Backbone'
		}
	},
	paths: {
		jquery: 'lib/jquery-2.1.0.min',
		underscore: 'lib/underscore',
		backbone: 'lib/backbone',
		text: 'lib/require/text'
	}
});

require([
     	'backbone',
     	'views/app',
     	'jquery',
     	'routers/router'
     ], function (Backbone, AppView,$, Router) {
		
	    new Router();		
		Backbone.history.start();
		
		$('#header-nav a').click(function(event){
			event.preventDefault();
			var link = $(this);
			Backbone.history.navigate(link.attr("href"), true);
		});
     });

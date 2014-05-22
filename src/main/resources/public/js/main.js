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
     ], function (Backbone, AppView) {

		new AppView();
     });

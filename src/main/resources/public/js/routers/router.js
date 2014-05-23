define([
	'jquery',
	'backbone',
	'views/app',
	'views/ingredient/ingredientspage'
], function ($, Backbone, AppView,IngredientsPage) {
	'use strict';

	var MainRouter = Backbone.Router.extend({
		routes: {
			'ingredients': 'ingredientsView'
		},
		ingredientsView: function()
		{
			AppView.showView(IngredientsPage);
		}

	});

	return MainRouter;
});

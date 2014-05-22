define([
	'jquery',
	'underscore',
	'backbone',
	'collections/ingredients',
	'views/ingredientspage'
], function ($, _, Backbone, Ingredients, IngredientsPage) {
	'use strict';

	var AppView = Backbone.View.extend({

		el: '#container',

		initialize: function () {
			this.listenTo(Ingredients, 'reset', this.addAll);
			Ingredients.fetch({reset:true});
		},

		addAll: function () {
			var view = new IngredientsPage({collection: Ingredients})
			this.$el.append(view.render().el);
		}
	});

	return AppView;
});

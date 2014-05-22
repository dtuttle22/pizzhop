define([
	'jquery',
	'underscore',
	'backbone',
	'views/ingredientview',
	'text!templates/ingredients.html'
], function ($, _, Backbone, IngredientView, IngredientsTemplate) {
	'use strict';

	var IngredientsPage = Backbone.View.extend({

		tagName:  'div',

		template: _.template(IngredientsTemplate),

		initialize: function () {
		},

		render: function () {
			this.$el.html(this.template({size: this.collection.length}));
			this.collection.each(this.addOne, this)
			return this;
		},
		addOne: function (ingredient) {
			var view = new IngredientView({ model: ingredient });
			this.$('#content').append(view.render().el);
		}

	});

	return IngredientsPage;
});
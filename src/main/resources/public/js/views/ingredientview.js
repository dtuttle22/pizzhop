define([
	'jquery',
	'underscore',
	'backbone',
	'text!templates/ingredient.html'
], function ($, _, Backbone, IngredientTemplate) {
	'use strict';

	var IngredientView = Backbone.View.extend({

		tagName:  'div',

		template: _.template(IngredientTemplate),

		events: {
			'click .delete': 'clear'
		},
		
		initialize: function () {
			this.listenTo(this.model, 'change', this.render);
			this.listenTo(this.model, 'destroy', this.remove);
		},

		render: function () {
			this.$el.html(this.template(this.model.toJSON()));
			this.$el.addClass("ingredient");
			return this;
		},
		
		clear: function () {
			this.model.destroy();
		}		

	});

	return IngredientView;
});
define([
	'jquery',
	'underscore',
	'backbone',
	'views/ingredient/ingredientview',
	'text!templates/ingredients.html',
	'collections/ingredients'
], function ($, _, Backbone, IngredientView, IngredientsTemplate, Ingredients) {
	'use strict';

	var IngredientsPage = Backbone.View.extend({

		tagName:  'div',

		template: _.template(IngredientsTemplate),
		
		events: {
			'click #add-ingredient':'displayForm',
			'click #new-ingredient button': 'createIngredient'
		},
		initialize: function () {
			this.listenTo(this.collection, 'add', this.render);
			this.listenTo(this.collection, 'remove', this.render);
		},

		render: function () {
			this.$el.html(this.template({size: this.collection.length}));
			this.collection.each(this.addOne, this);
			this.$form = this.$('#new-ingredient');
			this.$input = this.$('#new-ingredient input');
			return this;
		},
		addOne: function (ingredient) {
			var view = new IngredientView({ model: ingredient });
			this.$('#content').append(view.render().el);
		},
		displayForm: function()
		{
			this.$form.show();
		},
		createIngredient: function(event)
		{	
			event.preventDefault();
			var ingredientName = this.$input.val();
			this.collection.create({name: ingredientName});
			this.$form.hide();
		}

	});

	return new IngredientsPage({collection:Ingredients});
});
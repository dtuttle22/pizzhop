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
			'click .delete': 'clear',
			'dblclick label': 'edit',
			'keydown .edit': 'processKey',
		},
		
		initialize: function () {
			this.listenTo(this.model, 'change', this.render);
			this.listenTo(this.model, 'destroy', this.remove);
		},

		render: function () {
			this.$el.html(this.template(this.model.toJSON()));
			this.$input= this.$('.edit');
			this.$el.addClass('ingredient');
			return this;
		},
		
		clear: function () {
			this.model.destroy();
		},
		edit: function()
		{
			this.$el.addClass('editing');
			this.$input.focus();
		},
		processKey: function (e) {
			//enter
			if (e.which === 13) {
				if (!this.$input.val())
					{
						alert("Name cannot be empty");
						return;
					}
				this.close();
			}
			//escape
			else if (e.which === 27)
			{
				this.$el.removeClass('editing');
				this.$input.val(this.model.get('name'));
			}
		},
		close: function () {
			var value = this.$input.val();
			var trimmedValue = value.trim();

			if (!this.$el.hasClass('editing')) {
				return;
			}

			if (trimmedValue) {
				this.model.save({ name: trimmedValue });

			}

			this.$el.removeClass('editing');
		}

	});

	return IngredientView;
});
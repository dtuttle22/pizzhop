define([
	'underscore',
	'backbone'
], function (_, Backbone) {
	'use strict';

	var Ingredient = Backbone.Model.extend({
		defaults: {
			name: ''
		}
	});

	return Ingredient;
});

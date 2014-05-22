/*global define*/
define([
	'underscore',
	'backbone',
	'models/ingredient'
], function (_, Backbone, Ingredient) {
	'use strict';

	var IngredientsCollection = Backbone.Collection.extend({
		model: Ingredient,
		url: '/ingredients',
			
		fetch: function()
		{
		    var collection = this;
		    $.ajax({
		        type : 'GET',
		        url : this.url,
		        dataType : 'json',
		        success : function(data) {
		            collection.reset(data.data)
		        }
		    });
		}

	});

	return new IngredientsCollection();
});

define([
	'jquery',
	'underscore',
	'backbone'
], function ($, _, Backbone) {
	'use strict';

	var AppView = Backbone.View.extend({

		el: '#container',
		
		showView: function(view){
			view.collection.fetch();
			this.$el.html('');
			this.$el.append(view.render().el);
		}
	});

	return new AppView();
});

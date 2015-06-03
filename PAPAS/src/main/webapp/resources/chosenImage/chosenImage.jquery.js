;;(function($) {

    $.fn.chosenImage = function(options) {

        return this.each(function() {

            var $select = $(this);
    		
            //Set cssText for chosen t process
    		$select.find('option').each(function () { 
    	      	var bg = $(this).css('background-image');
    	        bg = bg.replace('url(','').replace(')','');
    	        var myCssText = 'background-image: url(' + bg + ');'+'background-repeat: no-repeat;';
    	        $(this).css('cssText', myCssText);
    	      });

            // Execute chosen plugin
            $select.chosen(options);

            // Update (or create) div.chosen-container id
            var chosen_id = $select.attr('id').length ? $select.attr('id').replace(/[^\w]/g, '_') : this.generate_field_id();
            chosen_id += "_chosen";

            var  chosen      = '#' + chosen_id,            
                $chosen      = $(chosen).addClass('chosenImage-container');
            

            //Change image on chosen selected element when form changes
            $select.change(function() {
                var img = ($select.find('option:selected').css('background-image'));
                
                if (typeof img != "undefined") {
                	$chosen.find('.chosen-single span').css('background-image',img);
                	$chosen.find('.chosen-single span').css('background-repeat','no-repeat');
                } else {
                	$chosen.find('.chosen-single span').css('background-image','none');
                }
            });

            $select.trigger('change');
        });
    }

})(jQuery);

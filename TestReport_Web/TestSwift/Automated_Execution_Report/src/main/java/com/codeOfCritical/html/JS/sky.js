$('div.section').first();

      $('a.display').on('click', function(e) {
          e.preventDefault();

          if ($('.currentPanel').next('div.section').length > 0) {
              
              //if( $('.section').eq(-1).attr('id') == $('.currentPanel').attr('id') )
                //  var $next = $('.section').eq( 0 );
              //else
                  var $next = $('.currentPanel').next('.section');
                  
              var top = $next.offset().top;
              
              $('.currentPanel').removeClass('currentPanel');     
              $(function () {
                     $next.addClass('currentPanel');
                     $('html, body').animate({scrollTop: $('.currentPanel').offset().top }, 'slow');
                  
              });
        } else if ($('.currentPanel').prev('div.section').length > 0) {

              var $prev = $('.section').eq(0);
              var top = $prev.offset().top;
              
              $('.currentPanel').removeClass('currentPanel');
            
              $(function () {
                     $prev.addClass('currentPanel');
                     $('html, body').animate({scrollTop: $('.currentPanel').offset().top }, 'slow');
              });of
        } 
      });
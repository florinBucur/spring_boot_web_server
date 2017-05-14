(function($){
  $(function(){

    $('.button-collapse').sideNav();
    $('.carousel').carousel({fullWidth: true, indicators: true});
    $('.carousel').attr('height', '100vh');
    $('.scrollspy').scrollSpy({scrollOffset: 1});

    $(window).on('scroll', function (event) {
          var scroll = $(this).scrollTop()
          var dark = false;
          if(scroll > 100 && !dark) {
              $('#nav').removeClass('transparent-black-text')
              $('#nav').addClass('black-white-text')
              dark = true;
          } else {
              $('#nav').removeClass('black-white-text')
              $('#nav').addClass('transparent-black-text')
              dark = false;
          }
      });
  }); // end of document ready
})(jQuery); // end of jQuery name space

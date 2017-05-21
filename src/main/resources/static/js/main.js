(function($) {
  $(function() {
    var step = 0;

    $('.scrollspy').scrollSpy({
      scrollOffset: 1
    });

    $(window).on('resize load', function() {
      if (step == 0) {
        $(window).scrollTop($('#register-banner').offset().top);
      } else if (step == 1) {
        $(window).scrollTop($('#step1').offset().top);
      }
    });

    var type = "user";

    $('#partener').on('click', function() {
      type = "admin";
      $('#become').html("Become a partener");
      $('#location-elem').removeClass('hide');
      step = 1;
    });

    $('#client').on('click', function() {
      type = "user";
      $('#become').html("Become a client");
      $('#location-elem').addClass('hide');
      step = 1;
    });

    $('#register').on('submit', function(e) {
      e.preventDefault(); //prevent form from submitting
      if(type == "user") {
        $("#location").val(type + Date());
      }

      $.ajax({
        type: "POST",
        method: "POST",
        headers: {
          'Content-Type': 'application/json',
        },
        url: '/signup',
        data: JSON.stringify({
          "email": $("#email").val(),
          "password": $("#password").val(),
          "role": type,
	         "location": $("#location").val()
        }),

        success: function(result) {
          Materialize.toast('Account successfully created. Please wait...', 5000); // 3000 is the duration of the toast
          setTimeout(function() {
            window.location.replace(result.replace("\"", "").replace("\"", "") + "-home.html");
          }, 4000); //will call the function after 2 secs.
        },
        error: function(result) {
          Materialize.toast('Register failed.', 3000);
        },
        dataType: "json"
      });
    });
  }); // end of document ready
})(jQuery); // end of jQuery name space

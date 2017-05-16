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

    var type = 0;

    $('#partener').on('click', function() {
      type = "admin";
      $('#become').html("Become a partener");
      step = 1;
    });

    $('#client').on('click', function() {
      type = "user";
      $('#become').html("Become a client");
      step = 1;
    });

    $('#register').on('submit', function(e) {
      e.preventDefault(); //prevent form from submitting
      console.log({
        "email": $("#email").val(),
        "password": $("#password").val(),
        "role": type
      })
      $.ajax({
        type: "POST",
        method: "POST",
        headers: {
          'Content-Type': 'application/json'
        },
        url: 'https://192.168.0.113:8443/evconnect/signup',
        data: JSON.stringify({
          "email": $("#email").val(),
          "password": $("#password").val(),
          "role": type
        }),

        success: function(result) {
          console.log("daaa");
        },
        error: function(result) {
          console.log("ERR: " + result);
        },
        dataType: "json"
      });
    });
  }); // end of document ready
})(jQuery); // end of jQuery name space

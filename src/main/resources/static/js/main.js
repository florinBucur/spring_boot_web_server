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
          'Content-Type': 'application/json',
        },
        url: 'https://141.85.224.158:8443/evconnect/signup',
        data: JSON.stringify({
          "email": $("#email").val(),
          "password": $("#password").val(),
          "role": type,
	  "location":"UPB"
        }),

        success: function(result) {
          Materialize.toast('Account successfully created. Please wait...', 3000); // 3000 is the duration of the toast
          setTimeout(function() {
            window.location.replace(data.replace("\"", "").replace("\"", "") + "-home.html");
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

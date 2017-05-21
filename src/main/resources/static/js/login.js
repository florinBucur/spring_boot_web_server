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
    if (localStorage['xhayz'] != 0) {
      console.log(localStorage['xhayz']);
    }

    $('#login').on('submit', function(e) {
      e.preventDefault(); //prevent form from submitting
  
      localStorage['username'] = $("#username").val();
      $.ajax({
        type: "POST",
        method: "POST",
        headers: {
          'Content-Type': 'application/json',
        },
        url: '/login',
        data: JSON.stringify({
          "username": $("#username").val(),
          "password": $("#password").val(),
        }),

        success: function(data, textStatus, request) {
          localStorage['xhayz'] = request.getResponseHeader('Authorization').replace('Bearer ', '');
          $.ajax({
            type: "POST",
            method: "POST",
            headers: {
              'Content-Type': 'application/json',
            },
            url: '/logg',
            data: JSON.stringify({
              "email": localStorage['username']
            }),

            success: function(data, textStatus, request) {
              window.location.replace(data.replace("\"", "").replace("\"", "") + "-home.html");
            },

            error: function(result) {
              Materialize.toast('Wrong credentials.', 3000);
            },
          });
        },
      });
    });


    $.ajax({
      type: "GET",
      method: "GET",
      headers: {
        'Content-Type': 'application/json',
        'Authorization': localStorage['xhayz']
      },
      url: '/dummy',

      success: function(data, textStatus, request) {
        console.log(data);
      },
    });
  }); // end of document ready
})(jQuery); // end of jQuery name space

(function($) {
  $(function() {

    $(document).ready(function() {
      $('select').material_select();
    });
    var step = 0;

    if (localStorage['xhayz'] == 0) {
      window.location.replace("auth.html");
    } else {
      $('#firm_name').html(localStorage['username']);
    }

    jQuery.fn.insertAt = function(index, element) {
      var lastIndex = this.children().size();
      if (index < 0) {
        index = Math.max(0, lastIndex + 1 + index);
      }
      this.append(element);
      if (index < lastIndex) {
        this.children().eq(index).before(this.children().last());
      }
      return this;
    }

    var halls = 1;

    function add_location(name, surface, floor, available_hours, capacity) {
      var expl = $('.collapsible').children().first().clone();
      expl = expl.removeClass('hidden').attr("id", (halls++) + 'hall');
      expl.children().first().first().html(name);
      expl.find("#surface").val(surface);
      expl.find("#floor").val(floor);
      expl.find("#available_hours").val(available_hours);
      expl.find("#capacity").val(capacity);
      $('.collapsible').insertAt(1, expl);
      $('.collapsible').collapsible();
    }


      $.ajax({
        type: "GET",
        method: "GET",
        headers: {
          'Content-Type': 'application/json',
          'Authorization': localStorage['xhayz']
        },

        data: {
          "user": localStorage['username']
        },

        url: '/getRoomsByUser',

        success: function(data, textStatus, request) {
          for(i = 0; i < data.length; i++) {
            add_location(data[i]['name'], data[i]['surface'], data[i]['floor'], data[i]['availability'], data[i]['capacity'])
          }
        },
      });

    $('#add_room').on('submit', function(e) {
      e.preventDefault(); //prevent form from submitting

      $.ajax({
        type: "POST",
        method: "POST",
        headers: {
          'Content-Type': 'application/json',
          'Authorization': localStorage['xhayz']
        },

        data: JSON.stringify({
          "owner": localStorage['username'],
          "availability": $("#add_room #available_hours").val(),
          "capacity": $("#add_room #capacity").val(),
           "floor": $("#add_room #floor").val(),
           "name": $("#add_room #name").val(),
           "surface": $("#add_room #surface").val()
        }),

        url: '/createRoom',

        success: function(data, textStatus, request) {
          window.location.reload();
        },
      });
    });

  }); // end of document ready
})(jQuery); // end of jQuery name space

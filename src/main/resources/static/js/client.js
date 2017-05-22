(function($) {
  $(function() {

    $(document).ready(function() {
      $('select').material_select();
    });
    var step = 0;

    if (localStorage['xhayz'] == 0) {
      //window.location.replace("auth.html");
    } else {
      $('#firm_name').html(localStorage['username']);
    }

    var demoPicker = new Datepickk({
      container: document.querySelector('#calendar'),
      inline: true,
      range: false,
      maxSelections: 1
    });

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

      url: '/allLocations',

      success: function(data, textStatus, request) {
        $('#opt').insertAt(0, $('#opt').children().first().clone().html(data[0]['name']));
        $('#opt').children().last().remove();
        for(var i = 1; i < data.length; i++) {
          $('#opt').insertAt(0, $('#opt').children().first().clone().html(data[i]['name']));
        }
        $('select').material_select();
      },
    });

    $('#continue-form').on('submit', function (e) {
      e.preventDefault();

      $.ajax({
        type: "GET",
        method: "GET",
        headers: {
          'Content-Type': 'application/json',
          'Authorization': localStorage['xhayz']
        },

        data: {
          "location": $('.select-dropdown').val()
        },

        url: '/getRoomsByLocation',

        success: function(data, textStatus, request) {
          for(i = 0; i < data.length; i++) {
            add_location(data[i]['name'], data[i]['surface'], data[i]['floor'], data[i]['availability'], data[i]['capacity'])
            $(window).scrollTop($('#select_step2').offset().top);
          }
        },
      });
    })

  }); // end of document ready
})(jQuery); // end of jQuery name space

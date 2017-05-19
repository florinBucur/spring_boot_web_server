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

    add_location("EC101", 0, 0, 0, 0);
    add_location("EC102", 0, 0, 0, 0);

    function add_institution(name) {
      $('#opt').insertAt(0, $('#opt').children().first().clone().html(name));
      $('select').material_select();
    }

    add_institution(1)
    add_institution(2)
    // $.ajax({
    //   type: "GET",
    //   method: "GET",
    //   headers: {
    //     'Content-Type': 'application/json',
    //     'Authorization': localStorage['xhayz']
    //   },
    //   url: 'https://141.85.224.158:8443/evconnect/dummy',
    //
    //   success: function(data, textStatus, request) {
    //     console.log(data);
    //   },
    // });
  }); // end of document ready
})(jQuery); // end of jQuery name space

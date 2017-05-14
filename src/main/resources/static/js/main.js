(function($) {
  $(function() {
    $('.button-collapse').sideNav();
    $('.carousel').carousel({
      fullWidth: true,
      indicators: true
    });
    $('.carousel').attr('height', '100vh');
    $('.scrollspy').scrollSpy({
      scrollOffset: 1
    });



    $(window).on('scroll', function(event) {
      var scroll = $(this).scrollTop()
      var dark = false;
      if (scroll > 100 && !dark) {
        $('#nav').removeClass('transparent-black-text')
        $('#nav').addClass('black-white-text')
        dark = true;
      } else {
        $('#nav').removeClass('black-white-text')
        $('#nav').addClass('transparent-black-text')
        dark = false;
      }
    });



    var images_dom = [$('#big-image'), $('#img0'), $('#img1'), $('#img2'), $('#img3'), $('#img4')];

    var desc_dom = $('#description');
    var name_dom = $('#name');
    var ocupation_dom = $('#ocupation');

    var images = ['adriancoman.png', 'anamariamargeruseanu.png', 'andradaraducanu.png', 'florinbucur.png', 'andreimaracineanu.png', 'mihailupea.png'];
    var names = ['Adrian-Ioan Coman', 'Ana-Maria Margeruseanu', 'Andrada Maria-Magdalena Raducanu', 'Florin Bucur', 'Andrei Maracineanu', 'Mihai-Ionut Lupea'];
    var descriptions = ['Adrian is passionate in software, as a student in the third year at Computer Science. He has a lot experience in back-end development and every deadline in coding is converted in a great success for him and also for the teams in which Adrian enjoys to work. He has all the qualities to be our CTO.',
      'As a future Computer Engineer, Ana is very organised, she likes to speak in public and prefers to work in small software and hardware teams. A failure is not an obstacle for her, but an extra motivation to try harder on her way to succeed. That’s why she is the CEO of the team.',
      'Andrada, our bright mind, is a great graphic designer, being responsible with the image, logos and posters not just for us, but also for the entire Automatic and Computer Science. A free soul, having a large persective and overview of the product - we can count on Andrada.',
      'The oldest one in our team is Florin, a master student at/in… . Always serious, the man of the right sort of timber, with experinece in app development and lot of knowledge in software.',
      'Andrei has a great experience in app development. It was his dream that became true in a short period of time. Even though he is a cloistered person, we are sure that his great job will take us a step forward in defining our product.',
      'Event though Mihai is a freashman student at Computer Science, his work and knowledges can beat lots of other bigger students. He is a funny and sociable person, but when it comes to work is very focused and ambitious.'
    ];
    var roles = ['CTO - Backend Developer', 'CEO - Organizer', 'Designer', 'App Developer', 'App Developer', 'Front-end Developer'];
    var current = 0;

    function update_data(i) {
      desc_dom.html(descriptions[i]);
      name_dom.html(names[i]);
      ocupation_dom.html(roles[i]);

      for (var j = 0; j < 6; j++) {
        images_dom[j].attr('src', 'images/' + images[(i + j) % 6]).stop(true, true).hide().fadeIn(1000);
      }
    }

    function next_team_member() {
      current++;
      if (current == 6) {
        current = 0;
      }
    }

    function prev_team_member() {
      current--;
      if (current == -1) {
        current = 5;
      }
    }

    $('#team-next').on('click touch', function() {
      next_team_member();
      update_data(current);
    });

    $('#team-prev').on('click touch', function() {
      prev_team_member();
      update_data(current);
    });

    for (var j = 1; j < 6; j++) {

      images_dom[j].on('click touch', function() {
        id = $(this).attr('id').replace('img', '');
        for (var i = 0; i <= id; i++) {
          next_team_member();

        }
        update_data(current);
      });
    }
  }); // end of document ready
})(jQuery); // end of jQuery name space

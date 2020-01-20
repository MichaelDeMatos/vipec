// card js start
var emailbody = $(window).height();
$('.user-body').css('min-height', emailbody);
$(".card-header-right .icofont-close-circled").on('click', function() {
    var $this = $(this);
    $this.parents('.card').animate({
        'opacity': '0',
        '-webkit-transform': 'scale3d(.3, .3, .3)',
        'transform': 'scale3d(.3, .3, .3)'
    });

    setTimeout(function() {
        $this.parents('.card').remove();
    }, 800);
});
$("#styleSelector .style-cont").slimScroll({
    height: '100%',
    allowPageScroll: false,
    wheelStep: 5,
    color: '#999',
    animate: true
});
$(".card-header-right .icofont-rounded-down").on('click', function() {
    var $this = $(this);
    var port = $($this.parents('.card'));
    var card = $(port).children('.card-block').slideToggle();
    $(this).toggleClass("icon-up").fadeIn('slow');
});
$(".icofont-refresh").on('mouseenter mouseleave', function() {
    $(this).toggleClass("rotate-refresh").fadeIn('slow');
});
$("#more-details").on('click', function() {
    $(".more-details").slideToggle(500);
});
$(".mobile-options").on('click', function() {
    $(".navbar-container .nav-right").slideToggle('slow');
});
// card js end

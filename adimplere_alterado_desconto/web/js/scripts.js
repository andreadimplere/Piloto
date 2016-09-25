/*jslint plusplus: true*/
/*global jQuery, document, window, Waypoint, google, smoothScroll*/
/* ==========================================================================
Document Ready Function
========================================================================== */


jQuery(document).ready(function () {

    'use strict';

    var revapi,
        onMobile,
        parent_list,
        sticky_header,
        sticky_header_ON,
        owl_pagination,
        b_section,
        b_section_count,
        b_section_waypoint,
        breadceumb_parallax_ON,
        p_section,
        p_section_count,
        p_section_waypoint,
        section_parallax_ON,
        map_style,
        map_marker,
        google_map,
        map_Lat_lng,
        map_options,
        map_element,
        map_marker_image,
        option_attr,
        sort_by_value,
        filter_by_value,
        team_filter_by_value,
        progress_bar,
        progress_bar_count,
        progress_bar_block_waypoint,
        counter_box,
        counter_box_count,
        counter_box_waypoint;


    /* ==========================================================================
    Scroll To top
    ========================================================================== */
    jQuery('#to-top a').on('click', function () {
        jQuery('html, body').animate({scrollTop: '0'}, 800);
        return false;
    });

    
    
    /* ==========================================================================
    Placeholder
    ========================================================================== */
    jQuery('input, textarea').placeholder();

    if (jQuery('.btn-cart span.badge').length) {
        jQuery('.btn-cart span.badge').parents('li').addClass('morepad');
    }


    /* ==========================================================================
    Select Box
    ========================================================================== */
    jQuery('.search-select.select-input select').chosen({
        width: '100%',
        disable_search: false
    });
    jQuery('.select-input select').chosen({
        width: '100%',
        disable_search: true
    });


    /* ==========================================================================
    Input Number Counter
    ========================================================================== */
    jQuery('.product-count input[type=number]').each(function () {
        var el = jQuery(this);

        el.wrap('<span class="spinner"></span>');
        el.before('<span class="sub"><i class="fa fa-minus"></i></span>');
        el.after('<span class="add"><i class="fa fa-plus"></i></span>');

        el.parent().on('click', '.sub', function () {
            if (el.val() > 0) {
                el.val(function (i, oldval) {
                    oldval--;
                    return oldval;
                });
            }
        });

        el.parent().on('click', '.add', function () {
            if (el.val() < 9999999) {
                el.val(function (i, oldval) {
                    oldval++;
                    return oldval;
                });
            }
        });

    });


    /* ==========================================================================
    Social Icons
    ========================================================================== */
    jQuery('.social-icons.double-icons li a').each(function () {
        jQuery(this).find('i').clone().appendTo(this);
    });


    /* ==========================================================================
    Menu
    ========================================================================== */
    jQuery('ul.nav li ul').parent('li').addClass('parent-list');
    jQuery('.parent-list').find('a:first').append('<span class="menu-arrow"><i class="fa fa-angle-down"></i></span>');
    jQuery('li.mega-menu ul li').find('a').append('<span class="mega-menu-dash">-</span>');


    /* ==========================================================================
    Menu ( Open / Close on Small Sizes )
    ========================================================================== */
    jQuery('.parent-list').find('a:first').addClass('sub-menu-link');
    jQuery('.mega-menu .parent-list').find('a:first').removeClass('sub-menu-link');

    jQuery('li.parent-list a.sub-menu-link').on('click', function (e) {
        e.preventDefault();
        jQuery(this).parent().children('ul').toggleClass('show-sub-menu');
    });

    jQuery('li.mega-menu a.sub-menu-link').on('click', function (e) {
        e.preventDefault();
        jQuery(this).parent('li').find('ul ul').toggleClass('show-sub-menu');
    });


    if (jQuery('body').hasClass('home-one-page')) {
        jQuery('.header-menu a').on('click', function () {
            jQuery('.navbar-collapse').removeClass('in');
        });
    }


    /* ==========================================================================
    Sticky Header
    ========================================================================== */
    function stickyHeader() {

        var stickyElement = jQuery('.header-menu');

        if (stickyElement.length) {
            sticky_header = new Waypoint.Sticky({
                element: stickyElement[0],
                wrapper: '<div class="header-menu-wrapper" />'
            });
        }
        
        jQuery(window).scroll(function () {

            var current_position = jQuery(document).scrollTop();

            /* Tiny Header
            ------------------------------------------------- */
            if (current_position >= 300) {
                jQuery('.header').addClass('tiny-header');
            } else {
                jQuery('.header').removeClass('tiny-header');
            }

        });

    }
    sticky_header_ON = true; //Change it to false to disable the fixed header
    if (sticky_header_ON === true) {
        stickyHeader();
    }


    /* ==========================================================================
    Search Button
    ========================================================================== */
    jQuery('a.btn-search').on('click', function (e) {
        e.preventDefault();
        jQuery(this).toggleClass('btn-change');
        jQuery('.menu-search-form').toggleClass('show-form');
    });

    jQuery(document).keyup(function (e) {
        if (e.keyCode === 27) {
            jQuery('a.btn-search').removeClass('btn-change');
            jQuery('.menu-search-form').removeClass('show-form');
        }
    });


    /* ==========================================================================
    Cart Button
    ========================================================================== */
    jQuery('a.btn-cart').on('click', function (e) {
        e.preventDefault();
        jQuery(this).toggleClass('btn-change');
        jQuery('.cart-menu-wrapper').toggleClass('show-cart animated fadeInUp');
    });


    /* ==========================================================================
    Ship to Button
    ========================================================================== */
    jQuery('#ship_to').on('click', function () {
        jQuery('.shipping-form').toggleClass('show-shipping-form');
    });


    /* ==========================================================================
    OWL Slider
    ========================================================================== */
    jQuery('.owl-slider').owlCarousel({
        slideSpeed: 800,
        autoPlay: true,
        lazyLoad : true,
        singleItem: true,
        pagination: true,
        mouseDrag: false,
        navigation: true,
        stopOnHover: true,
        navigationText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>']
    });
    jQuery('.owl-slider .owl-pagination').each(function () {
        owl_pagination = jQuery(this).width() / -2;
        jQuery(this).css({marginLeft: owl_pagination});
    });


    /* ==========================================================================
    FitVid
    ========================================================================== */
    if (jQuery('.fitvid-iframe').length) {
        jQuery('.fitvid-iframe').fitVids();
    }


    /* ==========================================================================
    Twitter Feed
    ========================================================================== */
    jQuery('.tweetfeed .tweet').twittie({
        count: 2,
        username: 'nestolab',
        loadingText: 'Loading ...',
        dateFormat: '%b %d, %Y',
        apiPath: 'js/plugins/twitter/api/tweet.php',
        template: '<p><a href="http://twitter.com/{{user_name}}" title="{{user_name}}" target="_blank"><span class="twitter-username"><i class="fa fa-twitter"></i> @{{user_name}}</span></a> : {{tweet}}</p><a href="{{url}}" class="twitter-date" target="_blank">{{date}}</a>'
    });


    /* ==========================================================================
    Dribbble Feed
    ========================================================================== */
    if (jQuery('.widget-dribbble ul').length) {
        jQuery('.widget-dribbble ul').each(function () {
            jQuery.jribbble.getShotsByPlayerId('Dribbble', function (playerShots) {
                var htmld = [];
                jQuery.each(playerShots.shots, function (i, shot) {
                    htmld.push('<li><a href="' + shot.url + '" title="' + shot.title + '" target="_blank"><img src="' + shot.image_url + '" alt="' + shot.title + '"></a></li>');
                });
                jQuery('.widget-dribbble ul').html(htmld.join(''));
                jQuery('.widget-dribbble ul').owlCarousel({
                    autoPlay: true,
                    slideSpeed: 800,
                    lazyLoad : true,
                    singleItem: true,
                    navigation: true,
                    stopOnHover: true,
                    pagination: false,
                    navigationText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>']
                });

            }, {page: 1, per_page: 2});
        });
    }


    /* ==========================================================================
    Flickr Feed
    ========================================================================== */
    jQuery('ul.flickr-feed').jflickrfeed({
        limit: 8,
        qstrings: {
            id: '42260925@N04'
        },
        itemTemplate: '<li>' + '<a href="{{image_b}}" class="fancybox" data-fancybox-group="gall1" title="{{title}}"><img src="{{image_s}}" alt="{{title}}" /></a>' + '</li>'
    });


    /* ==========================================================================
    Fancybox
    ========================================================================== */
    jQuery('.fancybox').fancybox({
        helpers: {
            title: null,
            media: {},
            overlay: {
                speedOut: 0
            }
        }
    });


    /* ==========================================================================
    MailChimp
    ========================================================================== */
    function mailchimpCallback(response) {
        jQuery('form.newsletter-form .nesto-response').show();
        jQuery('form.newsletter-form .nesto-response').addClass('show-message');
        if (response.result === 'success') {
            jQuery('form.newsletter-form input').val('');
            jQuery('.nesto-response').html('Please check your e-mail to complete the subscription');
        } else if (response.result === 'error') {
            jQuery('.nesto-response').html('Please enter unsubscribed / valid e-mail address');
        }
    }
    jQuery('form.newsletter-form input').focus(function () {
        jQuery('form.newsletter-form .nesto-response').hide();
        jQuery('form.newsletter-form .nesto-response').removeClass('show-message');
    });
    jQuery('.newsletter-form').ajaxChimp({
        callback: mailchimpCallback,
        url: 'http://nestolab.us8.list-manage1.com/subscribe/post?u=1bb0930eeb3f8c90f187eb8ac&id=52e0f44deb'
    });


    /* ==========================================================================
    Disabled
    ========================================================================== */
    jQuery('.disabled').on('click', function (e) {
        e.preventDefault();
    });
    jQuery('input.disabled').prop('disabled', true);


    /* ==========================================================================
    Pricing Tables
    ========================================================================== */
    if (jQuery('.pricing-table-without-margin').length) {
        jQuery('.pricing-table-without-margin').closest('.row').addClass('no-margin');
    }


    /* ==========================================================================
    Map
    ========================================================================== */
    if (jQuery('.google-map').length) {

        map_Lat_lng = new google.maps.LatLng(47.605798, -122.325258);
        map_style = [
            {
                "featureType": "landscape",
                "stylers": [
                    {"saturation": -100},
                    {"lightness": 65},
                    {"visibility": "on"}
                ]
            }, {
                "featureType": "poi",
                "stylers": [
                    {"saturation": -100},
                    {"lightness": 51},
                    {"visibility": "simplified"}
                ]
            }, {
                "featureType": "road.highway",
                "stylers": [
                    {"saturation": -100},
                    {"visibility": "simplified"}
                ]
            }, {
                "featureType": "road.arterial",
                "stylers": [
                    {"saturation": -100},
                    {"lightness": 30},
                    {"visibility": "on"}
                ]
            }, {
                "featureType": "road.local",
                "stylers": [
                    {"saturation": -100},
                    {"lightness": 40},
                    {"visibility": "on"}
                ]
            }, {
                "featureType": "transit",
                "stylers": [
                    {"saturation": -100},
                    {"visibility": "simplified"}
                ]
            }, {
                "featureType": "administrative.province",
                "stylers": [
                    {"visibility": "off"}
                ]
            }, {
                "featureType": "water",
                "elementType": "labels",
                "stylers": [
                    {"visibility": "on"},
                    {"lightness": -25},
                    {"saturation": -100}
                ]
            }, {
                "featureType": "water",
                "elementType": "geometry",
                "stylers": [
                    {"hue": "#ffff00"},
                    {"lightness": -25},
                    {"saturation": -97}
                ]
            }
        ];

        if (jQuery('#gmap-style-1').length) {

            map_options = {
                zoom: 16,
                panControl: false,
                scrollwheel: false,
                mapTypeControl: true,
                center: map_Lat_lng
            };
            map_element = document.getElementById('gmap-style-1');
            google_map = new google.maps.Map(map_element, map_options);
            map_marker_image = 'images/marker.png';
            map_marker = new google.maps.Marker({
                position: map_Lat_lng,
                map: google_map,
                icon: map_marker_image
            });
            google_map.panBy(0, 0);
            google.maps.event.trigger(google_map, 'resize');

        } else if (jQuery('#gmap-style-2').length) {

            map_options = {
                zoom: 16,
                panControl: false,
                scrollwheel: false,
                mapTypeControl: true,
                center: map_Lat_lng,
                styles: map_style
            };
            map_element = document.getElementById('gmap-style-2');
            google_map = new google.maps.Map(map_element, map_options);
            map_marker_image = 'images/marker.png';
            map_marker = new google.maps.Marker({
                position: map_Lat_lng,
                map: google_map,
                icon: map_marker_image
            });
            google_map.panBy(0, 0);
            google.maps.event.trigger(google_map, 'resize');

        }

    }


    /* ==========================================================================
    Countdown Timer
    ========================================================================== */
    if (jQuery('#countdown-dashboard').length) {
        jQuery('#countdown-dashboard').countDown({
            targetDate: {
                'day': 17,
                'month': 12,
                'year': 2017,
                'hour': 0,
                'min': 0,
                'sec': 0
            },
            omitWeeks: true
        });
    }


    /* ==========================================================================
    Shop Sort
    ========================================================================== */
    jQuery('#sort-container select').on('change', function () {

        sort_by_value = jQuery(this).val();
        option_attr = jQuery('option:selected', this).attr('data-sort-by');

        if (option_attr === 'default-sort') {
            jQuery('body.shop-grid .shop-items-wrapper').isotope({
                sortBy: sort_by_value,
                sortAscending: true
            });
        } else if (option_attr === 'reverse-sort') {
            jQuery('body.shop-grid .shop-items-wrapper').isotope({
                sortBy: sort_by_value,
                sortAscending: false
            });
        } else {
            jQuery('body.shop-grid .shop-items-wrapper').isotope({
                sortBy: 'original-order',
                sortAscending: true
            });
        }

    });


    /* ==========================================================================
    Price Filter Slider
    ========================================================================== */
    jQuery('#price-filter-slider').ionRangeSlider({
        min: 0,
        max: 10000,
        prefix: '$',
        type: 'double'
    });


    /* ==========================================================================
    Portfolio Filter
    ========================================================================== */
    jQuery('#portfolio-filter-container select').on('change', function () {
        filter_by_value = jQuery('option:selected', this).attr('data-filter');
        jQuery('.portfolio-grid .portfolio-blocks-wrapper').isotope({
            filter: filter_by_value,
            animationOptions: {
                duration: 850,
                easing: 'linear',
                queue: false
            }
        });
    });


    /* ==========================================================================
    Portfolio Without Margin
    ========================================================================== */
    if (jQuery('.portfolio-item-without-margin').length) {
        jQuery('.portfolio-item-without-margin').closest('.row').addClass('row-portfolio-no-margin');
    }


    /* ==========================================================================
    Portfolio Wide With Margin
    ========================================================================== */
    if (jQuery('.portfolio-item-wide').length) {
        jQuery('.portfolio-item-wide').closest('.container').addClass('container-portfolio-wide');
    }


    /* ==========================================================================
    Portfolio Wide Without Margin
    ========================================================================== */
    if (jQuery('.portfolio-item-wide.portfolio-item-without-margin').length) {
        jQuery('.portfolio-item-wide.portfolio-item-without-margin').closest('.container').addClass('container-portfolio-wide-without-margin');
    }


    /* ==========================================================================
    Portfolio Timeline
    ========================================================================== */
    if (jQuery('body').hasClass('portfolio-timeline')) {
        jQuery('.main-content article.portfolio-block').closest('.row').addClass('row-portfolio-timeline');
    }


    /* ==========================================================================
    Team
    ========================================================================== */
    if (jQuery('.member-item.member-item-style-4').length) {
        jQuery('.member-item.member-item-style-4').closest('.row').addClass('row-member-item-wide');
    }


    /* ==========================================================================
    Team Filter
    ========================================================================== */
    jQuery('#team-filter-container select').on('change', function () {
        team_filter_by_value = jQuery('option:selected', this).attr('data-filter');
        jQuery('.team-blocks-wrapper').isotope({
            filter: team_filter_by_value,
            animationOptions: {
                duration: 850,
                easing: 'linear',
                queue: false
            }
        });
    });


    /* ==========================================================================
    Video Section
    ========================================================================== */
    jQuery(function () {
        jQuery('.YoutTubeplayer').YTPlayer();
    });


    /* ==========================================================================
    Service
    ========================================================================== */
    if (jQuery('.service-item-style-6').length) {
        jQuery('.service-item-style-6').parent().addClass('service-block-width');
    }


    /* ==========================================================================
    Progress Bar
    ========================================================================== */
    progress_bar = document.getElementsByClassName('progress-bar');
    function progressbarfn(progress_bar_index) {

        progress_bar_block_waypoint = new Waypoint({
            element: progress_bar[progress_bar_index],
            handler: function () {
                var progress_percent;
                progress_percent = jQuery(this.element).find('.progress-percent').html();
                jQuery(this.element).css({width: progress_percent});
            },
            offset: '100%'
        });

    }
    for (progress_bar_count = 0; progress_bar_count < progress_bar.length; progress_bar_count++) {
        progressbarfn(progress_bar_count);
    }


    /* ==========================================================================
    Revolution Slider
    ========================================================================== */
    revapi = jQuery('.tp-banner').revolution({
        delay: 9000,
        thumbAmount: 5,
        fullWidth: 'on',
        stopLoop: 'off',
        startwidth: 1170,
        startheight: 500,
        parallax: 'mouse',
        forceFullWidth: 'on',
        navigationType: 'none',
        hideCaptionAtLimit: 991,
        hideArrowsOnMobile: 'on',
        hideBulletsOnMobile: 'on',
        navigationStyle: 'preview1',
        parallaxLevels: [7, 4, 3, 2, 5, 4, 3, 2, 1, 0]
    });


    /* ==========================================================================
    Smooth Scroll
    ========================================================================== */
    if (sticky_header_ON === true) {
        smoothScroll.init({
            offset: 70, // Integer. How far to offset the scrolling anchor location in pixels
            speed: 800, // Integer. How fast to complete the scroll in milliseconds
            updateURL: false
        });
    } else {
        smoothScroll.init({
            offset: 0,
            speed: 800,
            updateURL: false
        });
    }


    /* ==========================================================================
    Data Spy
    ========================================================================== */
    jQuery('body').attr('data-spy', 'scroll').attr('data-target', '.header-menu').attr('data-offset', '71');


    /* ==========================================================================
    Background Image Slider
    ========================================================================== */
    if (jQuery('body.background-image-slider').length) {
        jQuery('body.background-image-slider #home-section').supersized({
            slide_interval: 5000, // Length between transitions
            transition: 1,
            transition_speed: 900, // Speed of transition
            slide_links: '0',
            slides: [
                {image: 'images/slider/background-slider/001.jpg', title : '', thumb : '', url : ''},
                {image: 'images/slider/background-slider/002.jpg', title : '', thumb : '', url : ''}
            ]
        });
    }
    function image_slider_scroll() {
        jQuery(window).scroll(function () {
            var current_position = jQuery(document).scrollTop();
            jQuery('body.background-image-slider #supersized li a img').css('top', current_position * -0.60);
        });
    }
    if (jQuery('body.background-image-slider').length) {
        image_slider_scroll();
    }


    /* ==========================================================================
    Parallax
    ========================================================================== */
    /* Breadcrumb Section
    -------------------------------------------------------------------------- */
    b_section = document.getElementsByClassName('breadcrumb-section');
    function bparallaxfn(b_index) {
        b_section_waypoint = new Waypoint({
            element: b_section[b_index],
            handler: function () {
                jQuery(this.element).parallax('50%', 0.5);
            },
            offset: '100%'
        });
    }
    /* Parallax Section
    -------------------------------------------------------------------------- */
    p_section = document.getElementsByClassName('parallax-section');
    function parallaxfn(p_index) {
        p_section_waypoint = new Waypoint({
            element: p_section[p_index],
            handler: function () {
                jQuery(this.element).parallax('50%', 0.5);
            },
            offset: '100%'
        });
    }


    /* ==========================================================================
    Counters
    ========================================================================== */
    counter_box = document.getElementsByClassName('counter-item');
    function counter_box_fn(counter_box_index) {
        counter_box_waypoint = new Waypoint({
            element: counter_box[counter_box_index],
            handler: function () {
                jQuery(this.element).find('[data-to]').countTo({speed: 3000});
                this.destroy();
            },
            offset: '75%'
        });
    }


    /* ==========================================================================
    on mobile ?
    ========================================================================== */
	onMobile = false;
    if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
        onMobile = true;
    }

    if (onMobile === true) {

        /* ==========================================================================
        Destroy Fancybox
        ========================================================================== */
        jQuery('.portfolio-item-overlayer .portfolio-item-header a').on('click', function (e) {
            e.preventDefault();
            jQuery(document).unbind('click.fb-start');
        });

        /* ==========================================================================
        Remove Parallax
        ========================================================================== */
        jQuery('.parallax-section').css({backgroundAttachment: 'scroll'});
        jQuery('.breadcrumb-section').css({backgroundAttachment: 'scroll'});
        jQuery('#home-section').css({backgroundAttachment: 'scroll'});

    } else {

        /* ==========================================================================
        Parallax
        ========================================================================== */
        /* Breadcrumb Section
        -------------------------------------------------------------------------- */
        breadceumb_parallax_ON = true; //Change it to false to disable the breadcrumb parallax effect
        if (breadceumb_parallax_ON === true) {
            for (b_section_count = 0; b_section_count < b_section.length; b_section_count++) {
                bparallaxfn(b_section_count);
            }
        }
        /* Parallax Section
        -------------------------------------------------------------------------- */
        section_parallax_ON = true; //Change it to false to disable the section parallax effect
        if (section_parallax_ON === true) {
            for (p_section_count = 0; p_section_count < p_section.length; p_section_count++) {
                parallaxfn(p_section_count);
            }
        }
        /* Home Section
        -------------------------------------------------------------------------- */
        jQuery('#home-section').parallax('50%', 0.5);

        /* ==========================================================================
        Menu
        ========================================================================== */
        parent_list = jQuery('li.parent-list');
        parent_list.on({
            'mouseover': function () {
                jQuery(this).find('ul:first').addClass('animated fadeInUp');
            },
            'mouseleave': function () {
                jQuery(this).find('ul:first').removeClass('animated fadeInUp');
            }
        });

        /* ==========================================================================
        Counters
        ========================================================================== */
        for (counter_box_count = 0; counter_box_count < counter_box.length; counter_box_count++) {
            counter_box_fn(counter_box_count);
            if (counter_box_count === counter_box.length) {
                counter_box_waypoint.destroy();
            }
        }

    }


}); // Document Ready




/* ==========================================================================
Window Scroll
========================================================================== */
jQuery(window).scroll(function () {

    'use strict';
    
    var current_position = jQuery(document).scrollTop();

    /* ==========================================================================
    To Top
    ========================================================================== */
    if (current_position >= 100) {
        jQuery('#to-top').addClass('topdisplay');
    } else {
        jQuery('#to-top').removeClass('topdisplay');
    }


}); // Window Scroll




/* ==========================================================================
Window Resize
========================================================================== */
jQuery(window).resize(function () {

    'use strict';


    /* ==============================================
    Refresh Data Spy
    =============================================== */
    jQuery('[data-spy="scroll"]').each(function () {
        var $spy = jQuery(this).scrollspy('refresh');
    });


    /* ==========================================================================
    Blog Timeline
    ========================================================================== */
    function blog_block_direction() {
        jQuery('body.blog-timeline article.blog-post').each(function () {
            var posLeft = jQuery(this).css('left');
            if (posLeft === '0px') {
                jQuery(this).addClass('left-post');
            } else {
                jQuery(this).addClass('right-post');
            }
        });
    }
    if (jQuery('body').hasClass('blog-timeline')) {
        jQuery('.blog-grid .blog-posts-wrapper').isotope('on', 'layoutComplete', function () {
            jQuery('body.blog-timeline article.blog-post').removeClass('left-post');
            jQuery('body.blog-timeline article.blog-post').removeClass('right-post');
            blog_block_direction();
        });
    }

});




/* ==========================================================================
Window Load
========================================================================== */
jQuery(window).load(function () {

    'use strict';

    var blog_grid,
        shop_grid,
        team_grid,
        portfolio_grid;


    /* ==========================================================================
    Loader
    ========================================================================== */
    function hideLoader() {
        jQuery('#loader').css({display: 'none'});
    }
    hideLoader();


    /* ==========================================================================
    Spinner
    ========================================================================== */
    jQuery('.spinner-loader').animate({
        opacity: 0
    }, 1000);
    jQuery('.spinner-loader').hide(1500);


    /* ==========================================================================
    Blog
    ========================================================================== */
    if (jQuery('body').hasClass('blog-grid')) {

        jQuery('body.blog-grid .blog-posts-wrapper').animate({
            opacity: 1
        }, 2500);

        blog_grid = jQuery('.blog-grid .blog-posts-wrapper');
        blog_grid.isotope({
            filter: '*',
            itemSelector: 'article.blog-post',
            layoutMode: 'masonry',
            animationOptions: {
                duration: 850,
                easing: 'linear',
                queue: false
            }
        });

    }

    function blog_post_direction() {
        jQuery('body.blog-timeline article.blog-post').each(function () {
            var posLeft = jQuery(this).css('left');
            if (posLeft === '0px') {
                jQuery(this).addClass('left-post');
            } else {
                jQuery(this).addClass('right-post');
            }
        });
    }
    if (jQuery('body').hasClass('blog-timeline')) {
        blog_post_direction();
    }


    /* ==========================================================================
    Shop Grid
    ========================================================================== */
    if (jQuery('body').hasClass('shop-grid')) {

        shop_grid = jQuery('body.shop-grid .shop-items-wrapper');

        shop_grid.animate({
            opacity: 1
        }, 2500);

        shop_grid.isotope({
            filter: '*',
            itemSelector: 'article.shop-block',
            layoutMode: 'masonry',
            animationOptions: {
                duration: 850,
                easing: 'linear',
                queue: false
            },
            getSortData: {
                pricelth: function (itemElem) {
                    var plth = jQuery(itemElem).find('.shop-item-price .new-price span:last').text();
                    return parseFloat(plth.replace(/[\(\)]/g, ''));
                },
                pricehtl: function (itemElem) {
                    var phtl = jQuery(itemElem).find('.shop-item-price .new-price span:last').text();
                    return parseFloat(phtl.replace(/[\(\)]/g, ''));
                },
                nameatoz: '.shop-item-title h4',
                nameztoa: '.shop-item-title h4'
            }
        });

    }


    /* ==========================================================================
    Portfolio Grid
    ========================================================================== */
    if (jQuery('body').hasClass('portfolio-grid')) {

        jQuery('body.portfolio-grid .portfolio-blocks-wrapper').animate({
            opacity: 1
        }, 2500);

        portfolio_grid = jQuery('.portfolio-grid .portfolio-blocks-wrapper');
        portfolio_grid.isotope({
            filter: '*',
            itemSelector: 'article.portfolio-block',
            layoutMode: 'masonry',
            animationOptions: {
                duration: 850,
                easing: 'linear',
                queue: false
            }
        });

    }

    function portfolio_block_direction() {
        jQuery('body.portfolio-timeline article.portfolio-block').each(function () {
            var posLeft = jQuery(this).css('left');
            if (posLeft === '0px') {
                jQuery(this).addClass('left-block');
            } else {
                jQuery(this).addClass('right-block');
            }
        });
    }
    if (jQuery('body').hasClass('portfolio-timeline')) {
        portfolio_block_direction();
    }

    if (jQuery('body').hasClass('portfolio-timeline')) {
        jQuery('.portfolio-grid .portfolio-blocks-wrapper').isotope('on', 'layoutComplete', function () {
            jQuery('body.portfolio-timeline article.portfolio-block').removeClass('left-block');
            jQuery('body.portfolio-timeline article.portfolio-block').removeClass('right-block');
            portfolio_block_direction();
        });
    }


    /* ==========================================================================
    Team Grid
    ========================================================================== */
    if (jQuery('.team-blocks-wrapper').length) {
        team_grid = jQuery('.team-blocks-wrapper');
        team_grid.isotope({
            filter: '*',
            itemSelector: '.member-block',
            layoutMode: 'masonry',
            animationOptions: {
                duration: 850,
                easing: 'linear',
                queue: false
            }
        });
    }


    /* ==============================================
    Background Image Slider
    =============================================== */
    jQuery('body.background-image-slider #supersized li a img').css({top: '0'});


}); // Window Load
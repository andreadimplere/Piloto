/*global jQuery, document*/
/* ==========================================================================
Document Ready Function
========================================================================== */
jQuery(document).ready(function () {

    'use strict';

    var blog_comment_name,
        blog_comment_email,
        blog_comment_website,
        blog_comment_message,
        blog_comment_emailReg;

    jQuery('.blog-comment-form .btn').on('click', function (e) {
        e.preventDefault();

        blog_comment_emailReg = new RegExp(/^(("[\w-\s]+")|([\w\-]+(?:\.[\w\-]+)*)|("[\w-\s]+")([\w\-]+(?:\.[\w\-]+)*))(@((?:[\w\-]+\.)*\w[\w\-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);

        blog_comment_name = jQuery('#blog-comment-name');
        blog_comment_email = jQuery('#blog-comment-email');
        blog_comment_message = jQuery('#blog-comment-message');
        blog_comment_website = jQuery('#blog-comment-website');
        var valid = blog_comment_emailReg.test(blog_comment_email.val());

        if (blog_comment_name.val() === "") {
            jQuery('#blog-comment-name').addClass('blog-comment-error');
            jQuery('.blog-comment-message').html('<div><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Your name is required.</p></div></div>');
            return false;
        } else if (blog_comment_email.val() === "") {
            jQuery('#blog-comment-email').addClass('blog-comment-error');
            jQuery('.blog-comment-message').html('<div><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Your email is required.</p></div></div>');
            return false;
        } else if (!valid) {
            jQuery('#blog-comment-email').addClass('blog-comment-error');
            jQuery('.blog-comment-message').html('<div><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Please enter a valid email address.</p></div></div>');
            jQuery('input[type=submit]', jQuery(".blog-comment-form")).removeAttr('disabled');
            return false;
        } else if (blog_comment_message.val() === "") {
            jQuery('#blog-comment-message').addClass('blog-comment-error');
            jQuery('.blog-comment-message').html('<div><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Your message is required.</p></div></div>');
            return false;
        } else {
            jQuery('.blog-comment-message').html('<div><div class="alert alert-nesto alert-nesto-sucess"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Thanks! Your comment needs moderator apporoval.</p></div></div>');
            jQuery('#blog-comment-name').val('');
            jQuery('#blog-comment-email').val('');
            jQuery('#blog-comment-message').val('');
            jQuery('#blog-comment-website').val('');
        }

    });

    jQuery('#blog-comment-name').focus(function () {
        jQuery('#blog-comment-name').removeClass('blog-comment-error');
        jQuery('.blog-comment-message').html('');

    });
    jQuery('#blog-comment-email').focus(function () {
        jQuery('#blog-comment-email').removeClass('blog-comment-error');
        jQuery('.blog-comment-message').html('');
    });
    jQuery('#blog-comment-website').focus(function () {
        jQuery('#blog-comment-website').removeClass('blog-comment-error');
        jQuery('.blog-comment-message').html('');
    });
    jQuery('#blog-comment-message').focus(function () {
        jQuery('#blog-comment-message').removeClass('blog-comment-error');
        jQuery('.blog-comment-message').html('');
    });

});
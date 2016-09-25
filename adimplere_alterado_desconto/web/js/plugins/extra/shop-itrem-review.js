/*global jQuery, document*/
/* ==========================================================================
Document Ready Function
========================================================================== */
jQuery(document).ready(function () {

    'use strict';

    var shop_item_review_form_rate,
        shop_item_review_form_name,
        shop_item_review_form_email,
        shop_item_review_form_message,
        shop_item_review_form_emailReg;

    jQuery('.shop-item-review-form .btn').on('click', function (e) {
        e.preventDefault();

        shop_item_review_form_emailReg = new RegExp(/^(("[\w-\s]+")|([\w\-]+(?:\.[\w\-]+)*)|("[\w-\s]+")([\w\-]+(?:\.[\w\-]+)*))(@((?:[\w\-]+\.)*\w[\w\-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);

        shop_item_review_form_name = jQuery('#shop-item-review-form-name');
        shop_item_review_form_email = jQuery('#shop-item-review-form-email');
        shop_item_review_form_message = jQuery('#shop-item-review-form-message');
        var valid = shop_item_review_form_emailReg.test(shop_item_review_form_email.val());

        if (shop_item_review_form_name.val() === "") {
            jQuery('#shop-item-review-form-name').addClass('shop-item-review-form-error');
            jQuery('.shop-item-review-form-message').html('<div class="row"><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Your name is required.</p></div></div>');
            return false;
        } else if (shop_item_review_form_email.val() === "") {
            jQuery('#shop-item-review-form-email').addClass('shop-item-review-form-error');
            jQuery('.shop-item-review-form-message').html('<div class="row"><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Your email is required.</p></div></div>');
            return false;
        } else if (!valid) {
            jQuery('#shop-item-review-form-email').addClass('shop-item-review-form-error');
            jQuery('.shop-item-review-form-message').html('<div class="row"><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Please enter a valid email address.</p></div></div>');
            jQuery('input[type=submit]', jQuery(".shop-item-review-form")).removeAttr('disabled');
            return false;
        } else if (shop_item_review_form_message.val() === "") {
            jQuery('#shop-item-review-form-message').addClass('shop-item-review-form-error');
            jQuery('.shop-item-review-form-message').html('<div class="row"><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Your review is required.</p></div></div>');
            return false;
        } else if (!jQuery("input[name='review-rating']:checked").val()) {
            jQuery('.shop-item-review-form-message').html('<div class="row"><div class="alert alert-nesto alert-nesto-danger"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Your rate is required.</p></div></div>');
        } else {
            jQuery('.shop-item-review-form-message').html('<div class="row"><div class="alert alert-nesto alert-nesto-sucess"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><p>Thanks! for your review.</p></div></div>');
            jQuery('#shop-item-review-form-name').val('');
            jQuery('#shop-item-review-form-email').val('');
            jQuery('#shop-item-review-form-message').val('');
            jQuery('.shop-item-review-form').find("input:radio:checked").prop('checked', false);
        }

    });

    jQuery('#shop-item-review-form-name').focus(function () {
        jQuery('#shop-item-review-form-name').removeClass('shop-item-review-form-error');
        jQuery('.shop-item-review-form-message').html('');

    });
    jQuery('#shop-item-review-form-email').focus(function () {
        jQuery('#shop-item-review-form-email').removeClass('shop-item-review-form-error');
        jQuery('.shop-item-review-form-message').html('');
    });
    jQuery('#shop-item-review-form-message').focus(function () {
        jQuery('#shop-item-review-form-message').removeClass('shop-item-review-form-error');
        jQuery('.shop-item-review-form-message').html('');
    });

});
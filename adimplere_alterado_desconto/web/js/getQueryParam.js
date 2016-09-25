function getQueryParam(param) {
    param = param.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regexS = "[\\?&]" + param + "=([^&#]*)",
        regex = new RegExp( regexS ),
        results = regex.exec(document.URL);
    if (results === null || (results && typeof(results[1]) !== 'string' && results[1].length)) {
        return '';
    } else {
        return decodeURIComponent(results[1]).replace(/\+/g, ' ');
    }
};
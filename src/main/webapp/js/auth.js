'use strict';

(() => {
    const $login = $('#login');
    const $logout = $('.logout');
    if (localStorage.getItem("token")) {
        $login.addClass('hidden');
        $logout.removeClass('hidden');

    } else {
        $login.removeClass('hidden');
        $logout.addClass('hidden');
    }
    $logout.on('click', () => {
        localStorage.removeItem("token");
        window.location.reload();
    })
})();
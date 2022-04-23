'use strict';

(() => {
    const $login = $('#login');
    const $logout = $('.logout');
    const $dash = $('.dash');
    if (localStorage.getItem("token")) {
        $login.addClass('hidden');
        $logout.removeClass('hidden');
		$dash.removeClass('hidden');
    } else {
        $login.removeClass('hidden');
        $logout.addClass('hidden');
        $dash.addClass('hidden');
    }
    $logout.on('click', () => {
        localStorage.removeItem("token");
        window.location.reload();
    })
})();
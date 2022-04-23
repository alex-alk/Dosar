'use strict';

const $platforms = $('#platforms'), $addPlatformLink = $('#add-platform-link'),
    $showPlatformsLink = $('#show-platforms-link');

const $chapters = $('#chapters'), $addChaptersLink = $('#add-chapters-link'),
    $showChaptersLink = $('#show-chapters-link');

const urlString = window.location.href
const url = new URL(urlString);
const id = url.searchParams.get("c");
const platformId = url.searchParams.get("p");

$('#chapter-link-' + id).addClass('active');
$('#home-collapse-' + platformId).addClass('show');
$('#btn-collapse-' + platformId).attr('aria-expanded', true);
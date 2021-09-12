'use strict';

const $platforms = $('#platforms'), $addPlatformLink = $('#add-platform-link'),
    $showPlatformsLink = $('#show-platforms-link');

const $chapters = $('#chapters'), $addChaptersLink = $('#add-chapters-link'),
    $showChaptersLink = $('#show-chapters-link');

if (window.location.pathname == '/admin/platform/create') {
	$platforms.addClass("show");
	$addPlatformLink.addClass("active");
	$('#platforms-btn').attr('aria-expanded', true);
}

if (window.location.pathname == '/admin/platform/edit') {
	$platforms.addClass("show");
	$('#platforms-btn').attr('aria-expanded', true);
}

if (window.location.pathname == '/admin/chapter/edit') {
	$chapters.addClass("show");
	$('#chapters-btn').attr('aria-expanded', true);
}

if (window.location.pathname == '/admin/platform/list') {
	$platforms.addClass("show");
	$showPlatformsLink.addClass("active");
	$('#platforms-btn').attr('aria-expanded', true);
}

if (window.location.pathname == '/admin/chapter/create') {
	$chapters.addClass("show");
	$addChaptersLink.addClass("active");
	$('#add-chapter-btn').attr('aria-expanded', true);
}

if (window.location.pathname == '/admin/chapter/list') {
	$chapters.addClass("show");
	$showChaptersLink.addClass("active");
	$('#chapters-btn').attr('aria-expanded', true);
}

const urlString = window.location.href
const url = new URL(urlString);
const id = url.searchParams.get("id");
const platformId = url.searchParams.get("platform");

$('#chapter-link-' + id).addClass('active');
$('#home-collapse-' + platformId).addClass('show');
$('#btn-collapse-' + platformId).attr('aria-expanded', true);
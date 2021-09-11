'use strict';

const $addPlatform = $('#add-platform'), $addPlatformLink = $('#add-platform a');
const $addChapter = $('#add-chapter'), $addChapterLink = $('#add-chapter a');
const $addChapterContent = $('#add-chapter_content'), $addChapterContentLink = $('#add-chapter_content a');

if (window.location.pathname == '/admin/platform/create') {
	$addPlatform.addClass("show");
	$addPlatformLink.addClass("active");
	$('#add-platform-btn').attr('aria-expanded', true);
}
if (window.location.pathname == '/admin/chapter/create') {
	$addChapter.addClass("show");
	$addChapterLink.addClass("active");
	$('#add-chapter-btn').attr('aria-expanded', true);
}

const urlString = window.location.href
const url = new URL(urlString);
const id = url.searchParams.get("id");
const platformId = url.searchParams.get("platform");

$('#chapter-link-' + id).addClass('active');
$('#home-collapse-' + platformId).addClass('show');
$('#btn-collapse-' + platformId).attr('aria-expanded', true);
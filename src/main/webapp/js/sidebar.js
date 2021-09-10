'use strict';

const $addPlatform = $('#add-platform'), $addPlatformLink = $('#add-platform a');
const $addChapter = $('#add-chapter'), $addChapterLink = $('#add-chapter a');
const $addChapterContent = $('#add-chapter_content'), $addChapterContentLink = $('#add-chapter_content a');

if (window.location.pathname == '/admin/platform/create') {
	$addPlatform.addClass("show");
	$addPlatformLink.addClass("active");
}
if (window.location.pathname == '/admin/chapter/create') {
	$addChapter.addClass("show");
	$addChapterLink.addClass("active");
}
if (window.location.pathname == '/admin/chapter_content/create') {
	$addChapterContent.addClass("show");
	$addChapterContentLink.addClass('active');
}
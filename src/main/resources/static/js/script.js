$(".fancyboxLauncher").on("click", function () {
    $(".fancybox").eq(0).trigger("click");
    return false;
});

$(".fancybox")
    .attr('rel', 'gallery')
    .fancybox({
    padding: 0
});
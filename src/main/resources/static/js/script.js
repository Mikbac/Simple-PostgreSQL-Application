/**
 * -- Created by MikBac on 27.09.2019
 */

$(function () {
    $("#Kolumna1").show();

    $("#select01").on("change", function () {
        $("#Kolumna1").hide();
        $(".myClass").hide();
        $("div[id='" + $(this).val() + "']").show();
    });
});
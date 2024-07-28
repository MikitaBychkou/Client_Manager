$(function() {
    $("#datepicker").datepicker({
        dateFormat: "dd/mm/yy",
        altField: "#date_of_birth",
        altFormat: "dd/mm/yy",
        onSelect: function(dateText) {
            $("#choose_date_btn").text(dateText);
            $("#datepicker").hide();
        }
    });

    $("#choose_date_btn").click(function(event) {
        event.preventDefault();
        $("#datepicker").show().position({
            my: "left top",
            at: "left bottom",
            of: this
        });
    });

    $(document).mousedown(function(event) {
        if (!$(event.target).closest('#datepicker, #choose_date_btn').length) {
            $("#datepicker").hide();
        }
    });
});
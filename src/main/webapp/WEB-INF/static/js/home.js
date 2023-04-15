$(document).ready(function () {
    const logout = $("#logout-form");
    logout.submit(function (e) {
        e.preventDefault();
        $.ajax({
            contentType: "application/x-www-form-urlencoded",
            success: function (data) {
                window.location.reload(true);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("Oops.. Something went wrong, please try again.");
            },
            type: "POST",
            url: "/logout"
        });
    })

    $('a[data-toggle=modal], button[data-toggle=modal]').click(function () {
        let student_name = '';
        if (typeof $(this).data('student-name') !== 'undefined') {
            student_name = $(this).data('student-name');
        }
        $('#student-name').text(student_name)
    })
})
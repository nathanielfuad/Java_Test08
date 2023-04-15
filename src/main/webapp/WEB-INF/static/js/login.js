$(document).ready(function (){
    const loginForm = $("#login-form");

    const userIdField = $("#userId");
    const passwordField = $("#password");
    const errorMessageText = $("#error-message");

    loginForm.submit(function (e) {
        e.preventDefault();
        let errorMessage = "";
        let userId = userIdField.val();
        if(!userId) {
            errorMessage = "Username must not be empty";
        }
        let password = passwordField.val();
        if(!password) {
            errorMessage = "Password must not be empty";
        }
        if(errorMessage){
            alert(errorMessage)
        }else{
            $.ajax({
                contentType: "application/x-www-form-urlencoded",
                data: jQuery.param({ userId: userIdField.val(), password : passwordField.val()}),
                success: function (data) {
                    if(data.startsWith("error:")){
                        errorMessageText.text(data.substring(6));
                    }else{
                        window.location.reload(true);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("Oops.. Something went wrong, please try again.");
                },
                type: "POST",
                url: "/login"
            });
        }
    })
})
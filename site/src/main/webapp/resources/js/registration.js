document.addEventListener('DOMContentLoaded', function () {
    $.validator.setDefaults({
        highlight: function(element) {
            $(element)
                .closest('.form-group')
                .addClass('has-warning');
        },
        unhighlight: function(element) {
            $(element)
                .closest('.form-group')
                .removeClass('has-warning');
        }
    });
    $('#registrationForm').validate({
        ignore: ":hidden",
        rules: {
            firstname: {required: true},
            lastname: {required: true},
            email: {required: true, email: true,remote : {
                url: '/api/account/check/email',
                type: "GET",
                data: {
                    email: function() {
                        return $('#email').val();
                    },
                    negation: function () {
                        return true;
                    }
                }
            }},
            password: {required: true},
            passwordconfirm: {required: true, equalTo: '#password'},
            hiddenRecaptcha: {required: function () {return grecaptcha.getResponse() === '';}}

        },
        messages: {
            firstname: {required: "Please enter First Name"},
            lastname: {required: "Please enter Last Name"},
            email: {remote: $.validator.format('Email {0} exists in the database')},
            hiddenRecaptcha: {required: 'Incorrect reCaptcha'}
        },
        submitHandler: function () { registration(); }
    });

    function registration() {
        var registrationDTO = {"firstname":$('#firstname').val(),
            "lastname":$('#lastname').val(),
            "email":$('#email').val(),
            "password":$('#password').val(),
            "passwordconfirm":$('#passwordconfirm').val(),
            "country":$('#country').val(),
            "reCaptcha":grecaptcha.getResponse()};

        $.ajax({
            type: 'POST',
            url: '/api/account/registration',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(registrationDTO),
            complete: function (event) {
                if(event.status === 201) {

                } else {
                    var obj = JSON.parse(event.responseText);
                    for(var i = 0; i < obj.field_errors.length; ++i) {
                        var objError = obj.field_errors[i];
                        alert(objError.field + " " +objError.messages);
                    }
                }
            }
        });

    };
});
function recaptchaCallback() {
    alert(response);
    $('#hiddenRecaptcha').valid();
}
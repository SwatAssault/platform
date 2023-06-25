function test() {
    var url = "http://localhost:8080/blog/users";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (response) {
            console.log(response);
            $('#api-result').text(JSON.stringify(response))
        }
    });
}

function clean() {
    $('#api-result').text('');
}

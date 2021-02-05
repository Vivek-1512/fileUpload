$(document).ready(function() {
    $('form').submit(function(event) {
        event.preventDefault();
 
        // Calling AJAX
        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            success : function(response) {
                $('#image_frame').html(response);
            },
            beforeSend : function() {
                $('#image_frame').html('<h1>Uploading......</h1>');
            }
        });
 
        return false;
    });
 
});

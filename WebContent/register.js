var URL_SUBMIT = '/IRORM/register?'
$(document).ready(function(){
    $("#submit").click(function(){
        var submit_data = {};
        submit_data['name'] = $("#name").val();
        submit_data['address'] = $("#address").val();
        submit_data['phone'] = $("#phone").val();
        $.post(URL_SUBMIT, submit_data, function(data){
            if (data.status == 1) {
                alert("注册成功");
            } else {
                alert("注册失败");
            }
        }, 'json');
    });
});

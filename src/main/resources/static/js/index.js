$(function () {

    //开始加载首页的 需要的内容
    personalNotes();
})


function personalNotes(){
    // var indexpage=$("#indexPage");//获取当前第几页
    // var size=$("#size");//每页大小
    $.ajax({
        type:"GET",
        url:"/personaleNotes/findAllPersonalNotesByPage",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        datatype:"json",
        data:{
            "pageIndex":1,
            "size":10,
        },
        success:function (result) {
            // debugger;//返回成功后取得数据
            //遍历数据会回填到页面的div中
            $.each(result.content,function (i,iteam) {

                $("#contentLists").append(
                    '<div class="list-group-item item_article">'+
                    '<div class="row">'+
                    '<div class="div_center col-xs-9">'+
                    '<div class="list-group-item-heading div_article_title">'+
                    ' <strong id="article_title"> '+iteam.title+' </strong>'+
                    '</div>'+
                    '<p class="list-group-item-text div_article_content" id="article_content">'+iteam.content+
                    '</p>'+
                    '<p>'+
                    '<button class="btn btn-success pull-right" onclick="moreInfo(\''+iteam.id+'\')" style="margin-bottom: 10px;" >'+' 查看更多 &raquo;'+'</button>'+
                    '</p>'+
                    '</div>'+
                    '<div class="col-xs-3 div_right_info">'+
                    '<img class="iv_article img-rounded" src="../static/images/ic_p5.jpg">'+
                    '<div id="article_time">'+new Date(iteam.createTime).toLocaleString()+'</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'
                );
            })

        }



    })
}

/*
为查看更多 按钮绑定 单击事件
* */
function moreInfo(id) {
    $.ajax({
        type:"GET",
        url:"/personaleNotes/findPersonalNotesById",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        datatype:"json",
        data:{
            "id":id
        },
        success:function (data) {
            debugger;
            $("#notesModalLabel").val(data.title);
            $("#content_modal").val(data.content);
            $('#notesModal').modal('show');


        }

    })

}
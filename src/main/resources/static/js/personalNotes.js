/*个人随记的部分   开始   */

//ajax 随记 编写提交
$("#save-diary").on('click', function()
{

    var diaryTitle=$("#diary-title").val();//获取标题
    // var diaryClassify=$("#diary-classify").val();
    var diaryContent=$("#diary-content").val();//获取随记内容

    //判断标不能为空！
    if(diaryTitle==null||diaryTitle==''||diaryTitle == undefined){
        $("#diary-title").css('borderColor','red');
        $("#diary-title").attr('placeholder','提示：标题不能为空哦！');
        return;

    }else{
        $("#diary-title").css('borderColor','')
    }
    //判断内容不能为空！
    if(diaryContent == null || diaryContent == '' ||diaryContent==undefined){
        $("#diary-content").css('boredColor','red');
        $("#diary-content").attr('placeholder','提示：内容不能为空哦！');
        return;

    }else{
        $("#diary-content").css('boredColor','')

    }

    $.ajax({
        type:"POST",
        url:"/personaleNotes/addPersonalNotes",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        datatype:"json",
        data:{
            "title":diaryTitle,
            "category":"生活随记",
            "content":diaryContent,
        },
        success:function(result){
            if(result=="success"){
                $("#diary-title").reset();
                $("#diary-classify").reset();
                $("#diary-content").reset();
            }
            if(result == "inputAccount"){
                alert("抱歉，需要用户进行登录！");
            }
            else{
                alert("failed");
            }
            $("#diary-title").reset();
            $("#diary-classify").reset();
            $("#diary-content").reset();
        }
    });
});


/*生活随机的绑定单击事件*/

$("#life_note").on("click",function () {
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
                    '<button class="btn btn-success pull-right" onclick="moreInfo(\''+iteam.id+'\')"  style="margin-bottom: 10px;">'+' 查看更多 &raquo;'+'</button>'+
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

});

// function moreInfo(id) {
//     $.ajax({
//         type:"GET",
//         url:"/personaleNotes/findPersonalNotesById",
//         contentType: "application/x-www-form-urlencoded; charset=utf-8",
//         datatype:"json",
//         data:{
//             "id":id
//         },
//         success:function (data) {
//
//
//         }
//
//     })
//
// }
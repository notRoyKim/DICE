$( document ).ready(function() {
    var TmpSearchKey = "";

    $("#searchbox").focus(function() {
        TmpSearchKey =  $("#searchbox").val();
        $("#searchbox").val("");
        console.log(TmpSearchKey);
    })
    .focusout(function() {
        if ($("#searchbox").val() == "") {
            $("#searchbox").val(TmpSearchKey);
        }
    })
    .keypress(function(event) {
        if (event.charCode ==13) Search($("#searchbox").val());
    });
});

function Search(SearchKey) {
    var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi
    str = SearchKey.replace(regExp,"");

    if(str == "" || str == "Search.."){
        alert("검색어를 입력해주세요.");
    }
    else if(str.length < 2) {
        alert("검색어를 두 글자 이상으로 입력해 주세요.");
    }
    else{
        var ESearchKey = encodeURI(SearchKey);
        var DataURL ="/Search_JSON/?query="  + ESearchKey;

        $.getJSON(DataURL, function(JSonData) {
            if (JSonData.Count == 0)
                alert(SearchKey + "에 대한 결과가 없습니다.",location.reload());
            else {
                path = "/SearchResult/?query=" + ESearchKey;
                window.location.href = path;
            }
        });
    }
}
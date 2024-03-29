
// index.js만의 scop를 유지하기 위해 변수 안에 함수를 선언한다.
// 공동 작업시, 함수명 중복으로 인한 오류를 피하기 위한 구조.

let main = {
    init : function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function() {
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({    // ajax 통신으로 /api/v1/posts 호출
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)  // js array object to JSON
        }).done(function () {   // 성공시
            alert("글이 등록됐습니다.");
            window.location.href = '/'; // 메인페이지로 이동
        }).fail(function (error) {  // 에러 예외처리
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
        let id = $('#id').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)  // js array object to JSON
        }).done(function () {   // 성공시
            alert("글이 수정됐습니다.");
            window.location.href = '/'; // 메인페이지로 이동
        }).fail(function (error) {  // 에러 예외처리
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        let id = $('#id').val();
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {   // 성공시
            alert("글이 삭제됐습니다.");
            window.location.href = '/'; // 메인페이지로 이동
        }).fail(function (error) {  // 에러 예외처리
            alert(JSON.stringify(error));
        });
    }
};
main.init();
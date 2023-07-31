

function getUserList() {
    console.log("비동기 통신 시작")
    $.ajax({
        url: "/adminGetUserList",
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log("통신 성공");
            console.log(result);
            $('#userListTable').html("")
            // 서버에서 반환된 JSON 데이터 파싱
            // 데이터를 처리하고 화면에 출력
            var html = '<table>\n' +
                '    <tr>\n' +
                '        <th>UserId</th>\n' +
                '        <th>UsedId</th>\n' +
                '        <th>Pw</th>\n' +
                '        <th>Address</th>\n' +
                '        <th>Phone</th>\n' +
                '        <th>Email</th>\n' +
                '    </tr>\n' +
                '    <tbody id="UserListTbody">\n' +
                '\n' +
                '    </tbody>\n' +
                '</table>';
            $('#userListTable').append(html)
            for (var i = 0; i < result.length; i++) {
                var tableTd = '<tr>';
                tableTd += '<td>' + result[i].userId + '</td>';
                tableTd += '<td>' + result[i].userUseId + '</td>';
                tableTd += '<td>' + result[i].userPw + '</td>';
                tableTd += '<td>' + result[i].userAddress + '</td>';
                tableTd += '<td>' + result[i].userPhone + '</td>';
                tableTd += '<td>' + result[i].userEmail + '</td>';
                tableTd += '</tr>';

                $('#UserListTbody').append(tableTd);
                // $('#tableBody').load();
            }
        },
        error: function () {
            alert("통신실패")
        }
    });
}
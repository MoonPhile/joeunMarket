function getUserList() {
    console.log("비동기 통신 시작");
    $.ajax({
        url: "/adminGetUserList",
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log("통신 성공");
            console.log(result);

            $('#userListTable').empty(); // 이전 내용 지우기

            var table = $('<table class="table table-striped table-hover"></table>');
            var thead = $('<thead></thead>');
            var tbody = $('<tbody></tbody>');

            // 테이블 헤더 추가
            thead.append('<tr><th>UserId</th><th>UserId</th><th>Pw</th><th>Address</th><th>Phone</th><th>Email</th></tr>');
            table.append(thead);

            // 테이블 내용 추가
            for (var i = 0; i < result.length; i++) {
                var rowData = result[i];
                var tableRow = $('<tr></tr>');
                tableRow.append('<td>' + rowData.userId + '</td>');
                tableRow.append('<td>' + rowData.userUseId + '</td>');
                tableRow.append('<td>' + rowData.userPw + '</td>');
                tableRow.append('<td>' + rowData.userAddress + '</td>');
                tableRow.append('<td>' + rowData.userPhone + '</td>');
                tableRow.append('<td>' + rowData.userEmail + '</td>');
                tbody.append(tableRow);
            }
            table.append(tbody);

            $('#userListTable').append(table);
        },
        error: function () {
            alert("통신실패");
        }
    });
}

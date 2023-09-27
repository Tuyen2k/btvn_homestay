function addCreate() {
    //lấy dữ liệu từ form html
    let name = $('#name').val();
    let newStatus = {
        name: name
    };
    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newStatus),
        //tên API
        url: "http://localhost:8080/api/statuses",
        //xử lý khi thành công
        success: displayStatus

    });
    alert("Create success ")
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function displayStatus() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/statuses",
        //xử lý khi thành công
        success: function (data) {
            // hiển thị danh sách ở đây
            let content = '    <table id="display-list"  border="1"><tr>\n' +
                '        <th>Name</td>\n' +
                '        <th>Delete</td>\n' +
                '        <th>Update</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getStatus(data[i]);
            }
            content += "</table>"
            document.getElementById('statusList').innerHTML = content;
            document.getElementById('statusList').style.display = "block";
            document.getElementById('add-Status').style.display = "none";
            document.getElementById('display-create').style.display = "block";
            document.getElementById('title').style.display = "block";
        }
    });
}

function displayFormCreate() {
    document.getElementById('statusList').style.display = "none";
    document.getElementById('add-Status').style.display = "block";
    document.getElementById('display-create').style.display = "none";
    document.getElementById('title').style.display = "none";
}

function getStatus(status) {
    return `<tr>
<td>${status.name}</td>` +
        `<td class="btn"><button class="deleteStatus" 
onclick="deleteStatus(${status.id_status})">Delete</button></td> +
\`<td class="btn"><button  onclick="updateDisplay(${status.id_status})">Update</button></td>
</tr>`;
}

function deleteStatus(id_status) {
    $.ajax({
        type: "DELETE",
        //tên API
        url: `http://localhost:8080/api/statuses/${id_status}`,
        //xử lý khi thành công
        success: displayStatus
    });
    alert("delete success")
}
function updateDisplay (id_status){
    $.ajax({
        type :"GET",
        url :`http://localhost:8080/api/statuses/${id_status}`,
        success :function (status){
            $("#name1").val(status.name)
            $("#id_status").val(status.id_status)
            document.getElementById('statusList').style.display = "none";
            document.getElementById('update-Status').style.display = "block";
            document.getElementById('add-Status').style.display = "none";
            document.getElementById('display-create').style.display = "none";
            document.getElementById('title').style.display = "none";
        }
    })
}
function update(id_status){
    let name1 =$("#name1").val();
    let update_status  ={
        name1 :name1
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(update_status),
        //tên API
        url: `http://localhost:8080/api/statuses/${id_status}`,
        //xử lý khi thành công
        success: function (){
            console.log("Update success!!!");
            displayStatus();
        }
    });
    alert(" Update success")
    event.preventDefault();
}


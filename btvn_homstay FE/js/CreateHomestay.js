function status() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/statuses",
        //xử lý khi thành công
        success: function (data) {
            // hiển thị danh sách ở đây
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value=${data[i].id_status}>${data[i].name}</option>`;
            }
            document.getElementById("status").innerHTML = content;
        }
    })
}

function getDataDB() {
    status();
    address();
}

function address() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/address",
        //xử lý khi thành công
        success: function (data) {
            // hiển thị danh sách ở đây
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value=${data[i].id_address}>${data[i].name}</option>`;
            }
            document.getElementById("address").innerHTML = content;
        }
    })
}

function createHomestay() {
    let name = $('#name').val();
    let price = $('#price').val();
    let description = $('#description').val();
    let number = $('#max-number-stay').val();
    let status = $('#status').val();
    let address = $('#address').val();
    let file = $('#file')[0].files[0];
    console.log(file)
    let newHomestay = {
        name: name,
        price: price,
        description: description,
        max_number_stay: number,
        status: {
            id_status: status
        },
        address: {
            id_address: address
        }
    }
    let formData = new FormData();
    var homestay = JSON.stringify(newHomestay);
    var homestayB = new Blob([homestay],{type : 'application/json'})
    formData.append("file", file);
    formData.append("homestay", homestayB)
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/homestay",
        processData: false,
        contentType: false,
        data: formData,
        //tên API
        success: function () {
            console.log("OK")
        }

    });
    // alert("Create success ")

    event.preventDefault();
}


        
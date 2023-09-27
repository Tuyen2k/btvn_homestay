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
    findCity();
    // findDistrict();
    // findWard();
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

function findCity(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/city",
        success: function(data){
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value=${data[i].id_city}>${data[i].name}</option>`;
            }
            document.getElementById("select_city").innerHTML = content;
        }
    })
}
function findDistrict(){

    $(document).ready(function () {
        $('select').selectize({
            sortField: 'text'
        });
    });
    let id_city = document.getElementById("city").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/districts/${id_city}/city`,
        success: function(data){
            let content = '<select class="select" onchange="findWard()" id="district">';
            content += '<option>Choice a district...</option>';
            for (let i = 0; i < data.length; i++) {
                content += '<option value="'+data[i].id_district+'">'+data[i].name+'</option>';
            }
            content += "</select>";
            document.getElementById("select_district").innerHTML = content;
        }
    })
}
function findWard(){

    $(document).ready(function () {
        $('select').selectize({
            sortField: 'text'
        });
    });
    let id_district = document.getElementById("district").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/wards/${id_district}/district`,
        success: function(data){
            let content = '<select class="select" id="ward">';
            content += '<option>Choice a ward...</option>';
            for (let i = 0; i < data.length; i++) {
                content += '<option value="'+data[i].id_ward+'">'+data[i].name+'</option>';
            }
            content += "</select>";
            document.getElementById("select_ward").innerHTML = content;
        }
    })
}



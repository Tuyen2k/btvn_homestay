let arrDB;

function getAll() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/homestay",
        success: function (data) {
            show(data);
            displayService(data)
            arrDB = data
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });

}

// getAll();

function show(arr) {
    let str = "";
    let count = 0;
    for (const h of arr) {
        console.log(h)
        //mở lại t cái tắt nhầm
        str += ` <tr>
              <td>${++count}</td>
              <td>${h.name}</td>
              <td>${h.price}</td>
              <td>${h.description}</td>
              <td>${h.max_number_stay}</td>
              <td><img style="width: 100px; height: 100px" src="../src/main/webapp/image/${h.image}" alt="image"></td>   
              <td>${h.status.name}</td>
              <td>${h.address.city.name}</td>
              <td>${h.address.district.name}</td>
              <td>${h.address.ward.name}</td>
              <td>${h.address.address_detail}</td>` +
            '<td><span id="service' + count + '"></span>' + '</td>' + `
              <td><button type="button" class="btn btn-warning" onclick="showEdit(${h.id_homestay})" data-toggle="modal" data-target="#modalEdit" >Edit</button></td>
              <td><button type="button" class="btn btn-danger"  onclick="deleteS(${h.id_homestay})">Delete</button></td>
             </tr>`
    }
    document.getElementById("show").innerHTML = str;

}

function showEdit(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/homestay/${id}`,
        success: function (data) {
            localStorage.setItem("id_update", data.id_homestay);
            localStorage.setItem("image", data.image);
            let address = JSON.stringify(data.address)
            localStorage.setItem("address", address)
            window.location.href = "save.html";
        }
    })
}

function displayService(arr) {
    let content = "";
    let count = 1;
    for (let i = 0; i < arr.length; i++) {
        let a = arr[i].service;
        for (let j = 0; j < a.length; j++) {
            content += a[j].name;
            if (j < a.length - 1) {
                content += ", "
            }
        }
        document.getElementById("service" + count).innerHTML = content;
        count++;
        content = '';
    }
}

function search() {
    let search = $("#search").val(); //.value but in jquerry
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/homestay/search?name=" + search,
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function searchByName() {
    let search = $("#search").val();
    let result = [];
    for (let i = 0; i < arrDB.length; i++) {
        if (arrDB[i].name.toLowerCase().includes(search.toLowerCase())) {
            result.push(arrDB[i])
        }
    }
    show(result);
    displayService(result);
}

function createForm() {
    address = {}
    localStorage.setItem("address", JSON.stringify(address));
    window.location.href = "save.html"
}

function deleteS(id) {
    if (confirm("Are your sure?")) {
        $.ajax({
            type: "GET",
            url: `http://localhost:8080/api/homestay/delete/${id}`,
            success: function () {
                alert("Delete success!!!");
                getAll();
            }
        })
    }
}

function getAllPage() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/homestay/findAll",
        success: function (data) {
            arrDB = data.content
            showPage(data)
            page(data)
        }
    })
}

function showPage(data) {
    let arr = data.content;
    let content = "";
    let count = 0;
    for (let h of arr) {
        content += ` <tr>
              <td>${++count}</td>
              <td>${h.name}</td>
              <td>${h.price}</td>
              <td>${h.description}</td>
              <td>${h.max_number_stay}</td>
              <td><img style="width: 100px; height: 100px" src="../src/main/webapp/image/${h.image}" alt="${h.image}"></td>   
              <td>${h.status.name}</td>
              <td>${h.address.city.name}</td>
              <td>${h.address.district.name}</td>
              <td>${h.address.ward.name}</td>
              <td>${h.address.address_detail}</td>` +
            '<td><span id="service' + count + '"></span>' + '</td>' + `
              <td><button type="button" class="btn btn-outline-warning" onclick="showEdit(${h.id_homestay})">Edit</button></td>
              <td><button type="button" class="btn btn-outline-danger"  onclick="deleteS(${h.id_homestay})">Delete</button></td>
             </tr>`
    }
    document.getElementById("show").innerHTML = content;
}

function page(data){
    let numberPage = data.number;
    let totalPage = data.totalPages;
    let content = `<div id="page">
<button class="btn btn-outline-primary" id="previous" onclick="previousP(${numberPage})">Previous</button>${numberPage + 1}/${totalPage}
<button class="btn btn-outline-primary"  id="next"  onclick="nextP(${numberPage}, ${totalPage})">Next</button>
</div>`;
    document.getElementById("page").innerHTML = content;
    if (numberPage === 0){
        $("#previous").hide()
    } else if (numberPage === totalPage - 1){
        $("#next").hide()
    }
}

function previousP(numberPage){
    if (numberPage === 0){
        alert("")
    }else {
        $.ajax({
            type : "GET",
            url : `http://localhost:8080/api/homestay/findAll?page=${numberPage - 1}`,
            success : function (data){
                showPage(data)
                page(data)
            }
        })
    }
}
function nextP(numberPage, totalPage){
    if (numberPage === totalPage - 1){
        $("#next").hide()
    }else {
        $("#next").show()
        $.ajax({
            type : "GET",
            url : `http://localhost:8080/api/homestay/findAll?page=${numberPage + 1}`,
            success : function (data){
                showPage(data)
                page(data)
            }
        })
    }
}
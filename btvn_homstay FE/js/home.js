function getAll() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/homestay",
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });

}

getAll();

function show(arr) {
    let str = "";
    let count = 0;
    for (const h of arr) {
        str += ` <tr>
              <td>${++count}</td>
              <td>${h.name}</td>
              <td>${h.price}</td>
              <td>${h.description}</td>
              <td>${h.max_number_stay}</td>
              <td>${h.image}</td>   
              <td>${h.status.name}</td>
              <td>${h.address.address_detail}</td>
              <td>${h.address.city.name}</td>
              <td>${h.address.district.name}</td>
              <td>${h.address.ward.name}</td>
              <td><button type="button" class="btn btn-warning" onclick="showEdit(${h.id_homestay})" data-toggle="modal" data-target="#modalEdit" >Edit</button></td>
              <td><button type="button" class="btn btn-danger"  onclick="deleteS(${h.id_homestay})">Delete</button></td>
             </tr>`

    }
    document.getElementById("show").innerHTML = str;
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
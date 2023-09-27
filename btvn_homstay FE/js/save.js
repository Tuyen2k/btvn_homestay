let address = JSON.parse(localStorage.getItem("address"));
function findCityS(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/city",
        success: function(data){
            let content = '<select id="city" onchange="findDistrictS()" placeholder="Choice a city..." style="width: 100%; height: 40px" class="form-select">';
            content += '<option>Choice a city...</option>';
            for (let i = 0; i < data.length; i++) {
                if (data[i].id_city === address.city.id_city){
                    content += '<option value="'+data[i].id_city+'" selected>'+data[i].name+'</option>';
                    continue
                }
                content += '<option value="'+data[i].id_city+'">'+data[i].name+'</option>';
            }
            content += "</select>";
            document.getElementById("select_city").innerHTML = content;
        }
    })
    findDistrictS()
    findWardS()
}
function findDistrictS(){
    let id_city = document.getElementById("city").value;
    if (id_city === "-1"){
        id_city = address.city.id_city;
    }
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/districts/${id_city}/city`,
        success: function(data){
            let content = '<select style="width: 100%; height: 40px" class="form-select" onchange="findWardS()" id="district">';
            content += '<option>Choice a district...</option>';
            for (let i = 0; i < data.length; i++) {
                if (data[i].id_district === address.district.id_district){
                    content += '<option value="'+data[i].id_district+'" selected>'+data[i].name+'</option>';
                    continue
                }
                content += '<option value="'+data[i].id_district+'">'+data[i].name+'</option>';
            }
            content += "</select>";
            document.getElementById("select_district").innerHTML = content;
        }
    })
}
function findWardS(){
    let id_district = document.getElementById("district").value;
    if (id_district === "-1"){
        id_district = address.district.id_district;
    }
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/wards/${id_district}/district`,
        success: function(data){
            let content = '<select style="width: 100%; height: 40px" class="form-select" id="ward">';
            content += '<option>Choice a ward...</option>';
            for (let i = 0; i < data.length; i++) {
                if (data[i].id_ward === address.ward.id_ward){
                    content += '<option value="'+data[i].id_ward+'" selected>'+data[i].name+'</option>';
                    continue
                }
                content += '<option value="'+data[i].id_ward+'">'+data[i].name+'</option>';
            }
            content += "</select>";
            document.getElementById("select_ward").innerHTML = content;
        }
    })
}

function findAllService(){
    $.ajax({
        url:"http://localhost:8080/api/services",
        type:"GET",
        success:function (data){
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += ` <div class="form-check" id="service">
                                <input class="form-check-input" type="checkbox" value="${data[i].id_service}" id="service${i}">
                                <label class="form-check-label" for="service${i}">${data[i].name}</label> 
                             </div>`
            }
            document.getElementById("service").innerHTML = content;
        }
    })
}
findAllService()

function save(){
    let name = $("#name").val();
    let price = $("#price").val();
    let capacity = $("#max_capacity").val();
    let description = $("#description").val();
    let file = $("#file")[0].files[0];
    let status = $("#status").val();
    let city = $("#city").val();
    let district = $("#district").val();
    let ward = $("#ward").val();
    let address_detail = $("#address_detail").val();
    let id = +localStorage.getItem("id_update")
    let homestay;
    if (file === undefined) {
        file = new File([], "", undefined)
    }
    if (id === -1 ){
        homestay = {
            name : name,
            price : price,
            max_number_stay : capacity,
            description : description,
            status : {
                id_status : 1
            },
            address : {
                city : {
                    id_city: city
                },
                district : {
                    id_district: district
                },
                ward : {
                    id_ward: ward
                },
                address_detail: address_detail,
                service : [
                    {
                        id_service: 1
                    }
                ]
            }
        }
    }else {
        if (address.city.id_city == city && address.district.id_district == district
        && address.ward.id_ward == ward && address.address_detail == address_detail){
            homestay = {
                id_homestay : id,
                name : name,
                price : price,
                max_number_stay : capacity,
                description : description,
                status : {
                    id_status : 1
                },
                address : address,
                image : localStorage.getItem("image"),
                service : [
                    {
                        id_service: 1
                    }
                ]
            }
        }else {
            homestay = {
                id_homestay : id,
                name : name,
                price : price,
                max_number_stay : capacity,
                description : description,
                status : {
                    id_status : 1
                },
                address : {
                    city : {
                        id_city: city
                    },
                    district : {
                        id_district: district
                    },
                    ward : {
                        id_ward: ward
                    },
                    address_detail: address_detail
                },
                image : localStorage.getItem("image"),
                service : [
                    {
                        id_service: 1
                    }
                ]
            }

        }

    }
    let formData = new FormData();
    formData.append("file", file);
    let homestayB = new Blob([JSON.stringify(homestay)], {type : 'application/json'});
    formData.append("homestay", homestayB);
    $.ajax({
        type:"POST",
        url: "http://localhost:8080/api/homestay",
        data: formData,
        contentType: false,
        processData : false,
        success: function (){
            alert("Success!!!")
            window.location.href = "home.html"
            localStorage.setItem("id_update", "-1");
        }
    })
    event.preventDefault()
}

function displayHomestayUpdate(){
    let id = localStorage.getItem("id_update");
    $.ajax({
        type:"GET",
        url: `http://localhost:8080/api/homestay/${id}`,
        success: function (data){
            document.getElementById("name").value = data.name;
            document.getElementById("price").value = data.price;
            document.getElementById("max_capacity").value = data.max_number_stay;
            document.getElementById("description").value = data.description;
            document.getElementById("status").value = data.status.name;
            // document.getElementById("city").value = data.address.city.name;
            // document.getElementById("district").value = data.address.district.name;
            // document.getElementById("ward").value = data.address.ward.name;
            document.getElementById("address_detail").value = data.address.address_detail;
        }
    })
}
function getDB(){
    displayHomestayUpdate()
    findCityS()
}

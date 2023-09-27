function findCity(){
    $(document).ready(function () {
        $('select').selectize({
            sortField: 'text'
        });
    });
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/city",
        success: function(data){
            let content = '<select id="city" onchange="findDistrict()" placeholder="Choice a city..."  class="select">';
            content += '<option value="">Choice a city...</option>';
            for (let i = 0; i < data.length; i++) {
                content += '<option value="'+data[i].id_city+'">'+data[i].name+'</option>';
            }
            content += "</select>";
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

class Address{
    id_address
    city
    district
    ward
    address_detail
    constructor() {
        this.id_address = -1
        this.city = {}
        this.district = {}
        this.ward = {}
        this.address_detail = ""
    }
}


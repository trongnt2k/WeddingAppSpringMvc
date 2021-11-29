/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addWeddinghallToCart(weddinghallId, weddinghallName, weddinghallPrice) {
    event.preventDefault();
    fetch("/WeddingProject/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "weddingHallId": weddinghallId,
            "weddingHallName": weddinghallName,
            "serviceId": "",
            "serviceName": "",
            "menuId": "",
            "menuName": "",
            "price": weddinghallPrice,
            "count": "1"
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.log(data)
        if(data != -1 && data != -2){
            let counter = document.getElementById("cartCounter");
            counter.innerText = data;
            swal("Thành công!", "Thuê sảnh cưới!", "success");
        }
        else{
            swal("Thành công!", "Cập nhật thuê sảnh!", "success");
        }
    });   
}

function addServiceToCart(serviceId, serviceName, servicePrice) {
    event.preventDefault();
    fetch("/WeddingProject/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "weddingHallId": "",
            "weddingHallName": "",
            "serviceId": serviceId,
            "serviceName": serviceName,
            "menuId": "",
            "menuName": "",
            "price": servicePrice,
            "count": "1"
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        if(data != -2){
            let counter = document.getElementById("cartCounter");
            counter.innerText = data;
            swal("Thành công!", "Thuê dịch vụ!", "success");
        }
        else{
            swal("Thất bại!", "Dịch vụ đã thuê vui lòng chọn dịch vụ khác!", "warning");
        }
    });
}

function addMenuToCart(menuId, menuName, menuPrice) {
    event.preventDefault();
    fetch("/WeddingProject/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "weddingHallId": "",
            "weddingHallName": "",
            "serviceId": "",
            "serviceName": "",
            "menuId": menuId,
            "menuName": menuName,
            "price": menuPrice,
            "count": "1"
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res) {
        
        return res.json();
    }).then(function(data) {
        if(data != -1 && data != -2){
            let counter = document.getElementById("cartCounter");
            counter.innerText = data;
            swal("Thành công!", "Đặt thực đơn!", "success");
        }
        else{
            swal("Thành công!", "Cập nhật đặt thực đơn!", "success");
        }
    });   
}

function deleteWeddinghall(weddingHallId) {
    fetch(`/WeddingProject/api/cart/weddinghall/${weddingHallId}`, {
        method : 'delete'
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
    });
    location.reload();
}

function deleteService(serviceId) {
    fetch(`/WeddingProject/api/cart/service/${serviceId}`, {
        method : 'delete'
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
    });
    location.reload();
} 

function deleteMenu(menuId) {
    fetch(`/WeddingProject/api/cart/menu/${menuId}`, {
        method : 'delete'
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
    });
    location.reload();
} 

function addComment(weddingId) {
    
    fetch("/WeddingProject/api/add-comment", {
        method: "post", 
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "weddingId": weddingId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        console.info(res);
        return res.json();
    }).then(function(data){
        console.info(data);
        
        let area = document.getElementById("commentArea");
        
        area.innerHTML = `
            <div class="row">
                <div class="col-md-1" style="padding: 10px">
                    <img class="rounded-circle img-fluid" src="${data.user.avatar}" />
                </div>
                <div class="col-md-11 my-date">
                    <p>${data.content}</p>  
                    <i>${moment(data.createdDate).fromNow()}</i>
                </div>
            </div>
        ` + area.innerHTML;
        
    });
}

function pay() {
    
    fetch("/WeddingProject/api/pay", {
        method: "post", 
        body: JSON.stringify({
            "organizeDate": document.getElementById("organizeDate").value,
            "description": document.getElementById("description").value,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json();
    }).then(function(code){
        console.info(code);
        if(code == "BAD_REQUEST")
            swal("Thất bại!", "Thanh toán thất bại!", "warning");
        else{
            location.href = "/WeddingProject/wedding";
        }
    })
}

function numberDesk(obj){
    fetch("/WeddingProject/api/cart/numberDesk", {
        method: "post",
        body: JSON.stringify({
            "numberDesk": obj.value
        }),
        headers:{
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json();
    }).then(function(data){
        console.info(data);
        let amount = document.getElementById("amount");
        amount.innerHTML = `Tổng tiền: <span>${data}</span> VNĐ`
    });
}

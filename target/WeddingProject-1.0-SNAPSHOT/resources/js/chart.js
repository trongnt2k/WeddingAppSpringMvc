/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function randomColor(){
        let r = parseInt(Math.random()*255);
        let g = parseInt(Math.random()*255);
        let b = parseInt(Math.random()*255);

        return `rgb(${r}, ${g}, ${b})`
    }
    
function weddingChart(id, weddingLabels=[], weddingInfo=[]){
    let colors = []
        for (let i = 0; i < weddingInfo.length; i++)

    colors.push(randomColor())
    data = {
        labels: weddingLabels,
        datasets: [{
            label: 'Thống kê mật độ tiệc cưới',
            data: weddingInfo,
            backgroundColor: colors,
            hoverOffset: 4
          }]
    };
    const config = {
        type: 'line',
        data: data,
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
}

function weddingRevenueChart(id, weddingRevenueLabels=[], weddingRevenueInfo=[]){
    let colors = []
        for (let i = 0; i < weddingRevenueInfo.length; i++)

    colors.push(randomColor())
    data = {
        labels: weddingRevenueLabels,
        datasets: [{
            label: 'Thống kê mật độ tiệc cưới',
            data: weddingRevenueInfo,
            backgroundColor: colors,
            hoverOffset: 4
          }]
    };
    const config = {
        type: 'bar',
        data: data,
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
}



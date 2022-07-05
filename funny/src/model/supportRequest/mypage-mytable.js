


/*
    정기후원 데이터 
*/
($(document).ready(function() {
    ;
    return ($.ajax(
        {
            type :"POST", 
            url : "regInfo.me",
            data : "supporter_id" = sessionStorage.getItem("supporter_id"),
            success : (data)=>{
                console.log(data);
                JSON.parse(data)

                data.forEach(element => {
                    
                });

            },
            error: (request,error)=> {
                switch(request)  {
                    //필요한 오류만 적음
                    case 404 :
                        alert(request+"/n"+error);
                        break;
                    case 500 :
                        alert(request+"/n"+error);
                        break;
                    default :
                        alert(request+"/n"+error);
                        break;
                }
            }
        }
    ))
}))();

/*
    일시후원 데이터  
*/
($(document).ready(function() {
    ;
    return ($.ajax(
        {
            type :"POST", 
            url : "tempInfo.me",
            data : "supporter_id" = sessionStorage.getItem("supporter_id"),
            success : (data)=>{
                console.log(data);
                JSON.parse(data)

                data.forEach(element => {
                    
                });
            },
            error: (request,error)=> {
                switch(request)  {
                    //필요한 오류만 적음
                    case 404 :
                        alert(request+"/n"+error);
                        break;
                    case 500 :
                        alert(request+"/n"+error);
                        break;
                    default :
                        alert(request+"/n"+error);
                        break;
                }
            }
        }
    ))
}))();
/*
    봉사 내역 데이터 
*/
($(document).ready(function() {
    ;
    return ($.ajax(
        {
            type :"POST", 
            url : "volunInfo.me",
            data : "supporter_id" = sessionStorage.getItem("supporter_id"),
            success : (data)=>{
                console.log(data);
                JSON.parse(data)

                data.forEach(element => {
                    
                });
            },
            error: (request,error)=> {
                switch(request)  {
                    //필요한 오류만 적음
                    case 404 :
                        alert(request+"/n"+error);
                        break;
                    case 500 :
                        alert(request+"/n"+error);
                        break;
                    default :
                        alert(request+"/n"+error);
                        break;
                }
            }
        }
    ))
}))();
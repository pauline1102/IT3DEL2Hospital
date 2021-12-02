async function doLogin(){
    let formElement = document.getElementById("form");
    let formData = new FormData(formElement);
    let json = Object.fromEntries(formData);
    let res = await fetch(
        "rest/login",{
        method:"POST",
        body: JSON.stringify(json),
        headers:{
            "content-type":"application/json"
        }
    })
    // alert(res);
    let token = await res.text();
    //   alert(token);

    if (res.status==200){
        localStorage.setItem("token", token);
        console.log(token);
        window.location.href="PatientForside.html"
    }
    else{
        alert("Du er ikke logget ind")
    }

}
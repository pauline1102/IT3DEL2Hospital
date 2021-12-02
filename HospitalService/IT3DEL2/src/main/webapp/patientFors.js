async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"

}

async function gotoopretkonsultation(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers: {
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="OpretKonsultation.html"
}
async function hentKonsultationVindue(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers:{
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="HentKonsultation.html"
}
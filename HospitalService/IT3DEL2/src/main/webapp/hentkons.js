
async function hentKonsultation(){
    let result = await fetch("rest/aftaler", {
            headers: {
                "authorization": "Bearer " + localStorage.getItem("token")
            }
        }
    );
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)

    let listelements =""
    json.forEach(function(element){
        listelements +=("<li>"+element.date+"</li>")
    })

    let list = document.getElementById("aftaler");
    list.innerHTML=listelements
}



//MÅSKE ANVEND DET HER TIL AT HENTE CPR FRA FORM osv..... :)
async function hentCpr() {

    let form = document.getElementById("skrivcpr").value();
    let formData1 = new FormData(form)
    let patientJson = Object.fromEntries(formData1);
    let res = await fetch("rest/aftaler", {
        method: "POST",
        body: JSON.stringify(patientJson),
        headers: {
            'content-type': "application/json",
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    });
    if (res.status != 200) {
        alert("cpr gik galt")
    }
}
    /*
    let json1 = await result1.json1();
    console.log(json1)

    let listelements1 =""
    json1.forEach(function(element){
        listelements1 +=("<li>"+element.cpr+"</li>")
    })

    let list1 = document.getElementById("cprnr");
    list1.innerHTML=listelements1
}

     */


    /*
    function loadAddresses(){
      fetch('http://dawa.aws.dk/vejnavne/autocomplete?q=' +
    document.getElementById("input").value)
    .then(function(res){
    res.json()
        .then(function(json){
            //do something with the data
    }
            )
    ;
    }


     */

    async function Logud() {
        localStorage.setItem("token", " ");
        window.location.href = "index.html"
}

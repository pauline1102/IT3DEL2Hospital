async function opretKonsultation() {

    let form = document.getElementById("aftaleform");
    let formData = new FormData(form)
    let patientJson = Object.fromEntries(formData);
    let res = await fetch("rest/aftaler", {
        method: "POST",
        body: JSON.stringify(patientJson),
        headers: {
            'content-type': "application/json",
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    })
}
    async function Tilbage(){
        window.location.href = "PatientForside.html"
    }
    async function Logud() {
        localStorage.setItem("token", " ");
        window.location.href = "index.html"

}
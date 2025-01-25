// script.js
document.addEventListener("DOMContentLoaded", function () {
    fetchVehicles();
    const addVehicleForm = document.getElementById("addVehicleForm");
    addVehicleForm.addEventListener("submit", function (event) {
        event.preventDefault();
        addVehicle();
    });
});

function fetchVehicles() {
    fetch("data/vehicles.json")  // JSON dosyasının doğru yolu
        .then(response => response.json())
        .then(data => displayVehicles(data))
        .catch(error => console.error("Araçlar getirilirken hata oluştu", error));
}

function displayVehicles(vehicles) {
    const source = document.getElementById("vehicle-template").innerHTML;
    const template = Handlebars.compile(source);
    const html = template({ vehicles });
    document.getElementById("vehicleList").innerHTML = html;
}

function addVehicle() {
    const formData = new FormData(document.getElementById("addVehicleForm"));
    fetch("api/add_vehicle.php", {
        method: "POST",
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        fetchVehicles();
        document.getElementById("addVehicleForm").reset();
    })
    .catch(error => console.error("Araç eklenirken hata oluştu", error));
}

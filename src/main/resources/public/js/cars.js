var model;
var color;
var dailyPrice;
var date_of_announcement;
var fuel;
var gear;
var km;
var modelYear;
var plate;
var state;
var modelId;
var carStatus;
var brand;
var carId;
var photoInput;




var carData = {
    // !db den gelmeli
    //carId
    1: {
        model: 'CSL 63 AMG ',
        color: 'White',
        dailyPrice: 89,
        dateOfAnnouncement: '12/12/2023',
        fuel: 'dizel',
        gear: "Manuel",
        km: 60000,
        modelYear: 2023,
        plate: '09AED690',
        state: 'LA California',
        modelId: 44,
        carStatus: 'Good',
        brand: 'Mercedes-Benz',
        photoInput: 'images/img-1.png'
    },
    //carId
    2: {
        model: 'M5',
        color: 'White',
        dailyPrice: 89,
        dateOfAnnouncement: '12/12/2023',
        fuel: 'dizel',
        gear: "Auto",
        km: 70000,
        modelYear: 2023,
        plate: '09AED692',
        state: 'Söke',
        modelId: 45,
        carStatus: 'Good',
        brand: 'BMW',
        photoInput: 'images/img-7.png'
    },
    //carId
    3: {
        model: 'A3 ',
        color: 'White',
        dailyPrice: 89,
        dateOfAnnouncement: '12/12/2023',
        fuel: 'dizel',
        gear: "Manuel",
        km: 60000,
        modelYear: 2023,
        plate: '09AED690',
        state: 'LA California',
        modelId: 44,
        carStatus: 'Good',
        brand: 'Audi',
        photoInput: 'images/img-3.png'
    },
    //carId
    4: {
        model: 'A180',
        color: 'Grey',
        dailyPrice: 89,
        dateOfAnnouncement: '12/12/2023',
        fuel: 'dizel',
        gear: "Auto",
        km: 70000,
        modelYear: 2023,
        plate: '09AED692',
        state: 'Söke',
        modelId: 45,
        carStatus: 'Good',
        brand: 'Mercedes-Benz',
        photoInput: 'images/img-4.png'
    },
    //carId
    5: {
        model: 'X6',
        color: 'Grey',
        dailyPrice: 89,
        dateOfAnnouncement: '12/12/2023',
        fuel: 'dizel',
        gear: "Manuel",
        km: 60000,
        modelYear: 2023,
        plate: '09AED690',
        state: 'LA California',
        modelId: 44,
        carStatus: 'Good',
        brand: 'BMW',
        photoInput: 'images/img-2.png'
    },
    //carId
    6: {
        model: 'RS5',
        color: 'Red',
        dailyPrice: 89,
        dateOfAnnouncement: '12/12/2023',
        fuel: 'dizel',
        gear: "Auto",
        km: 70000,
        modelYear: 2023,
        plate: '09AED692',
        state: 'Söke',
        modelId: 45,
        carStatus: 'Good',
        brand: 'Audi',
        photoInput: 'images/img-5.png'
    },
};






document.getElementById("modelH").innerHTML =model
document.getElementById("kmH").innerHTML =km
document.getElementById("colorH").innerHTML =color
document.getElementById("priceH").innerHTML =dailyPrice
document.getElementById("date_of_announcementH").innerHTML =date_of_announcement
document.getElementById("fuelH").innerHTML =fuel
document.getElementById("modelYearH").innerHTML =modelYear
document.getElementById("gearH").innerHTML =gear
document.getElementById("plateH").innerHTML =plate
document.getElementById("stateH").innerHTML =state
document.getElementById("modelIdH").innerHTML =modelId
document.getElementById("carStatusH").innerHTML =carStatus
document.getElementById("brandH").innerHTML =brand
document.getElementById("carIdH").innerHTML =carId



function displayCarDetails(carId) {
    var carDetailsContainer = document.getElementById('carDetailsContainer');
    if (carDetailsContainer) {
        var car = carData[carId];

        if (car) {
            var carDetailsHTML = `
    <div class="car-details">
        <img src="${car.photoInput}" alt="Car Photo">
        <div class="data">
            <div class="detail"><strong>Model:</strong> ${car.model}</div>
            <div class="detail"><strong>Color:</strong> ${car.color}</div>
            <div class="detail"><strong>Daily Price:</strong> $${car.dailyPrice}</div>
            <div class="detail"><strong>Date of Announcement:</strong> ${car.dateOfAnnouncement}</div>
            <div class="detail"><strong>Fuel:</strong> ${car.fuel}</div>
            <div class="detail"><strong>Gear:</strong> ${car.gear}</div>
            <div class="detail"><strong>KM:</strong> ${car.km} km</div>
            <div class="detail"><strong>Model Year:</strong> ${car.modelYear}</div>
            <div class="detail"><strong>Plate:</strong> ${car.plate}</div>
            <div class="detail"><strong>State:</strong> ${car.state}</div>
            <div class="detail"><strong>Model ID:</strong> ${car.modelId}</div>
            <div class="detail"><strong>Car Status:</strong> ${car.carStatus}</div>
            <div class="detail"><strong>Brand:</strong> ${car.brand}</div>
        </div>
    </div>
`;

// Yukarıda verilere "detail" sınıfı eklenmiştir.

            carDetailsContainer.innerHTML = carDetailsHTML;
        } else {
            carDetailsContainer.innerHTML = '<p>Car not found.</p>';
        }
    }
}

function init() {
    displayCarDetails(4); // DB den gelicek (carId)
}


// Sayfanın tamamen yüklendiğinde init fonksiyonunu çağır
document.addEventListener('DOMContentLoaded', init);
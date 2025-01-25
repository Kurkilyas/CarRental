// Örnek bir carData dizisi
var carData = [
    {carId, model: 'CSL 63 AMG', color: 'White', dailyPrice: 89, image: 'images/img-3.png' },
    {carId, model: 'M5', color: 'White', dailyPrice: 89, image: 'images/amg1.png' },
    {carId, model: 'CSL 63 AMG', color: 'White', dailyPrice: 89, image: 'images/img-3.png' },
    {carId, model: 'M5', color: 'White', dailyPrice: 89, image: 'images/amg1.png' },
    {carId, model: 'CSL 63 AMG', color: 'White', dailyPrice: 89, image: 'images/img-3.png' },
    {carId, model: 'M5', color: 'White', dailyPrice: 89, image: 'images/amg1.png' },
    {carId, model: 'CSL 63 AMG', color: 'White', dailyPrice: 89, image: 'images/img-3.png' },
    {carId, model: 'M5', color: 'White', dailyPrice: 89, image: 'images/amg1.png' },
    {carId, model: 'CSL 63 AMG', color: 'White', dailyPrice: 89, image: 'images/img-3.png' },
    {carId, model: 'M5', color: 'White', dailyPrice: 89, image: 'images/amg1.png' },
    {carId, model: 'CSL 63 AMG', color: 'White', dailyPrice: 89, image: 'images/img-3.png' },
    {carId, model: 'M5', color: 'White', dailyPrice: 89, image: 'images/amg1.png' },
];

window.onload = function () {
    listCarListings();
};

function addCarListing(car) {
    var carListingsContainer = document.getElementById('carListingsContainer');

    var carBox = document.createElement('div');
    carBox.className = 'car-box';

    var carHTML = `
        <div class="action-buttons">
            <button onclick="rentCar(${car.carId})">Rent</button>
        </div>
        <img src="${car.image}" alt="Car Photo" class="car-image">
        <p><strong>Model:</strong> ${car.model}</p>
        <p><strong>Color:</strong> ${car.color}</p>
        <p><strong>Daily Price:</strong> $${car.dailyPrice}</p>
    `;

    carBox.innerHTML = carHTML;

    carListingsContainer.appendChild(carBox);
}

function listCarListings() {
    carData.forEach(function(car) {
        addCarListing(car);
    });
}

function rentCar(carId) {
    // Rent işlemleri için carId'yi kullanabilirsiniz
    console.log(`Rent button clicked for carId: ${carId}`);
}

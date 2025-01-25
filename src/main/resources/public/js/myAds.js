
// Örnek veritabanı verileri
var cars = [
    { imgSrc: "images/img-1.png", modelName: "Mercedes-Benz Class C", price: "$69", editLink: "rentCar1.html", deleteLink: "rentCar1.html" },
    { imgSrc: "images/img-7.png", modelName: "BMW 5", price: "$59", editLink: "rentCar2.html", deleteLink: "rentCar2.html" },
    { imgSrc: "images/img-1.png", modelName: "Mercedes-Benz Class C", price: "$69", editLink: "rentCar1.html", deleteLink: "rentCar1.html" },
    { imgSrc: "images/img-7.png", modelName: "BMW 5", price: "$59", editLink: "rentCar2.html", deleteLink: "rentCar2.html" },{ imgSrc: "images/img-1.png", modelName: "Mercedes-Benz Class C", price: "$69", editLink: "rentCar1.html", deleteLink: "rentCar1.html" },
    { imgSrc: "images/img-7.png", modelName: "BMW 5", price: "$59", editLink: "rentCar2.html", deleteLink: "rentCar2.html" }
];
// Galeri bölümünü doldurma fonksiyonu
function populateGallery() {
    var galleryContainer = document.getElementById('galleryContainer');
    // Önceki içeriği temizle
    galleryContainer.innerHTML = '';

    for (var i = 0; i < cars.length; i += 3) {
        var ilanGrupDiv = document.createElement('div');
        ilanGrupDiv.className = 'ilan-grup';

        for (var j = 0; j < 3; j++) {
            var ilanIndex = i + j;
            if (ilanIndex < cars.length) {
                var galleryBox = document.createElement('div');
                galleryBox.className = 'gallery_box';

                var img = document.createElement('img');
                img.src = cars[ilanIndex].imgSrc;
                galleryBox.appendChild(img);

                var modelName = document.createElement('h3');
                modelName.className = 'types_text';
                modelName.textContent = cars[ilanIndex].modelName;
                galleryBox.appendChild(modelName);

                var price = document.createElement('p');
                price.className = 'looking_text';
                price.textContent = 'Start per day ' + cars[ilanIndex].price;
                galleryBox.appendChild(price);

                var editLink = document.createElement('a');
                editLink.href = cars[ilanIndex].editLink;
                editLink.textContent = 'Edit';
                var editButton = document.createElement('div');
                editButton.className = 'read_bt';
                editButton.appendChild(editLink);
                galleryBox.appendChild(editButton);

                var deleteLink = document.createElement('a');
                deleteLink.href = '#';  // "#" kullanarak sayfanın en üstüne gitmeyi engeller
                deleteLink.textContent = 'Delete';

                // İlanın indeksini kullanarak delete olayını tetikleyen fonksiyonu çağır
                deleteLink.onclick = function(index) {
                    return function() {
                        deleteCar(index);
                    };
                }(ilanIndex);

                var deleteButton = document.createElement('div');
                deleteButton.className = 'read_bt';
                deleteButton.appendChild(deleteLink);
                galleryBox.appendChild(deleteButton);

                ilanGrupDiv.appendChild(galleryBox);
            }
        }

        galleryContainer.appendChild(ilanGrupDiv);
    }
}

// İlanı listeden kaldıran fonksiyon
function deleteCar(index) {
    cars.splice(index, 1);
    // Galeriyi tekrar oluştur
    populateGallery();
}

// Sayfa yüklendiğinde galeriyi doldurma
window.onload = populateGallery;

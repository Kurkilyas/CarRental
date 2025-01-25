$(document).ready(function () {
    // Sayfa yüklendiğinde araçları çek ve tabloyu güncelle
    updateCarTable();

    // İlan ekleme butonuna tıklanınca yeni satır ekle
    $("#addCarButton").click(function () {
        // Yeni araç verilerini alın (örneğin bir formdan)
        const newCar = {
            model: $("#modelInput").val(),
            color: $("#colorInput").val(),
            price: $("#priceInput").val()
        };

        // Veritabanına yeni aracı ekleyin (AJAX veya başka bir yöntem kullanabilirsiniz)

        // Ardından tabloyu güncelleyin
        addCarRow(newCar);
    });
});

function updateCarTable() {
    // PostgreSQL'den araçları çekmek için AJAX veya başka bir yöntem kullanabilirsiniz
    // Bu örnekte statik bir dizi kullanılıyor
    const carsFromDatabase = [
        { model: "BMW", color: "Black", price: "$99" },
        { model: "Audi", color: "Red", price: "$79" },
        // Diğer araçlar...
    ];

    // Tabloyu temizle
    clearTable();

    // Veritabanından alınan her araç için satır ekleyin
    carsFromDatabase.forEach(addCarRow);
}

function clearTable() {
    $("#carTableBody").empty(); // jQuery kullanarak tabloyu temizle
}

function addCarRow(car) {
    // Yeni bir satır oluşturun ve tabloya ekleyin
    const newRow = $("<tr>");
    newRow.append(`<td>${car.model}</td>`);
    newRow.append(`<td>${car.color}</td>`);
    newRow.append(`<td>${car.price}</td>`);

    // Tabloya yeni satırı ekle
    $("#carTableBody").append(newRow);
}

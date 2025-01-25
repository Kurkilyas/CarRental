// JavaScript (yourDatabaseScript.js) kısmı
document.addEventListener("DOMContentLoaded", function () {
    // Sayfa yüklendiğinde çalışacak kodlar buraya gelecek
    // Veritabanından araçları çek ve tabloyu güncelle
    updateCarTable();
});

function updateCarTable() {
    // Veritabanından araçları çekmek için AJAX veya başka bir yöntem kullanabilirsiniz
    // Bu örnekte statik bir dizi kullanılıyor
    const carsFromDatabase = [
        { photo: "images/egea.png", brand: "BMW", color: "Black", price: "$99" },
        { photo: "images/blueBmw.png", brand: "BMW", color: "Blue", price: "$99" },
        { photo: "images/BMW3.png", brand: "BMW", color: "Black", price: "$89" },
        { photo: "images/img-5.png", brand: "Audi", color: "Red", price: "$79" },
        { photo: "images/img-7.png", brand: "BMW", color: "White", price: "$99" }
        
    ];

    // Tabloyu temizle
    clearTable();

    // Veritabanından alınan her araç için satır ekleyin
    carsFromDatabase.forEach(addCarRow);
}

function clearTable() {
    const tableBody = document.getElementById("carTableBody");
    tableBody.innerHTML = ""; // Tabloyu temizle
}

function addCarRow(car) {
    // Yeni bir satır oluşturun ve tabloya ekleyin
    const tableBody = document.getElementById("carTableBody");
    const newRow = tableBody.insertRow(tableBody.rows.length);

    // Sütun değerlerini kullanarak satırı doldurun
    const cell1 = newRow.insertCell(0);
    cell1.innerHTML = <img src="${car.photo}" alt="Car Image">;

    const cell2 = newRow.insertCell(1);
    cell2.textContent = car.brand;

    const cell3 = newRow.insertCell(2);
    cell3.textContent = car.color;

    const cell4 = newRow.insertCell(3);
    cell4.textContent = car.price;

    const cell5 = newRow.insertCell(4);
    cell5.innerHTML = <a href="bookNow.html"><button>View</button></a>;
}
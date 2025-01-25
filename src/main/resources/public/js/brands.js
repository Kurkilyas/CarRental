document.addEventListener("DOMContentLoaded", function () {
    // Araba markalarını temsil eden bir dizi
    const carBrands = ["Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Mercedes-Benz" ,"Audi","Toyota", "Honda", "Ford", "Chevrolet", "BMW"];

    // Marka butonlarını içeren container
    const brandButtonsContainer = document.getElementById("brand-buttons-container");

    // Her marka için bir buton oluştur
    carBrands.forEach(brand => {
        const button = document.createElement("button");
        button.className = "brand-button";
        button.textContent = brand;
        button.addEventListener("click", function () {
            // Butona tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz.
            alert("Seçilen Marka: " + brand);
        });

        brandButtonsContainer.appendChild(button);
    });
});

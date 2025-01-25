$(document).ready(async function () {
    // Dropdown'ları doldurmak için genel fonksiyon (async olarak düzenlendi)
    async function fillDropdownList(elementId, apiUrl) {
        try {
            const response = await fetch(apiUrl);
            if (!response.ok) {
                throw new Error(`${elementId} dropdown verisi alınamadı.`);
            }

            const data = await response.json();
            console.log(`Dropdown verisi (${elementId}):`, data); // Hata ayıklama için

            const dropdown = $(`#${elementId}`);
            dropdown.empty();
            dropdown.append(new Option("Seçiniz", "")); // Varsayılan seçenek
            $.each(data, function (index, item) {
                dropdown.append(new Option(item.name, item.id));
            });
        } catch (error) {
            console.error(`${elementId} doldurulurken hata oluştu:`, error);
        }
    }

    // Tüm dropdownları doldur
    try {
        await Promise.all([
            fillDropdownList("modelId", "/api/models"),
            fillDropdownList("colorId", "/api/colors"),
            fillDropdownList("stateId", "/api/states"),
            fillDropdownList("fuelId", "/api/fuels"),
            fillDropdownList("gearId", "/api/gears"),
            fillDropdownList("statusId", "/api/statuses"),
        ]);
        console.log("Tüm dropdownlar başarıyla dolduruldu.");
    } catch (error) {
        console.error("Dropdown yükleme sırasında hata oluştu:", error);
    }

    // Araç verilerini ID ile getirme
    $("#getCarButton").click(async function () {
        const carId = $("#Id").val(); // Id alanındaki değeri al

        if (!carId) {
            alert("Lütfen bir Id girin!");
            return;
        }

        try {
            // API çağrısı yap
            const response = await fetch(`/cars/${carId}`, {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                },
            });

            if (!response.ok) {
                throw new Error("Araç bilgisi alınamadı.");
            }

            const carData = await response.json();
            console.log("Gelen Veri:", carData); // Hata ayıklama için

            // Text inputları doldur
            $("#plate").val(carData.plate);
            $("#dailyPrice").val(carData.dailyPrice);
            $("#dateOfAnnouncement").val(carData.dateOfAnnouncement);
            $("#modelYear").val(carData.modelYear);
            $("#km").val(carData.km);

            // Select elementlerini doldur (id değerlerine göre seçim yap)
            $("#modelId").val(carData.modelId).trigger("change");
            $("#colorId").val(carData.colorId).trigger("change");
            $("#stateId").val(carData.stateId).trigger("change");
            $("#fuelId").val(carData.fuelId).trigger("change");
            $("#gearId").val(carData.gearId).trigger("change");
            $("#statusId").val(carData.statusId).trigger("change");

            $("#success-message")
                .text("Araç bilgileri başarıyla getirildi.")
                .css("color", "green")
                .show();
        } catch (error) {
            console.error("Hata:", error);
            $("#success-message")
                .text(error.message || "Bir hata oluştu.")
                .css("color", "red")
                .show();
        }
    });

    // Güncelleme işlemi
    $("#updateCarForm").submit(function (event) {
        event.preventDefault(); // Sayfanın yenilenmesini engelle

        const formElement = document.getElementById("updateCarForm");
        const formData = new FormData(formElement); // Form verilerini al

        // Fetch API kullanımı
        fetch("http://localhost:8090/guncelleme", {
            method: "POST",
            body: formData, // FormData nesnesi
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Sunucudan hata döndü.");
                }
                return response.json(); // JSON formatında yanıt bekleniyor
            })
            .then((data) => {
                if (data.success) {
                    // Başarı mesajını göster
                    $("#success-message")
                        .text("Güncelleme başarıyla tamamlandı!")
                        .css("color", "green")
                        .show();
                } else {
                    // Başarısız mesajını göster
                    $("#success-message")
                        .text("Güncelleme başarısız!")
                        .css("color", "red")
                        .show();
                }
            })
            .catch((error) => {
                console.error("Hata:", error);
                $("#success-message")
                    .text("Bir hata oluştu: " + error.message)
                    .css("color", "red")
                    .show();
            });
    });
});

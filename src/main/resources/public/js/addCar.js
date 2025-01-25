$(document).ready(function() {
    fillDropdownList("modelId", "/api/models");
    fillDropdownList("colorId", "/api/colors");
    fillDropdownList("stateId", "/api/states");
    fillDropdownList("fuelId", "/api/fuels");
    fillDropdownList("gearId", "/api/gears");
    fillDropdownList("statusId", "/api/statuses");
    // Diğer dropdown listelerini eklemek isterseniz buraya ekleyebilirsiniz

    $("#addCarForm").submit(function(event) {
        event.preventDefault();

        // Formu gönder ve ardından JSON yanıtını kontrol et
        $.post("/ekleme", $(this).serialize(), function(response) {
            if (response.success) {
                // Başarı mesajını göster
                $("#success-message").text(response.message);
            }
        }, "json");
    });
});


function fillDropdownList(elementId, apiUrl) {
    $.get(apiUrl, function(data) {
        console.log(data);
        var dropdown = $("#" + elementId);
        dropdown.empty();
        $.each(data, function(index, item) {
            dropdown.append($("<option></option>")
                .attr("value", item.id)
                .text(item.name));
        });
    });
}

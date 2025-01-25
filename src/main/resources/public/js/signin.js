document.getElementById("signinForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Varsayılan form gönderimini engelle

    // Form verilerini al
    const formData = new FormData(event.target);
    const formObject = {};
    formData.forEach((value, key) => formObject[key] = value);

    // Backend'e POST isteği gönder
    fetch("/api/employees", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formObject)
    })
        .then(response => {
            if (response.ok) {
                return response.text(); // Backend'den gelen mesaj
            } else {
                return response.text().then(error => { throw new Error(error); });
            }
        })
        .then(message => {
            // Kayıt başarılı olduğunda mesaj göster ve login sayfasına yönlendir
            const messageDiv = document.getElementById("message");
            messageDiv.style.color = "green";
            messageDiv.textContent = message + ". Redirecting to Login...";
            setTimeout(() => {
                window.location.href = "/login.html";
            }, 3000);
        })
        .catch(error => {
            // Kayıt başarısız olduğunda hata mesajı göster
            const messageDiv = document.getElementById("message");
            messageDiv.style.color = "red";
            messageDiv.textContent = error.message;
        });
});
console.log(JSON.stringify(formObject));
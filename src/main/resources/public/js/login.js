// Sayfa yüklendiğinde error-message'yi temizle
window.onload = function() {
    document.getElementById("error-message").style.display = "none"; // Hata mesajını gizle
    document.getElementById("error-message").textContent = ""; // Mesajı temizle
};

document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();  // Sayfa yeniden yüklenmesini engeller

    var email = document.getElementById("EmailInput").value;
    var password = document.getElementById("passwordInput").value;

    var data = {
        email: email,
        password: password
    };

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            // Eğer login başarılı ise, role bilgisine göre yönlendir
            if (data.status) {
                const role = data.role; // Backend'den dönen role bilgisi

                if (role === "ADMIN") {
                    window.location.href = "/indexAdmin.html"; // YÖNLENDİRME_YERİ (Admin sayfası)
                } else if (role === "USER") {
                    window.location.href = "/indexUser.html"; // YÖNLENDİRME_YERİ (User sayfası)
                } else {
                    // Bilinmeyen rol için hata mesajı
                    document.getElementById("error-message").style.display = "block";
                    document.getElementById("error-message").textContent = "Unknown role. Please contact support.";
                }
            } else {
                // Hata durumunda, hata mesajını göster
                document.getElementById("error-message").style.display = "block";
                document.getElementById("error-message").textContent = data.message;
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});